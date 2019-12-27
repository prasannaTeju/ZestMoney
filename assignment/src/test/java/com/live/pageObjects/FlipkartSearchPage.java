package com.live.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.live.util.WebdriverUtils;

public class FlipkartSearchPage {

	public WebDriver driver;
	public FlipkartSearchPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[text()='Apple iPhone XR (Yellow, 64 GB)']/../../div[2]/div/div/div") private WebElement mobilePrice;
	
	public String getMobilePrice()
	{
		WebdriverUtils.waitForElementPresenet(driver, mobilePrice);
		WebdriverUtils.scrollToElement(driver, mobilePrice);
		return mobilePrice.getText();
	}
}
