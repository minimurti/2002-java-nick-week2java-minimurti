package com.revature.dealership.test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
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
	User AdminUser;
	Car TestCar;
	//User CustomerUser;
	UserFileManager ufm = new UserFileManager();
	CarFileManager cfm = new CarFileManager();
	
	@Before // runs once before each test
	public void setUp() throws Exception {
		
		InputStream sysInBackup = System.in; // backup System.in to restore it later
		
		
		
		
		
		ufm.checkUserFile();
		cfm.checkCarFile();
		
		TestCar = cfm.CreateNewCar(new Car("Toyota", "Prius", 2008, "Green", 7000.00));
		ufm.CreateNewCustomerAccount("Jordan Customer", "jpass");
		
		User AdminUser = ufm.checkUser("admin", "admin");
		String simulatedUserInput = "Johny" + System.getProperty("line.separator")
	    + "y" + System.getProperty("line.separator") + "jpass" + System.getProperty("line.separator");
		
		System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
		AdminUser.PromptUser();
		System.setIn(sysInBackup);

		
		
		
		
		
	}
	
	
	@Test
	public void testCustomerLogin() {
		assertEquals(new Customer("Jordan Customer", "jpass") , ufm.checkUser("Jordan Customer", "jpass"));
	}
	

	@Test
	public void testEmployeeLogin() {
		assertEquals(new Employee("Johny", "jpass") , ufm.checkUser("Johny", "jpass"));
	}

	
	
	
	
	
	
	
	
	
	@After // runs once after each test
	public void tearDown() throws Exception {
	}
	
	
	

	
	
	@AfterClass// runs once after all tests finish
	public static void tearDownAfterClass() throws Exception {
		
		UserFileManager ufm = new UserFileManager();
		CarFileManager cfm = new CarFileManager();
		User AdminUser = ufm.checkUser("admin", "admin");
		((Admin) AdminUser).deleteLastUser();
		// optionally, reset System.in to its original
	
	}
	

}
