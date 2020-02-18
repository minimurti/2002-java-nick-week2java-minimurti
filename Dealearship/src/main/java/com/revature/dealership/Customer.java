package com.revature.dealership;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
//import java.util.Scanner;

public class Customer extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1285296186529033766L;

	LinkedList<Car> Cars;
	
	public Customer(String name, String pwd) {
		super(name, pwd, "Customer");
		Cars = new LinkedList<Car>();
		// TODO Auto-generated constructor stub
		
	}
	
	
	public void addCar(Car carInput) {
		Cars.add(carInput);
	}
	

	@Override
	public boolean PromptUser() {
		
		System.out.println("What would you like to do?");
		System.out.println("1. Make an Offer?");
		System.out.println("2. List all cars on lot?");
		System.out.println("3. List your cars");
		System.out.println("4. List your payments");
		System.out.println("(Select option by entering a number)");
		
		int choice;
		try {
			choice = Driver.input.nextInt();
		}catch(InputMismatchException e) {
			choice = 0;
			Driver.input.next();

		}
		
		
		
		
		switch (choice) {
		case 1:
			MakeOffer();
			
			return true;
			//break;
			
		case 2:
			listCars();
			
			return true;
			///break;
			
		case 3:
			listMyCars();
			return true;
			
		case 4:
			listPayments();
			return true;

		default:
			System.out.println("Please Enter a Valid Number.");
			return true;
		}
		
		
		
		
		//return false;
	}
	
	
	
	
	private void listPayments() {
		listMyCars();
		System.out.println("Choose Car By Number: ");
		int i = Driver.input.nextInt();
		DecimalFormat numberFormat = new DecimalFormat("#.00");

		System.out.println("Total of $" + numberFormat.format(Cars.get(i).getOffer(0).getAmount()) + ", with 60 remaining payments of $" + numberFormat.format(Cars.get(i).getOffer(0).getAmount()/60) + " per month, over the course of 5 years 0% APR.");
		
		
	}


	private void MakeOffer() {
		// TODO Auto-generated method stub
		listCars();
		System.out.println("Choose Car By Number: ");
		int i = Driver.input.nextInt();
		Car carOfOffer = Driver.cfm.readCarList().get(i-1);
		
		System.out.println("Enter Amount: $");
		double amountOfOffer = Driver.input.nextDouble();
		
		
		
		
		if(Driver.cfm.AddOffer(i - 1, new Offer(this, carOfOffer, amountOfOffer))) {
			System.out.println("Offer recieved!");
		}else
			System.out.println("Invalid Input!");
		
		
		
	}

	private void listCars() {
		Driver.cfm.sysoutCarList();
	}
	

	private void listMyCars() {
		Iterator<Car> i = Cars.iterator();
		int j = 0;
		while(i.hasNext()) {
			 j++;
			 System.out.println(j + ". " + i.next());
			 
		}

	}
	
	
	
	
	
	
	

}
