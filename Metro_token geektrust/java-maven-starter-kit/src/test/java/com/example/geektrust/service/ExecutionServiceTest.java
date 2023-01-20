package com.example.geektrust.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.geektrust.model.CheckIn;
import com.example.geektrust.model.EachJourneyCost;
import com.example.geektrust.model.StationStats;

public class ExecutionServiceTest {
	
	CardServiceImpl cardServiceImpl;
	
	@BeforeEach
	void setUp() {
		cardServiceImpl = new CardServiceImpl();
	}
	
	@Test
	public void passengerTypeChargeCreateTest() {
		List<String> token=new ArrayList<>();
		token.add("MC1");
		token.add("SENIOR_CITIZEN");
		token.add("AIRPORT");
		assertEquals(100, cardServiceImpl.createCheckList(token).getCharge());
	}
	
	@Test
	public void calculateEachStationStatisticsCheck() {
		Map<String,List<CheckIn>> passengerAtStation=new HashMap<>();
		
		//Input Initialization
		
		List<CheckIn> seniorCitizen=new ArrayList<>();
		CheckIn seniorCitizen1=new CheckIn("MC1", "SENIOR_CITIZEN", "CENTRAL");
		seniorCitizen1.setJourneyCost(new EachJourneyCost(0, 100));
		seniorCitizen.add(seniorCitizen1);
		passengerAtStation.put("SENIOR_CITIZEN", seniorCitizen);
		
		List<CheckIn> adult=new ArrayList<>();
		CheckIn adult1=new CheckIn("MC3", "ADULT", "CENTRAL");
		adult1.setJourneyCost(new EachJourneyCost(0, 200));
		adult.add(adult1);
		CheckIn adult2=new CheckIn("MC3", "ADULT", "CENTRAL");
		adult2.setJourneyCost(new EachJourneyCost(100, 100));
		adult.add(adult2);
		passengerAtStation.put("ADULT", adult);
		
		
		List<StationStats> stationStats=new ArrayList<>();
		
		StationStats stationStatsAdult=new StationStats("ADULT");
		stationStatsAdult.setCount(2);
		stationStatsAdult.setTotalCharges(300);
		stationStatsAdult.setTotalDiscount(100);
		stationStats.add(stationStatsAdult);
		
		StationStats stationStatsSeniorCitizen=new StationStats("SENIOR_CITIZEN");
		stationStatsSeniorCitizen.setCount(1);
		stationStatsSeniorCitizen.setTotalCharges(100);
		stationStatsSeniorCitizen.setTotalDiscount(0);
		stationStats.add(stationStatsSeniorCitizen);
		
		
		List<StationStats> output=cardServiceImpl.calculateStnStats("AIRPORT",passengerAtStation);

		//Testing
		assertEquals(output, stationStats);
	}
	
	@Test
	public void summaryTest() {
		String station="AIRPORT";
		
		List<StationStats> statsList = new ArrayList<>();
		StationStats statsAdult = new StationStats("ADULT");
		statsAdult.setCount(2);
		statsAdult.setTotalCharges(300);
		statsAdult.setTotalDiscount(100);
		statsList.add(statsAdult);
		
		StationStats stationStats = new StationStats("SENIOR_CITIZEN");
		stationStats.setCount(1);
		stationStats.setTotalCharges(100);
		stationStats.setTotalDiscount(0);
		statsList.add(stationStats);
				
		String expectOutput="ADULT 2\nSENIOR_CITIZEN 1\n";
		
		String actualOutput=cardServiceImpl.createSummary(station, statsList);
		assertEquals(expectOutput, actualOutput);
	}
	
	@Test
	public void createPassengerCheckInTest() {
		List<String> token=new ArrayList<>();
		token.add("MC1");
		token.add("SENIOR_CITIZEN");
		token.add("AIRPORT");
		
		CheckIn exceptedCheck=new CheckIn("MC1", "SENIOR_CITIZEN", "AIRPORT");
		exceptedCheck.setCharge("SENIOR_CITIZEN");
		assertEquals(exceptedCheck, cardServiceImpl.createCheckList(token));
	}
	
	

}
