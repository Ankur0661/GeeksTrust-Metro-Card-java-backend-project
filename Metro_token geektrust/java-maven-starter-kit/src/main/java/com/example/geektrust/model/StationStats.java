package com.example.geektrust.model;

import java.util.Objects;

public class StationStats {
	
	
	private Integer count;
	private String passengerType;
	private Integer totalCharges;
	private Integer totalDiscount;
	private Integer orderByType;
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getPassengerType() {
		return passengerType;
	}
	public void setPassengerType(String passengerType) {
		this.passengerType = passengerType;
	}
	public Integer getTotalCharges() {
		return totalCharges;
	}
	public void setTotalCharges(Integer totalCharges) {
		this.totalCharges = totalCharges;
	}
	public Integer getTotalDiscount() {
		return totalDiscount;
	}
	public void setTotalDiscount(Integer totalDiscount) {
		this.totalDiscount = totalDiscount;
	}
	public Integer getOrderByType() {
		return orderByType;
	}
	public void setOrderByType(Integer orderByType) {
		this.orderByType = orderByType;
	}
	public StationStats(String passengerType) {
		super();
		this.count = 0;
		this.passengerType = passengerType;
		this.totalCharges = 0;
		this.totalDiscount = 0;
		
	}
	@Override
	public int hashCode() {
		return Objects.hash(count, orderByType, passengerType, totalCharges, totalDiscount);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StationStats other = (StationStats) obj;
		return Objects.equals(count, other.count) && Objects.equals(orderByType, other.orderByType)
				&& Objects.equals(passengerType, other.passengerType)
				&& Objects.equals(totalCharges, other.totalCharges)
				&& Objects.equals(totalDiscount, other.totalDiscount);
	}
	
	
	
	

}
