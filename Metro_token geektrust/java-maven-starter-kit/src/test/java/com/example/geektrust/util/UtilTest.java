package com.example.geektrust.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.geektrust.model.Inputs;

public class UtilTest {
	
	private FileProcessUtil fileProcessUtil;
	
	@BeforeEach
	void setUp(){
		
		fileProcessUtil = new FileProcessUtil();
	}
	
	
	@Test
	public void parseInputTest() {
		List<String> token = new ArrayList<>();
		token.add("MC1");
		Integer bal = 100;
		
		token.add(bal.toString());
		
		Inputs exceptVal = new Inputs("BALANCE", token);
		
		Inputs actualVal = fileProcessUtil.parseInput("BALANCE MC1 100");
		
		assertEquals(actualVal, exceptVal);
	}

}
