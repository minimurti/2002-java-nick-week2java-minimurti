package com.revature.dealership;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.dealership.carMod.CarFileManager;
import com.revature.dealership.listmod.*;
//package com.revature.driver;

import jdk.internal.org.jline.utils.Log;

import org.apache.log4j.Logger;

public class Driver {
	
	private static Logger log = Logger.getRootLogger();
	
	public static Scanner input = new Scanner(System.in);
	public static UserFileManager ufm = new UserFileManager();
	public static CarFileManager cfm = new CarFileManager();
	
	

	public static void main(String[] args) {
		

		
		
		
		
		System.out.println("Enter Username: ");
		String username = input.next();
		
		
		
		
		
		System.out.println("Enter Password: ");
		String password = input.next();

		
		
		User CurrentUser = ufm.checkUser(username, password);
		
		if(CurrentUser == null) {
			
			System.out.println("Username and Password Combination not Found.");
			System.out.println("Creat New Customer Account? (Y/n)");
			String answer = input.next();
			String newUsername = null;
			while(CurrentUser == null)
			if(answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("yes")) {
				
				boolean UniqueName = false;
				
				while(!UniqueName) {
					System.out.println("Enter a Unique Username: ");
					newUsername = input.next();
					if(ufm.CheckNameAvailibility(newUsername)) {
						UniqueName = true;
					}
					else {
						System.out.println("That Username is taken.");
					}
				}
				
				
				System.out.println("Enter Password: ");
				String newPassword = input.next();
				
				CurrentUser = ufm.CreateNewCustomerAccount(newUsername, newPassword);
			}else {
				System.out.println("Enter Username: ");
				
				username = input.next();

				System.out.println("Enter Password: ");
				password = input.next();

				
				
				CurrentUser = ufm.checkUser(username, password);
			}
				
			
			

		}
		
		boolean continueLoop = true;
		
		while(continueLoop) {
		try {
			continueLoop = CurrentUser.PromptUser();
		}catch(InputMismatchException e) {
			Driver.input.next();
			Log.warn("Please Enter Valid Input");
		}catch(IndexOutOfBoundsException e) {
			Log.warn("Please Enter Valid Range");
		}
		
		
		
		}
		
		
		input.close();
		
		
		return; 
	}
	
	
	public static boolean test() {
		return true;
	}
	
	







	
		
	
	
	
	
	
	

}
