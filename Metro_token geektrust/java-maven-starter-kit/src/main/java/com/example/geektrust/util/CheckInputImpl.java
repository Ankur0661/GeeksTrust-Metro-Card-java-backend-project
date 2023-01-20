package com.example.geektrust.util;

import java.util.List;

import com.example.geektrust.exceptions.MetroException;
import com.example.geektrust.model.Inputs;

public class CheckInputImpl implements CheckInputs{

	@Override
	public void commandCheck(Inputs inputs) {
		// TODO Auto-generated method stub
		
		String comand = inputs.getCommand();
		
		if(comand.equals("BALANCE")) {
			balanceCheck(inputs.getToken());
		}else if(comand.equals("CHECK_IN")) {
			
			checkInCheck(inputs.getToken());
		}else if(comand.equals("PRINT_SUMMARY")) {
			
			checkPrintSummary(inputs.getToken());
		}else {
			throw new MetroException("Invalid input, pls check.");
		}
		
	}

	public void checkPrintSummary(List<String> token) {
		// TODO Auto-generated method stub
		
		if(token.size()!=0) {
			throw new MetroException("Invalid Number of Arguments, Please validate input.");
		}
		
	}

	public void checkInCheck(List<String> token) {
		// TODO Auto-generated method stub
		
		if(token.size()!=3) {
			throw new MetroException("Invalid argument size, Validate argument");
		}
		
		String passangeType = token.get(1);
		
		if(!passangeType.equals("ADULT") && !passangeType.equals("SENIOR_CITIZEN") && !passangeType.equals("KID")) {
	    	throw new MetroException("Invalid Passenger Type, Please give valid Passenger Type.");
		}
		
		String stationFrom = token.get(2);
		
		if(!stationFrom.equals("AIRPORT") && !stationFrom.equals("CENTRAL")) {
	    	throw new MetroException("Invalid Station, Metrocard Available Stations are : 1)AIRPORT  2)CENTRAL.");
	    }
		
	}

	public void balanceCheck(List<String> token) {
		// TODO Auto-generated method stub
		
		if(token.size()!=2) {
			throw new MetroException("Invalid argument size, Validate argument.");
		}
		
		Integer bal = Integer.parseInt(token.get(1));
		
		if(bal<0) {
			throw new MetroException("blanace should not be negative, Validate argument.");
		}
		
	}

}
