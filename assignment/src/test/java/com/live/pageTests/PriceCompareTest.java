package com.live.pageTests;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.live.util.WebdriverUtils;

import basePackage.BaseClass;
import basePackage.Pagefactory;


public class PriceCompareTest extends BaseClass {

	
	public Pagefactory page;
	@BeforeMethod
	public void init() {
		setBrowser();
		driver.get(appData.getProperty("amazonUrl"));
	}

	@Test
	public void comparePrice() throws Exception{
		try {
		page =pageBase();
		page.amazonHomePage(driver).performSearch("iPhone XR (64GB)");
		page.amazonHomePage(driver).clickSearch();
		String amazonPrice=page.amazonSearchPage(driver).getMobilePrice().replaceAll(",", "");
		System.out.println(amazonPrice);
		driver.navigate().to(appData.getProperty("flikartUrl"));
		page.flipkartHomePage(driver).closeLogin();
		page.flipkartHomePage(driver).performSearch("iPhone XR (64GB)");
		page.flipkartHomePage(driver).clickSearch();
		String flipkartPrice = page.flipkartSearchPage(driver).getMobilePrice().replaceAll(",", "").replaceAll("₹", "");
		System.out.println(flipkartPrice);
			if(Integer.valueOf(amazonPrice)>Integer.valueOf(flipkartPrice))
			{
				System.out.println("Lowest Price in flipkart is : " +flipkartPrice );
			}else
			{
				System.out.println("Lowest Price in amazon is: " +amazonPrice );
			
			}
		
		}catch (Exception e) {
			System.out.println("Caught Exception");
			WebdriverUtils.captureScreenshot(driver);
			Assert.fail();
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
