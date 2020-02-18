package com.revature.dealership.test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.dealership.Car;
import com.revature.dealership.Customer;
import com.revature.dealership.Driver;
import com.revature.dealership.User;
import com.revature.dealership.carMod.CarFileManager;
import com.revature.dealership.carMod.Employee;
import com.revature.dealership.listmod.Admin;
import com.revature.dealership.listmod.UserFileManager;

public class DealerTest {
	static User AdminUser;
	static User EmployeeUser;
	static User CustomerUser;
	static Car TestCar;
	public static UserFileManager ufm = null;
	public static CarFileManager cfm = null;
	//User CustomerUser;
	

	
	@BeforeClass // runs once before each test
	public static void setUp() throws Exception {
		
		InputStream sysInBackup = System.in;

		
		 // backup System.in to restore it later
		
		String simulatedUserInput = "adminPass" + System.getProperty("line.separator") + "admin" + System.getProperty("line.separator") + "adminPass" + System.getProperty("line.separator") + "Johny" + System.getProperty("line.separator")
	    + "y" + System.getProperty("line.separator") + "jpass" + System.getProperty("line.separator") + "exit" + System.getProperty("line.separator");
		
		System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
		
        Path temp = Files.move 
        (Paths.get("./users.dat"),  
        Paths.get("./datBackup/users.dat.backup")); 
  

        
        Path carTemp = Files.move 
        (Paths.get("./cars.dat"),  
        Paths.get("./datBackup/cars.dat.backup")); 

		
		////////////////////////////////////////////////////////////backup previos dat file
		

		
		

		

		
		Driver.main(null);
		
		ufm = new UserFileManager();
		cfm = new CarFileManager();
		
		
		TestCar = cfm.CreateNewCar(new Car("Toyota", "Prius", 2008, "Green", 7000.00));
		CustomerUser = ufm.CreateNewCustomerAccount("Jordan Customer", "jpass");
		
		AdminUser = ufm.checkUser("admin", "adminPass");
		EmployeeUser = ufm.checkUser("Johny", "jpass");
		//EmployeeUser = ufm.checkUser("admin", "adminPass");
		
		//AdminUser.PromptUser();
		

		
		System.setIn(sysInBackup);
		

		
		
	}
	
	
	@Test
	public void testCustomerLogin() {
		assertEquals(new Customer("Jordan Customer", "jpass") , ufm.checkUser("Jordan Customer", "jpass"));
		//assertEquals(true, true);
	}
	

	@Test
	public void testEmployeeLogin() {
		assertEquals(new Employee("Johny", "jpass") , ufm.checkUser("Johny", "jpass"));
		//assertEquals(true, true);
	}

	
	
	
	@Test
	public void testEmployeeAddCar() {
		
		Car carToAdd = new Car("Toyota", "Camry", 2018, "Silver", 17000.00);

		((Employee) EmployeeUser).AddCarToLot(carToAdd);
		
		assertEquals(carToAdd , cfm.getCarList().getLast());
		//assertEquals(true, true);
	}
	
	
	
	
	
	@After // runs once after each test
	public void tearDown() throws Exception {
	}
	
	
	

	
	
	@AfterClass// runs once after all tests finish
	public static void tearDownAfterClass() throws Exception {
		
		
		
		
	  
	        File file = new File("./users.dat"); 
	          
	        if(file.delete()) 
	        { 
	            System.out.println("New User Test File deleted successfully"); 
	        } 
	        else
	        { 
	            System.out.println("Failed to delete the file"); 
	        } 
	    
	        File fileCar = new File("./cars.dat"); 
	          
	        if(fileCar.delete()) 
	        { 
	            System.out.println("New Car test File deleted successfully"); 
	        } 
	        else
	        { 
	            System.out.println("Failed to delete the file"); 
	        } 
		
		
		
		
		
		
		
        Path tempBack = Files.move 
        (Paths.get("./datBackup/users.dat.backup"),  
        Paths.get("./users.dat")); 
  
        if(tempBack != null) 
        { 
            System.out.println("File renamed and moved successfully"); 
        } 
        else
        { 
            System.out.println("Failed to move the file"); 
        } 
        
        
        Path carTempBack = Files.move 
        (Paths.get("./datBackup/cars.dat.backup"),  
        Paths.get("./cars.dat")); 
  
        if(carTempBack != null) 
        { 
            System.out.println("File renamed and moved successfully"); 
        } 
        else
        { 
            System.out.println("Failed to move the file"); 
        } 
	
        
	}
	

}
