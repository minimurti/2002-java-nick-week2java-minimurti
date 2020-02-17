package com.revature.dealership;

public class Employee extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5552278677877348969L;

	public Employee(String name, String pwd) {
		super(name, pwd, "Employee");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean PromptUser() {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
