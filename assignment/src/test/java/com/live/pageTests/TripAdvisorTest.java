package com.live.pageTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.live.util.WebdriverUtils;

import basePackage.BaseClass;
import basePackage.Pagefactory;

public class TripAdvisorTest extends BaseClass {
	
	public Pagefactory page;
	
	@BeforeMethod
	public void init() {
		setBrowser();
		driver.get(appData.getProperty("tripAdvisorUrl"));
	}

	@Test
	public void reviewWritingTripAdvisor() throws Exception{
		try {
		page =pageBase();
		page.tripAdvisorHomePage(driver).clickHomeSearch();
		page.tripAdvisorHomePage(driver).performSearch("Club Mahindra");
		page.tripAdvisorHomePage(driver).clickSearch();
		page.tripAdvisorHomePage(driver).selectHotelIndexWise(0);
		WebdriverUtils.windowHandle(driver);
		page.tripAdvisorHomePage(driver).clickWriteReview();
		WebdriverUtils.windowHandle(driver);
		page.tripAdvisorHomePage(driver).selectFiveStarOverAllRating();
		page.tripAdvisorHomePage(driver).enterReviewTitle("Very nice place to stay");
		page.tripAdvisorHomePage(driver).enterReviewText("sdfsfsfsdfsfsfsfsfsfsfsfsjljljlksjlfjlsjflsjfklsjflksjflkjsklfjsfjlskjflksjflsjflksjflksjflksjflksjflksjflksjfsjflksjflksjflsjlksjflksjflksjljjsajajijslkjslkfjlksjflsfjlksjlksjflksjflksdjflksjflksjflksjflskjflksj");
		page.tripAdvisorHomePage(driver).selectSortOfTripBusiness();
		page.tripAdvisorHomePage(driver).travelSelect("12,2019");
		page.tripAdvisorHomePage(driver).giveFiveStarForHotelRatings();
		page.tripAdvisorHomePage(driver).clickCheckbox();
		page.tripAdvisorHomePage(driver).clickSubmit();
		WebdriverUtils.windowHandle(driver);
		System.out.println("Successfully Submitted the Review");
		}catch (Exception e) {
			e.printStackTrace();
			WebdriverUtils.captureScreenshot(driver);
			Assert.fail();
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
