package com.live.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.live.util.WebdriverUtils;

public class AmazonHomePage {

	
	public WebDriver driver;
	public AmazonHomePage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@id='twotabsearchtextbox']") private WebElement searchBox;
	@FindBy(xpath="//div[@class='nav-search-submit nav-sprite']") private WebElement searchButton;
	
	public void performSearch(String searchText)
	{
		searchBox.sendKeys(searchText);
	}
	
	public void clickSearch()
	{
		searchButton.click();
	}

	
}
