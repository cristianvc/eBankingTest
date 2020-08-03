package com.bankingGuru.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro = new Properties();;
	
	
	public ReadConfig(){
		
		File src = new File("./Configuración/config.propiedades");
		
		try{
			FileInputStream fis = new FileInputStream(src);
			pro.load(fis); 
			
		}catch(Exception e){
			System.out.println("Exception es " + e.getMessage());
		}
	}
	
	//Metodos GET 
	public String getURL(){
		String url = pro.getProperty("baseURL");
		return url;
	}
	
	public String getUsername(){
		String user = pro.getProperty("username");
		return user;
	}
	
	public String getPassword(){
		String pass = pro.getProperty("password");
		return pass;
	}
	
	public String getChromePath(){
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}
	
	public String getFirefoxPath(){
		String FirefoxPath = pro.getProperty("firefoxpath");
		return FirefoxPath;
	}
	

}
