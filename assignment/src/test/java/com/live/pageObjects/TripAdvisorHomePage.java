package com.live.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.live.util.WebdriverUtils;

public class TripAdvisorHomePage {

	public WebDriver driver;
	public TripAdvisorHomePage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@title='Search']") private WebElement homesearchBox;
	@FindBy(xpath="//input[@type='search']") private WebElement searchBox;
	@FindBy(xpath="//button[@type='submit']") private WebElement searchButton;
	@FindBy(xpath ="/span[contains(text(),'More results matching')]/../../../../../div/../div[2]/div/div/div") private WebElement firstItem;
	@FindBy(linkText = "Write a review") private WebElement writeReviewButton;
	@FindBy(xpath = "//div/span[@id='bubble_rating']") private WebElement bubbleRating;
	@FindBy(id = "ReviewTitle") private WebElement reviewtitle;
	@FindBy(id = "ReviewText") private WebElement reviewtext;
	@FindBy(xpath = "//div[contains(@class,'Business')]") private WebElement sortOfTripBusiness;
	@FindBy(id = "trip_date_month_year") private WebElement travelSelect;
	@FindBy(xpath = "//span[@id='qid12_bubbles']") private WebElement serviceStar;
	@FindBy(xpath = "//span[@id='qid13_bubbles']") private WebElement sleepQualityStar;
	@FindBy(xpath = "//span[@id='qid14_bubbles']") private WebElement valueStar;
	@FindBy(id = "noFraud")private WebElement checkBox;
	@FindBy(id = "SUBMIT")private WebElement submitButton;
	@FindBy(xpath ="//div[text()='View Hotel']") private WebElement viewHotelText;
	@FindBy(xpath = "//div[contains(text(),'Hotel Style & Amenities ')]") private WebElement hotelStyleText;
	

	public void clickHomeSearch()
	{
		WebdriverUtils.waitForElementPresenet(driver, homesearchBox);
		homesearchBox.click();
	}
	
	public void performSearch(String searchText)
	{
		searchBox.click();
		searchBox.sendKeys(searchText);
	}
	
	public void clickSearch()
	{
		searchButton.click();
	}
	
	public void selectFirstItem()
	{
		WebdriverUtils.waitForElementPresenet(driver, firstItem);
		firstItem.click();
	}
	
	public void selectHotelIndexWise(int index)
	{
		List<WebElement> li = driver.findElements(By.xpath("//span[contains(text(),'More results matching')]/../../../../../div[2]/div/div/div"));
			if(li.size()>0)
			{
				li.get(index).click();
			}
	}
	
	public void clickSubmit()
	{
		submitButton.click();
	}
	
	public void clickCheckbox()
	{
		checkBox.click();
	}
	
	public void enterReviewTitle(String reviewTitleText ) {
		reviewtitle.sendKeys(reviewTitleText);
	}
	
	public void enterReviewText(String reviewText)
	{
		reviewtext.sendKeys(reviewText);
	}
	
	public void clickWriteReview()
	{
		WebdriverUtils.scrollToElement(driver, viewHotelText);
		writeReviewButton.click();
	}
	
	public void selectFiveStarOverAllRating()
	{
		//WebdriverUtils.selectRating(driver, bubbleRating, 1);
		/*
		 * Actions a = new Actions(driver); int bubbleRatingX=
		 * bubbleRating.getLocation().getX(); int bubbleRatingY=
		 * bubbleRating.getLocation().getY(); int bubbleWidth =
		 * bubbleRating.getSize().getWidth(); a.moveByOffset(258,
		 * bubbleRatingY).click().build().perform();
		 */
		WebdriverUtils.selectRating(driver, bubbleRating);
	}
	
	public void selectFiveStarServiceRating()
	{
		WebdriverUtils.scrollToElement(driver, hotelStyleText);
		WebdriverUtils.selectRating(driver, serviceStar);
	}
	
	public void selectFiveStarSleepRating()
	{
		WebdriverUtils.scrollToElement(driver, hotelStyleText);
		WebdriverUtils.selectRating(driver, sleepQualityStar);
	}
	
	public void selectFiveStarValueRating()
	{
		WebdriverUtils.scrollToElement(driver, hotelStyleText);
		WebdriverUtils.selectRating(driver, valueStar);
	}
	
	public void giveFiveStarForHotelRatings()
	{
		List<WebElement> ls = driver.findElements(By.xpath("//div[@class='ratingBubbleTable']/div/div[2]/div/span[contains(@id,'bubbles') and contains(@class,'answers')]"));
		for(int i=0;i<3;i++)
		{
			WebdriverUtils.scrollToElement(driver, hotelStyleText);
			WebdriverUtils.selectRating(driver, ls.get(i));
		}
	}
	
	public void  selectSortOfTripBusiness()
	{
		sortOfTripBusiness.click();
	}
	
	public void travelSelect(String dropdownValue)
	{
		WebdriverUtils.selectDropdown(driver, travelSelect, dropdownValue);
	}
	
}
