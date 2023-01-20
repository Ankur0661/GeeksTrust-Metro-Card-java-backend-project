package com.example.geektrust.model;

public class Passanger {
	
	private String metroCardNo;
	private Integer balance;
	private Integer jCount;
	
	
	public Passanger(String metroCardNo, Integer balance) {
		super();
		this.metroCardNo = metroCardNo;
		this.balance = balance;
		this.jCount = 0;
	}


	public String getMetroCardNo() {
		return metroCardNo;
	}


	public void setMetroCardNo(String metroCardNo) {
		this.metroCardNo = metroCardNo;
	}


	public Integer getBalance() {
		return balance;
	}


	public void setBalance(Integer balance) {
		this.balance = balance;
	}


	public Integer getjCount() {
		return jCount;
	}


	public void setjCount(Integer jCount) {
		this.jCount = jCount;
	}
	
	
	
	

}
