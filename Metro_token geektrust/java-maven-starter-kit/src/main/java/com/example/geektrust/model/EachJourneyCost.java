package com.example.geektrust.model;

public class EachJourneyCost {
	
	private Integer discount;
	private Integer costOfJourney;
	
	
	public EachJourneyCost(Integer discount, Integer costOfJourney) {
		super();
		this.discount = discount;
		this.costOfJourney = costOfJourney;
	}


	public Integer getDiscount() {
		return discount;
	}


	public void setDiscount(Integer discount) {
		this.discount = discount;
	}


	public Integer getCostOfJourney() {
		return costOfJourney;
	}


	public void setCostOfJourney(Integer costOfJourney) {
		this.costOfJourney = costOfJourney;
	}
	
	
	

}
