package com.example.geektrust.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.example.geektrust.exceptions.MetroException;
import com.example.geektrust.model.Inputs;

public class FileProcessUtil {
	
	private String file_path;
	
	public FileProcessUtil() {
		// TODO Auto-generated constructor stub
	}
	
	public FileProcessUtil(String file_path) {
		this.file_path = file_path;
	}
	
	
//	collecting the input
	
	public List<Inputs> getCommand(){
		
		try (Stream<String> inputLines  = Files.lines(Paths.get(this.file_path))) {
			return inputLines .filter(line -> !isEmptyOrComment(line)).map(line -> parseInput(line))
					.collect(Collectors.toList());
		} catch (IOException e) {
			throw new MetroException("error occurred while processing input file");
		}
		
	}

	public Inputs parseInput(String str) {
		try {
			String[] commandWithArguments = str.split(" ");
			List<String> tokens = Arrays.stream(commandWithArguments).skip(1).collect(Collectors.toList());
			Inputs input = new Inputs(commandWithArguments[0], tokens);
			return input;
		} catch (Exception e) {
			throw new UnsupportedOperationException("Invalid Command executed: " + str);
		}
	}

	private boolean isEmptyOrComment(String line) {
		return line.trim().isEmpty() || line.trim().startsWith("#");
	}

}
