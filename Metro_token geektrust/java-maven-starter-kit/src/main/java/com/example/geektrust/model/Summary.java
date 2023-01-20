package com.example.geektrust.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Summary {
	
	private HashMap<String,Passanger> passangerMap;
	private List<CheckIn> checkInList;
	private Integer totalAmountAirport;
	private Integer totalAmountCentral;
	private Integer totalDiscountAirport;
	private Integer totalDiscountCentral;
	private List<String> orderByTypeAirport;
	private List<String> orderByTypeCentral;
	
	public List<String> getOrderByTypeAirport() {
		return orderByTypeAirport;
	}

	public void setOrderByTypeAirport(List<String> orderByTypeAirport) {
		this.orderByTypeAirport = orderByTypeAirport;
	}

	public List<String> getOrderByTypeCentral() {
		return orderByTypeCentral;
	}

	public void setOrderByTypeCentral(List<String> orderByTypeCentral) {
		this.orderByTypeCentral = orderByTypeCentral;
	}

	public Summary() {
		this.passangerMap=new HashMap<>();
		this.checkInList=new ArrayList<>();
		this.totalAmountAirport=0;
		this.totalAmountCentral=0;
		this.totalDiscountAirport=0;
		this.totalDiscountCentral=0;
		this.orderByTypeAirport=new ArrayList<>();
		this.orderByTypeCentral=new ArrayList<>();
	}
	
	public Integer getTotalAmountAirport() {
		return totalAmountAirport;
	}

	public void setTotalAmountAirport(Integer totalAmountAirport) {
		this.totalAmountAirport = totalAmountAirport;
	}

	public Integer getTotalAmountCentral() {
		return totalAmountCentral;
	}

	public void setTotalAmountCentral(Integer totalAmountCentral) {
		this.totalAmountCentral = totalAmountCentral;
	}

	public Integer getTotalDiscountAirport() {
		return totalDiscountAirport;
	}

	public void setTotalDiscountAirport(Integer totalDiscountAirport) {
		this.totalDiscountAirport = totalDiscountAirport;
	}

	public Integer getTotalDiscountCentral() {
		return totalDiscountCentral;
	}

	public void setTotalDiscountCentral(Integer totalDiscountCentral) {
		this.totalDiscountCentral = totalDiscountCentral;
	}

	public HashMap<String, Passanger> getPassangerMap() {
		return passangerMap;
	}
	public void setPassangerMap(HashMap<String, Passanger> passangerMap) {
		this.passangerMap = passangerMap;
	}
	public List<CheckIn> getCheckInList() {
		return checkInList;
	}
	public void setCheckInList(List<CheckIn> checkInList) {
		this.checkInList = checkInList;
	}
	
	
//	private HashMap<String,Passanger> passangerMap;
//	private List<CheckIn> checkInList;
//	private Integer totalAmountAirport;
//	private Integer totalAmountCentral;
//	private Integer totalDiscountBYAirport;
//	private Integer totalDiscountByCentral;
//	private List<String> orderByAirport;
//	private List<String> orderByCentral;
//	
//	
//	public Summary(HashMap<String, Passanger> passangerMap, List<CheckIn> checkInList, Integer totalAmountAirport,
//			Integer totalAmountCentral, Integer totalDiscountBYAirport, Integer totalDiscountByCentral,
//			List<String> orderByAirport, List<String> orderByCentral) {
//		super();
//		this.passangerMap = passangerMap;
//		this.checkInList = checkInList;
//		this.totalAmountAirport = 0;
//		this.totalAmountCentral = 0;
//		this.totalDiscountBYAirport = 0;
//		this.totalDiscountByCentral = 0;
//		this.orderByAirport = orderByAirport;
//		this.orderByCentral = orderByCentral;
//	}
//
//
//	public Summary() {
//		// TODO Auto-generated constructor stub
//	}
//
//
//	public HashMap<String, Passanger> getPassangerMap() {
//		return passangerMap;
//	}
//
//
//	public void setPassangerMap(HashMap<String, Passanger> passangerMap) {
//		this.passangerMap = passangerMap;
//	}
//
//
//	public List<CheckIn> getCheckInList() {
//		return checkInList;
//	}
//
//
//	public void setCheckInList(List<CheckIn> checkInList) {
//		this.checkInList = checkInList;
//	}
//
//
//	public Integer getTotalAmountAirport() {
//		return totalAmountAirport;
//	}
//
//
//	public void setTotalAmountAirport(Integer totalAmountAirport) {
//		this.totalAmountAirport = totalAmountAirport;
//	}
//
//
//	public Integer getTotalAmountCentral() {
//		return totalAmountCentral;
//	}
//
//
//	public void setTotalAmountCentral(Integer totalAmountCentral) {
//		this.totalAmountCentral = totalAmountCentral;
//	}
//
//
//	public Integer getTotalDiscountBYAirport() {
//		return totalDiscountBYAirport;
//	}
//
//
//	public void setTotalDiscountBYAirport(Integer totalDiscountBYAirport) {
//		this.totalDiscountBYAirport = totalDiscountBYAirport;
//	}
//
//
//	public Integer getTotalDiscountByCentral() {
//		return totalDiscountByCentral;
//	}
//
//
//	public void setTotalDiscountByCentral(Integer totalDiscountByCentral) {
//		this.totalDiscountByCentral = totalDiscountByCentral;
//	}
//
//
//	public List<String> getOrderByAirport() {
//		return orderByAirport;
//	}
//
//
//	public void setOrderByAirport(List<String> orderByAirport) {
//		this.orderByAirport = orderByAirport;
//	}
//
//
//	public List<String> getOrderByCentral() {
//		return orderByCentral;
//	}
//
//
//	public void setOrderByCentral(List<String> orderByCentral) {
//		this.orderByCentral = orderByCentral;
//	}
//	
//	
//	
//	

}
