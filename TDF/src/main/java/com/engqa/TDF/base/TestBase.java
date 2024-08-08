package com.engqa.TDF.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;

//import com.engqa.TDF.util.TestUtil;
public class TestBase {
		
		public static Properties prop;
		public static WebDriver driver;
//		public static EventFiringWebDriver e_drive;
//		//public static WebDriverEventListener event;
//		public static WebEventListener event;
		
	public TestBase() {
		
			
			try {
			 prop = new Properties();
			FileInputStream file = new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\TDF\\src\\main\\java\\com\\engqa\\TDF\\config\\config.properties");
			prop.load(file);
			}catch(FileNotFoundException e) {
				e.printStackTrace();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
		public static void initialization() {
		//	Logger log2=Logger.getLogger(TestBase.class);
			String Browsername=prop.getProperty("browser");
			System.out.println(Browsername);
			if(Browsername.equals("Chrome")) {
				 System.setProperty("webdriver.chrome.driver","D:\\Automation\\chrome-win64\\chromedriver.exe");
				 
				     ChromeOptions capability = new ChromeOptions();
				      capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
				     driver=new ChromeDriver(capability);
				     driver.manage().window().fullscreen();
			    
			}
			 else if(Browsername.equals("FF")) {
				 System.setProperty("webdriver.gecko.driver","D:\\Automation\\chrome-win64\\geckodriver.exe");
				 driver = new FirefoxDriver();
		    	 
		     }
			
			 else if(Browsername.equals("IE")) { 
				 driver = new InternetExplorerDriver();
		    	 
		     }

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
//			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
//			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			driver.get(prop.getProperty("TDF_Page1"));
			
		}


}
