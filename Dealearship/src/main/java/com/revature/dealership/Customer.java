package com.revature.dealership;

public class Customer extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1285296186529033766L;

	public Customer(String name, String pwd) {
		super(name, pwd, "Customer");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean PromptUser() {
		// TODO Auto-generated method stub
		System.out.println("Welcome " + this.getName() + "! What Would you like to do?");
	
		return false;
	}
	

}
