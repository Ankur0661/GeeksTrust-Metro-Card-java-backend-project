package com.example.geektrust.service;

import java.util.List;

import com.example.geektrust.model.Inputs;
import com.example.geektrust.model.Passanger;

public interface CardService {
	
	public String executeCommand(List<Inputs> arguments);
	
	public Passanger intializeBalance(List<String> tokens);
	
	public void checkInProcess(List<String> tokens);
	
	public String printSummary();

}
