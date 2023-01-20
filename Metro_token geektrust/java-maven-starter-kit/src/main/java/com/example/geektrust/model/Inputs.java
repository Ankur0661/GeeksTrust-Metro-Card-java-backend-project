package com.example.geektrust.model;

import java.util.List;
import java.util.Objects;

public class Inputs {
	
	
	private String command;
	private List<String> token;
	
	public Inputs(String command, List<String> token) {
		super();
		this.command = command;
		this.token = token;
	}
	
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public List<String> getToken() {
		return token;
	}
	public void setToken(List<String> token) {
		this.token = token;
	}
	
	
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Inputs other = (Inputs) obj;
//		return Objects.equals(command, other.command) && Objects.equals(token, other.token);
//	}
	
	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		if(obj==null || this.getClass()!=obj.getClass()) {
			return false;
		}
		Inputs inputCommand=(Inputs)obj;;
		return this.command.equals(inputCommand.command)
				&& this.token.equals(inputCommand.token);
	}
	

}
