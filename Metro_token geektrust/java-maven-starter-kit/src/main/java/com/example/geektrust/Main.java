package com.example.geektrust;

import java.util.List;

import com.example.geektrust.exceptions.MetroException;
import com.example.geektrust.model.Inputs;
import com.example.geektrust.service.CardService;
import com.example.geektrust.service.CardServiceImpl;
import com.example.geektrust.util.FileProcessUtil;

public class Main {
    public static void main(String[] args) {
    	try {
			if(args.length != 1) {
				throw new MetroException("Please provide the input file");
			}
			
			String path = args[0];
			metroCardProcess(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
    }

	public static String metroCardProcess(String path) {
		
		FileProcessUtil util = new FileProcessUtil(path);
		
		List<Inputs> inputs = util.getCommand();
		
		CardService cardService = new CardServiceImpl();
		
		String output = cardService.executeCommand(inputs);
		
		return output;
		
	}
}
