package com.bankingGuru.testCases;

import java.io.IOException;


import org.junit.Assert;
import org.testng.annotations.Test;

import com.bankingGuru.pageObjects.LoginPage;
import com.bankingGuru.pageObjects.NewCostumerPage;

public class ATC_newCostumerTest_003 extends BaseClass {
	
	@Test
	public void addNewCostumer() throws InterruptedException, IOException{
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSummit();
		
		Thread.sleep(3000);
		
		NewCostumerPage addcust = new NewCostumerPage(driver);
		
		addcust.clickAddNewCustomer();
		
		addcust.custName("Cristian");
		addcust.custgender("male");
		addcust.custdob("10","15","1985");
		Thread.sleep(5000);
		addcust.custaddress("Calle Viva");
		addcust.custcity("STGO");
		addcust.custstate("RM");
		addcust.custpinno("5000074");
		addcust.custtelephoneno("987890091");
		
		String email=randomestring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!"); 
		
		if(res){
			Assert.assertTrue(true);
		}else{
			
			captureScreen(driver,"addNewCostumer");
			Assert.assertTrue(false);
		}
		
	}
		

}
