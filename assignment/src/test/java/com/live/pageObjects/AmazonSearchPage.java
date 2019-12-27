package com.live.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.live.util.WebdriverUtils;

public class AmazonSearchPage {
	
	public WebDriver driver;
	public AmazonSearchPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Apple iPhone XR (64GB) - Yellow']/../../../../../../../div[2]/div/div/div/div/div/a/span/span/span[2]") private WebElement mobilePrice;
	
	public String getMobilePrice()
	{
		WebdriverUtils.waitForElementPresenet(driver, mobilePrice);
		WebdriverUtils.scrollToElement(driver, mobilePrice);
		return mobilePrice.getText();
	}
	
}
