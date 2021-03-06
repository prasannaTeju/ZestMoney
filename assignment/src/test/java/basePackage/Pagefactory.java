package basePackage;

import org.openqa.selenium.WebDriver;

import com.live.pageObjects.AmazonHomePage;
import com.live.pageObjects.AmazonSearchPage;
import com.live.pageObjects.FlipkartHomePage;
import com.live.pageObjects.FlipkartSearchPage;
import com.live.pageObjects.TripAdvisorHomePage;

public class Pagefactory {

	public WebDriver driver;
	public Pagefactory(WebDriver driver) {
		this.driver=driver;
	}

	
	
	public AmazonHomePage amazonHomePage(WebDriver driver)
	{
		return new AmazonHomePage(driver);
	} 	
	
	public AmazonSearchPage amazonSearchPage(WebDriver driver)
	{
		return new AmazonSearchPage(driver);
	} 	
	
	public FlipkartHomePage flipkartHomePage(WebDriver driver)
	{
		return new FlipkartHomePage(driver);
	} 	
	public FlipkartSearchPage flipkartSearchPage(WebDriver driver)
	{
		return new FlipkartSearchPage(driver);
	} 	
	public TripAdvisorHomePage tripAdvisorHomePage(WebDriver driver)
	{
		return new TripAdvisorHomePage(driver);
	} 	
	
}
