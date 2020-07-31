package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {
	
	public WebDriver driver;
	
	private By emailAddress = By.id("user_email");
	private By sendMeInstructions = By.xpath("//input[@type='submit']");
	
	
	
	public  ForgotPassword(WebDriver driver)
	{
	    this.driver= driver;
	}

	public WebElement getEmail()
	{
		return  driver.findElement(emailAddress);
	}
	
	public WebElement sendMeInstructions()
	{
		return  driver.findElement(sendMeInstructions);
	}
}
