package SeleniumFinal;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class ValidateTitleOnHomePage extends base {
	public WebDriver driver;
	LandingPage lp;

	@BeforeTest
	
	public void initialize() throws IOException
	{
		driver = initializeBrowser();
		driver.get(prop.getProperty("url")); 	 	
	}
	
	
	@Test
	
	public void validateTitle() throws IOException
	{
		
		 lp=new LandingPage(driver);

		Assert.assertEquals(lp.getTitle().getText(), "Featured Courses".toUpperCase());
		
	}
	/*@Test
	public void validateNavBar() throws IOException
	{
	
		Assert.assertTrue(lp.getNavBar().isDisplayed());
		
	}*/

	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}
