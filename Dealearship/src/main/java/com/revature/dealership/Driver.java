package com.revature.dealership;

import java.util.Scanner;

import com.revature.dealership.listmod.*;



public class Driver {
	
	public static Scanner input = new Scanner(System.in);
	public static UserFileManager ufm = new UserFileManager();
	
	

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
		
		
		while(CurrentUser.PromptUser());
		
		input.close();
		
		
		return; 
	}
	
	







	
		
	
	
	
	
	
	

}
