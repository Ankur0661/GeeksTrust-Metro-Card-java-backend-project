package com.example.geektrust.model;

import com.example.geektrust.constant.Constant;

public class CheckIn {
	
	private String metroCardNumber;
	private String passengerType;
	private String fromStation;
	private Integer charge;
	private EachJourneyCost journeyCost;
	
	
	public CheckIn(String metroCardNumber, String passengerType, String fromStation) {
		super();
		this.metroCardNumber = metroCardNumber;
		this.passengerType = passengerType;
		this.fromStation = fromStation;
		setCharge(this.passengerType);
		
	}


	


	public String getMetroCardNumber() {
		return metroCardNumber;
	}


	public void setMetroCardNumber(String metroCardNumber) {
		this.metroCardNumber = metroCardNumber;
	}


	public String getPassengerType() {
		return passengerType;
	}


	public void setPassengerType(String passengerType) {
		this.passengerType = passengerType;
	}


	public String getFromStation() {
		return fromStation;
	}


	public void setFromStation(String fromStation) {
		this.fromStation = fromStation;
	}


	public Integer getCharge() {
		return charge;
	}


	public void setCharge(String passengerType) {
		if (passengerType.equals("ADULT")) {
			this.charge = Constant.ADULT;
		} else if (passengerType.equals("SENIOR_CITIZEN")) {
			this.charge = Constant.SENIOR_CITIZEN;
		} else if (passengerType.equals("KID")) {
			this.charge = Constant.KID;
		}
	}


	public EachJourneyCost getJourneyCost() {
		return journeyCost;
	}


	public void setJourneyCost(EachJourneyCost journeyCost) {
		this.journeyCost = journeyCost;
	}





	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		if(obj==null || this.getClass()!=obj.getClass()) {
			return false;
		}
		CheckIn checkedIn=(CheckIn)obj;;
		return this.passengerType.equals(checkedIn.passengerType)
				&& this.fromStation.equals(checkedIn.fromStation)
				&& this.metroCardNumber.equals(checkedIn.metroCardNumber)
				&& this.charge.equals(checkedIn.charge);
	}
	
	
	
	
	
	
	
	


}
