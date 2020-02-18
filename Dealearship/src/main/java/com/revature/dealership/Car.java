package com.revature.dealership;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

public class Car implements Serializable {
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8886423260978171832L;
	
	private String make;
	private String model;
	private int year;
	
	private String color;
	
	private boolean isAccepted = false;
	
	private double listPrice;
	private LinkedList<Offer> offers;
	

	public Car(String make, String model, int year, String color, double listPrice) {
		super();
		this.make = make;
		this.model = model;
		this.year = year;
		this.color = color;
		this.listPrice = listPrice;
		offers = new LinkedList<Offer>();
	}
	
	public void AcceptOffer(User user){
		this.isAccepted = true;
		Iterator<Offer> i = offers.iterator();
		Offer current = null;
		while(i.hasNext()) {
			   current = i.next();
			   
			   if(user == current.getOfferer()) {
				   current.setAccepted(true);
			   }
			   else {
				   i.remove();////removes (rejects the offer)
			   }
			   
			   
		}
		
	}
	
	public void RejectOffer(int i ) {
		
		offers.remove(i);
		
//		Iterator<Offer> i = offers.iterator();
//
//		while(i.hasNext()) {
//			   
//			   if(user == i.next().getOfferer()) {
//				   i.remove();////removes (rejects the offer)
//			   }
//			   
//		}
	}
	
	public Offer getOffer(int i) {
		return offers.get(i);
	}

	@Override
	public String toString() {
		return "Make=" + make + ", Model=" + model + ", Year=" + year + ", Color=" + color + ", List Price="
				+ listPrice + " Number of Offers= " + offers.size();
	}
	
	public void addOffer (Offer input) {
		offers.add(input);
	}
	
	
	
	public void PrintOffers() {
		Iterator<Offer> i = offers.iterator();
		int j = 0;
		while(i.hasNext()){
			j++;
			System.out.println(j + ". " + i.next().toString());

			
		}
		
		System.out.println("\n ");
	}
	
	
	public User getOfferUser(int i) {
		return offers.get(i).getOfferer();
	}

	public boolean isAccepted() {
		return isAccepted;
	}
	
}
