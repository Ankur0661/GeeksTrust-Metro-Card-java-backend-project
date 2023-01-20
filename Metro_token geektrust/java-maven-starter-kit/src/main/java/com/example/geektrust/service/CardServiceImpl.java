package com.example.geektrust.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.geektrust.exceptions.MetroException;
import com.example.geektrust.model.CheckIn;
import com.example.geektrust.model.EachJourneyCost;
import com.example.geektrust.model.Inputs;
import com.example.geektrust.model.Passanger;
import com.example.geektrust.model.StationStats;
import com.example.geektrust.model.Summary;
import com.example.geektrust.util.CheckInputImpl;

public class CardServiceImpl implements CardService{
	
	private Summary summary = new Summary();

	@Override
	public String executeCommand(List<Inputs> arguments) {
		
		String output ="";
		
		for(Inputs input : arguments) {
			
			CheckInputImpl checkInputImpl = new CheckInputImpl();
			
			checkInputImpl.commandCheck(input);
			
			if(input.getCommand().equals("BALANCE")) {
				intializeBalance(input.getToken());
			}else if(input.getCommand().equals("CHECK_IN")) {
				checkInProcess(input.getToken());
			}else if(input.getCommand().equals("PRINT_SUMMARY")) {
				output = printSummary();
				
				System.out.println(output);
				
			}else {
				
				throw new MetroException("Invalid Inputs, pls check.");
			}
			
		}
		
		return output;
	}

	@Override
	public Passanger intializeBalance(List<String> tokens) {
		
		String id = tokens.get(0);
		
		Integer bal = Integer.parseInt(tokens.get(1));
		
		Passanger passanger = new Passanger(id, bal);
		
		summary.getPassangerMap().put(id, passanger);
		
		return passanger;
	}

	@Override
	public void checkInProcess(List<String> tokens) {
		// TODO Auto-generated method stub
		
		CheckIn checkIn = createCheckList(tokens);
		
		EachJourneyCost journeyCost = updateBalance(checkIn.getMetroCardNumber(), checkIn.getCharge());
		
		checkIn.setJourneyCost(journeyCost);
		
		if(checkIn.getFromStation().equals("AIRPORT") && summary.getOrderByTypeAirport().contains(checkIn.getPassengerType())) {
			summary.getOrderByTypeAirport().add(checkIn.getPassengerType());
		}
		
		if(checkIn.getFromStation().equals("CENTRAL") && !summary.getOrderByTypeCentral().contains(checkIn.getPassengerType())) {
			summary.getOrderByTypeCentral().add(checkIn.getPassengerType());
		}
		
		summary.getCheckInList().add(checkIn);
	}

	@Override
	public String printSummary() {
		// TODO Auto-generated method stub
		String output = calculateStatics(summary.getCheckInList());
		return output;
	}
	
	
	public String calculateStatics(List<CheckIn> checkInList) {
		// TODO Auto-generated method stub
		
		Map<String, List<CheckIn>> passangerOnAirport = checkInList.stream().filter(curr -> curr.getFromStation().equals("AIRPORT"))
				.collect(Collectors.groupingBy(curr -> curr.getPassengerType()));
		
		List<StationStats> airportStatics = calculateStnStats("AIRPORT", passangerOnAirport);
		
		String airportSummry = createSummary("AIRPORT", airportStatics);
		
		
		
		Map<String, List<CheckIn>> passangerOnCentral = checkInList.stream().filter(curr -> curr.getFromStation().equals("CENTRAL"))
				.collect(Collectors.groupingBy(curr -> curr.getPassengerType()));
		
		List<StationStats> centraltStatics = calculateStnStats("CENTRAL", passangerOnCentral);
		
		String centralSummry = createSummary("CENTRAL", centraltStatics);
		
		
		String ans="";
		
		ans+="TOTAL_COLLECTION CENTRAL "+summary.getTotalAmountCentral()+" "+summary.getTotalDiscountCentral()+"\n";
		
		ans+="PASSENGER_TYPE_SUMMARY\n";
		
		ans+=centralSummry;
		
		ans+="TOTAL_COLLECTION AIRPORT "+summary.getTotalAmountAirport()+" "+summary.getTotalDiscountAirport()+"\n";
		
		ans+="PASSENGER_TYPE_SUMMARY\n";
		
		ans+=airportSummry;
		
		return ans;	
		
	}

