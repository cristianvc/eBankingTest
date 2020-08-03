package com.bankingGuru.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bankingGuru.pageObjects.LoginPage;
import com.bankingGuru.utilities.XlsUtils;

public class ATC_LoginDDT_002 extends BaseClass{
	
	@Test(dataProvider="LoginData")
	
	public void loginDDT(String uname, String pwd) throws InterruptedException{
		LoginPage lp = new LoginPage(driver); 
		
		lp.setUserName(uname);
		logger.info("Ingreso Usuario");
		lp.setPassword(pwd);
		logger.info("Ingreso Contraseña");
		lp.clickSummit();
		logger.info("Ingreso click Ingresar");
		
		
		Thread.sleep(3000);
		
		if(isAlertPresent()){
			
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();			
			Assert.assertTrue(false);
			logger.warn("Login Fallo");
			
		}else{
			Assert.assertTrue(true);
			logger.info("Login Exito");
			Thread.sleep(5000);
			lp.clickLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}
	
	//Valida la presencia de una alerta
	public boolean isAlertPresent(){
		try{
		driver.switchTo().alert();
		return true;
		}catch(NoAlertPresentException e){
			return false;
		}
	}
	
	
	
	@DataProvider(name="LoginData")
	String [][]getData() throws IOException{
		 
		String path = System.getProperty("user.dir")+ "/src/test/java/com/bankingGuru/testData/LoginData.xlsx";
		int rownum = XlsUtils.getRowCount(path, "Sheet1");
		int colcount = XlsUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][] =new String[rownum][colcount];
		
		
		for(int i=1;i<=rownum;i++){
			for(int j=0;j<colcount;j++){
				
				logindata[i-1][j]= XlsUtils.getCellData(path, "Sheet1", i, j);  
			}
		}
		
	return logindata;
		
	}

}
