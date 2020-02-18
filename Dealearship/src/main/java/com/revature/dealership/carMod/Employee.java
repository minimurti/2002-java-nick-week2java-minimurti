package com.revature.dealership.carMod;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.LinkedList;

//import java.util.Iterator;

import com.revature.dealership.Car;
import com.revature.dealership.Driver;
import com.revature.dealership.Offer;
//import com.revature.dealership.Offer;
import com.revature.dealership.User;

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
		
		System.out.println("Would you like to:");
		System.out.println("1. Add a Car to the Lot?");
		System.out.println("2. List all the Cars?");
		System.out.println("3. List all offers?");
		System.out.println("4. Accept an offer?");
		System.out.println("5. Reject an offer?");
		System.out.println("6. Remove a Car to the Lot?");
		System.out.println("7. List Payments?");
		System.out.println("(Select option by entering a number)");
		
		
		int choice = Driver.input.nextInt();
		
		switch (choice) {
		case 1:
			AddCarToLot();
			
			return true;
			//break;
			
		case 2:
			listCars();
			
			return true;
			///break;
			
		case 3:
			listOffers();
			return true;
			
		case 4:
			AcceptOffer();
			return true;
		
		case 5:
			RejectOffer();
			return true;
			
		case 6:
			RemoveCar();
			return true;
			
			
		case 7:
			ListAllPayments();
			return true;

		default:
			System.out.println("Please Enter a Valid Number.");
			break;
		}
		
		
		
		
		return false;
	}

	private void ListAllPayments() {
		// TODO Auto-generated method stub
		LinkedList<Offer> out = Driver.cfm.getAcceptedOfferList();
		Iterator<Offer> i = out.iterator();
		
		DecimalFormat numberFormat = new DecimalFormat("#.00");
		Offer current = null;
		while(i.hasNext()){
			current = i.next();
			System.out.println(current.getOfferer() + " owes a total of $" + numberFormat.format(current.getAmount()) + ", with 60 remaining payments of $" + numberFormat.format(current.getAmount()/60) + " per month, over the course of 5 years 0% APR.\n");
			
		}
		
		
	}

	private void AcceptOffer() {
		listCars();
		System.out.println("Select a Car by Number");
		int i = Driver.input.nextInt();
		System.out.println("Choose offer by Number");
		//list the offers on a car
		Driver.cfm.readCarList().get(i-1).PrintOffers();
		int j = Driver.input.nextInt();
		User Offereee = Driver.cfm.readCarList().get(i-1).getOfferUser(j-1);
		
		Driver.cfm.AcceptOffer(i -1 , Offereee);
		
		Driver.ufm.AddCartoUser(Offereee, Driver.cfm.readCarList().get(i-1));
		
		
		
		
//		
//		String username = Driver.input.next();
//		
//		Driver.cfm.readCarList().get(i).
		
		
	}
	
	
	
	private void RejectOffer() {
		listCars();
		System.out.println("Select a Car by Number");
		int i = Driver.input.nextInt();
		System.out.println("Choose offer by Number");
		//list the offers on a car
		Driver.cfm.readCarList().get(i-1).PrintOffers();
		int j = Driver.input.nextInt();
		//User Offereee = Driver.cfm.readCarList().get(i-1).getOfferUser(j-1);
		
		Driver.cfm.RejectOffer(i-1,j-1);
	
		
		
//		
//		String username = Driver.input.next();
//		
//		Driver.cfm.readCarList().get(i).
		
		
	}


	private void AddCarToLot(){
		
		System.out.println("Enter Make: ");
		String make = Driver.input.next();
		System.out.println("Enter Model: ");
		String model = Driver.input.next();
		System.out.println("Enter Year: ");
		int year = Driver.input.nextInt();
		System.out.println("Enter Color: ");
		String color = Driver.input.next();
		System.out.println("Enter List Price: ");
		double listPrice = Driver.input.nextDouble();
		
		
		
		
		
		Driver.cfm.CreateNewCar(new Car(make, model, year, color, listPrice));
		
		
		
	}
	
	
	private void RemoveCar() {
		listCars();
		System.out.println("Select a Car by Number");
		int i = Driver.input.nextInt();
		
		Driver.cfm.removeCar(i);
	
		
	}
	
	
	private void listCars() {
		Driver.cfm.sysoutCarList();
	}
	
	
	private void listOffers() {
		Driver.cfm.sysoutOfferList();
	}
	

	
	
	
}