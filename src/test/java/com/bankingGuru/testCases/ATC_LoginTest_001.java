package com.bankingGuru.testCases;
import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.bankingGuru.pageObjects.LoginPage;



public class ATC_LoginTest_001 extends BaseClass{
	
	@Test
	public void logintest() throws IOException{
		
		//driver.get(baseURL);
		logger.info("Ingreso a la URL");
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("Ingresa el Usuario");
		
		lp.setPassword(password);
		logger.info("Ingresa la Contraseña");
		
		lp.clickSummit();
		logger.info("presiona botón");
		
		if(driver.getTitle().equals("GTPL Bank Manager HomePage111")){
			Assert.assertTrue(true);
			logger.info("Login test Pass");
		}else{
			captureScreen(driver, "logintest");
			Assert.assertTrue(false);
			logger.info("Login test Failed");
		}
		
		
	}


}
