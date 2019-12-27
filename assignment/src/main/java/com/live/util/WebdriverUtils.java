package com.live.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;


public class WebdriverUtils {

	
	public static WebElement waitForElementPresenet(WebDriver driver,WebElement locater)
	{
		WebElement element= (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(locater));
		return element;
	}
	
	
	
	public static WebElement scrollToElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		return element;
	}
	
	public static void javaScriptClick(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	public static String captureScreenshot(WebDriver driver) throws IOException
	{
		File screenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"\\screenShots\\"+driver.getTitle().replaceAll(" ", "")+".png";
		FileUtils.copyFile(screenshot, new File(path));
		return path;
	}
	

	public void navigateToPage(WebDriver driver,String url){
				driver.navigate().to(url);		
			}
	
	public static void selectRating(WebDriver driver, WebElement element)
	{
		Actions a = new Actions(driver);
		int srX= element.getLocation().getX();
		int srY = element.getLocation().getY();
		int srWidth = element.getSize().width;
		a.moveToElement(element).moveByOffset((srWidth/2)-2, 0).click().build().perform();
		
	}
	
	public static void selectDropdown(WebDriver driver, WebElement element, String dropdownValue)
	{
		Select s =new Select((element));	
		s.selectByValue(dropdownValue);
	}
	
	public static Set<String> windowHandle(WebDriver driver)
	{
		Set<String> window = driver.getWindowHandles();
		for(String s:window)
		{
			driver.switchTo().window(s);
		}
		return window;
	}
}
