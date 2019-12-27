package basePackage;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


import com.live.util.WebdriverUtils;

public class BaseClass extends WebdriverUtils{
	
	public static Properties appData = null;	
	public static Properties appElements = null;	
	public WebDriver driver =null;	
	public static WebDriverWait wait	 =null;
    public static FileInputStream fip = null;
    
   @BeforeClass
	public void initalize() throws IOException{
		
		fip = new FileInputStream(System.getProperty("user.dir")+ "//src//test//resources//appData.properties");
		appData = new Properties();
		appData.load(fip);
		
		fip = new FileInputStream(System.getProperty("user.dir")+ "//src//test//resources//appElements.properties");
		appElements = new Properties();
		appElements.load(fip);
		
		} 
	
   	
	public void setBrowser(){
		if (appData.getProperty("browser").equalsIgnoreCase("Chrome")) {
			//System.setProperty("webdriver.chrome.driver", "F://Artificats//LatestDrivers//chromedriver.exe");
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "//drivers//chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		} else if (appData.getProperty("browser").equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "F://Artificats//LatestDrivers//IEDriver.exe");
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "//drivers//IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
	}
	
	  
	   public Pagefactory pageBase()
	   {
		   return new Pagefactory(driver);
	   }
	   
	  
	   
}