	public String createSummary(String station, List<StationStats> stationStats) {
		// TODO Auto-generated method stub
		
		String output = "";
		int totalAmount = 0;
		int totalDiscount = 0;
		
		for(StationStats stats : stationStats) {
			
			totalAmount+=stats.getTotalCharges();
			totalDiscount+=stats.getTotalDiscount();
			
			output+=stats.getPassengerType()+" "+stats.getCount()+"\n";
		}
		
		if(station.equals("AIRPORT")) {
			summary.setTotalAmountAirport(totalAmount);
			summary.setTotalDiscountAirport(totalDiscount);
			
		}
		
		else if(station.equals("CENTRAL")) {
			summary.setTotalAmountCentral(totalAmount);
			summary.setTotalDiscountCentral(totalDiscount);
		}
		
		return output;
	}

	public List<StationStats> calculateStnStats(String fromStation, Map<String, List<CheckIn>> passangerOnStation) {
		// TODO Auto-generated method stub
		
		List<StationStats> stationStats = new ArrayList<>();
		
		for(Map.Entry<String, List<CheckIn>> current: passangerOnStation.entrySet()) {
			
			StationStats stats = new StationStats(current.getKey());
			
			if(fromStation.equals("AIRPORT")) {
				
				stats.setOrderByType(summary.getOrderByTypeAirport().indexOf(current.getKey()));
			}
			
			if(fromStation.equals("CENTRAL")) {
				
				stats.setOrderByType(summary.getOrderByTypeCentral().indexOf(current.getKey()));
			}
			
			for(CheckIn checkIn : current.getValue()) {
				stats.setCount(stats.getCount()+1);
				stats.setTotalCharges(stats.getTotalCharges()+checkIn.getJourneyCost().getCostOfJourney());
				stats.setTotalDiscount(stats.getTotalDiscount()+checkIn.getJourneyCost().getDiscount());
			}
			
			stationStats.add(stats);
		}
		
		stationStats = sortOnAmount(stationStats);
		return stationStats;
	}

	public List<StationStats> sortOnAmount(List<StationStats> stationStats) {
		// TODO Auto-generated method stub
		
		
		Comparator<StationStats> compareByAmount = (StationStats a1, StationStats a2) -> a2.getTotalCharges().compareTo(a1.getTotalCharges());
		Comparator<StationStats> compareByType = (StationStats a1, StationStats a2) -> a1.getOrderByType().compareTo(a2.getOrderByType());
		
		Collections.sort(stationStats,compareByAmount.thenComparing(compareByType));
		return stationStats;
	}

	public CheckIn createCheckList(List<String> tokens) {
		
		String id = tokens.get(0);
		String type = tokens.get(1);
		String station = tokens.get(2);
		CheckIn in = new CheckIn(id, type, station);
		
		return in;
	}
	
	public EachJourneyCost updateBalance(String id, int charge) {
		
		int totalCollection = 0;
		int discount = 0;
		
		Passanger curr = summary.getPassangerMap().get(id);
		
		if(curr == null) {
			throw new MetroException("User not found/registered");
		}
		
		curr.setjCount(curr.getjCount()+1);
		
		if(curr.getjCount()%2 == 0) {
			
			charge = charge/2;
			discount=charge;
		}
		if(curr.getBalance() < charge) {
			
			int reqBal = charge - curr.getBalance();
			
			totalCollection+=0.02*reqBal;
			
			curr.setBalance(0);
		}else {
			
			curr.setBalance(curr.getBalance()-charge);
		}
		
		totalCollection+=charge;
		
		EachJourneyCost journeyCost = new EachJourneyCost(discount, totalCollection);
		return journeyCost;
	}

}
