package com.cts.EBanking;

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SmartBankAccountTest {

	BankAccount bankAccount;
	
	@Before()
	public void setUp() {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
        bankAccount=(BankAccount) ctx.getBean("smartBankAccount");
	}
	
	/**
	 * Test method for doDeposit
	 * 
	 */
	
	@Test
	public void testDoDeposit(){
		
		if(bankAccount.doDeposit(10000)==20000){
			assertTrue(true);
		}else{
			fail("Please check your logic in doDeposit method");
		}
	}
	
	/**
	 * Test method for doWithdraw
	 * 
	 */
		
	@Test
	public void testDoWithdraw(){
		
		if(bankAccount.doWithdraw(5000)==5000){
			assertTrue(true);
		}else{
			fail("Please check your logic in doWithdraw method");
		}
	}
	/**
	 * Test method for doWithdraw if withdraw amount is greater 
	 * than balance
	 * 
	 */
	@Test
	public void testDoWithdrawNegative(){
		
		if(bankAccount.doWithdraw(15000)==-1){
			assertTrue(true);
		}else{
			fail("Please check your logic in doWithdraw method");

		}
	}

	/**
	 * Test method for calculate fixed deposit amount
	 * 
	 */
	@Test
	public void testCalculateFixedAccount() {
		
		if(bankAccount.calculateFixedAccount(25000, 24)==30509.77){
			assertTrue(true);
		}else{
			fail("Please check your logic to calculate fixed deposit");
		}
	}
	
	/**
	 * Test method for calculate recurring deposit
	 * 
	 */
	@Test
	public void testCalculateRecurringAccount() {
		

		if(bankAccount.calculateRecurringAccount(15000, 9)==138937.5){
			assertTrue(true);
		}else{
			fail("Please check your logic to calculate recurring deposit");

		}
	}
	
	/**
	 * Test method for recurring deposit less
	 * than 1000
	 * 
	 */
	@Test
	public void testRecurringLessK(){
		
		if(bankAccount.calculateRecurringAccount(999, 60)==-1){
			assertTrue(true);
		}else{
			fail("Please check your logic to calculate recurring deposit");

		}
		
	}
	
	/**
	 * Test method for recurrring deposit greater 
	 * than 50000
	 * 
	 */
	@Test
	public void testRecurringGreaterThan50k(){
		
		if(bankAccount.calculateRecurringAccount(50001, 60)==-1){
			assertTrue(true);
		}else{
			fail("Please check your logic to calculate recurring deposit");

		}
		
	}
	
	/**
	 * Test method for recurring deposit
	 * where tenure greater than 60 months
	 * 
	 */
	@Test
	public void testRecurringGreaterThan60(){
		
		if(bankAccount.calculateRecurringAccount(5000, 61)==-1){
			assertTrue(true);
		}else{
			fail("Please check your logic to calculate recurring deposit");

		}
		
	}
	
	/**
	 * Test method for calculating 
	 * fixed deposit less than 10000
	 * 
	 */
	@Test
	public void testFixedLess10K(){
		
		if(bankAccount.calculateFixedAccount(9000, 60)==-1){
			assertTrue(true);
		}else{
			fail("Please check your logic to calculate fixed deposit");
		}
	}

	/**
	 * Test method calculating fixed
	 * deposit greater than 1000000
	 * 
	 */
	@Test
	public void testFixedGreaterThan10lac(){
		
		if(bankAccount.calculateFixedAccount(1000001, 60)==-1){
			assertTrue(true);
		}else{
			fail("Please check your logic to calculate fixed deposit");
		}
	}
	
	/**
	 * Test method for calculating fixed deposit
	 * when tenure greater than  120
	 */
	@Test
	public void testFixedgreaterThan120(){
		
		if(bankAccount.calculateFixedAccount(100000, 121)==-1){
			assertTrue(true);
		}else{
			fail("Please check your logic to calculate fixed deposit");
		}
	}
	
	/**
	 * Test method for checking 
	 * customer id injected in constructor 	 * 
	 * 
	 */
	
	@Test
	public void testCustomerId(){
		
		if(bankAccount.getCustomerId()==100){
			assertTrue(true);
		}else{
			fail("Customer id not assigned");
		}
		
	}
	
	/**
	 * Test method for checking 
	 * customer id injected in constructor 	 * 
	 * 
	 */
	
	@Test
	public void testCustomerName(){
		
		if(bankAccount.getName().equals("Joe")){
			assertTrue(true);
		}else{
			fail("Customer name not assigned");
		}
		
	}
	
		
	/**
	 * Test method for checking 
	 * parameterized constructor 
	 * available or not  
	 * 
	 */
	@Test
	public void testParameterizedConstructorPresent() {

		Class[] paramTypes = { int.class, String.class, double.class, List.class };
		try {
			Class classUnderTest = Class.forName("com.cts.EBanking.SmartBankAccount");

			Constructor<?> constructor = classUnderTest.getConstructor(paramTypes);

			if (constructor != null) {

				assertTrue(true);
			}
		} catch (NoSuchMethodException e) {

			fail("Please check if parameterized constructor is present, with parameters of same type as given in design spec. ");

		} catch (SecurityException e) {

			fail("Please check if parameterized constructor is present, with parameters of same type as given in design spec. ");

		} catch (ClassNotFoundException e) {

			fail("Please check if parameterized constructor is present, with parameters of same type as given in design spec. ");

		}

	}

	@After
	public void tearDown(){
		bankAccount=null;
	}
}
