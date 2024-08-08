package com.engqa.TDF.readproperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;

public class ReadProperties {

	public static void main(String[] args) throws IOException {
		WebDriver driver = null;
		// TODO Auto-generated method stub
		Properties prop = new Properties();
		Logger log=Logger.getLogger(ReadProperties.class);
		//making conncetion between jawa and popertu files
		FileInputStream file = new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\TDF\\src\\main\\java\\com\\engqa\\TDF\\config\\config.properties");
		// load all values in properties file
		prop.load(file);
		System.out.println(prop.getProperty("browser"));
         String BrowserNAme = prop.getProperty("browser");
		
		if(BrowserNAme.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver","D:\\Automation\\chrome-win64\\chromedriver.exe");
			ChromeOptions capability = new ChromeOptions();
//			capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
			driver=new ChromeDriver(capability);
		     driver.manage().window().maximize();
			 driver.manage().deleteAllCookies();
		    
		}
		 else if(BrowserNAme.equals("FF")) {
			 System.setProperty("webdriver.gecko.driver","D:\\Automation\\chrome-win64\\geckodriver.exe");
			 driver = new FirefoxDriver();
	    	 
	     }
		
		 else if(BrowserNAme.equals("IE")) { 
			 driver = new InternetExplorerDriver();
	    	 
	     }
		 else {
			 System.out.println("Specify the Browser name");
		 }
		
		driver.get(prop.getProperty("TDF_Page1"));
		log.info("Lauching Browser");
		log.info(BrowserNAme);
	}

}
