package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	
	private By emailAddress = By.id("user_email");
	private By password = By.id("user_password");
	private By loginBtn = By.cssSelector("input[value='Log In']");
	private By forgotPwd = By.partialLinkText("Forgot Password?");
	
	
	
	public ForgotPassword forgotPwd()
	{
		driver.findElement(forgotPwd).click();
		return new ForgotPassword(driver);
	
	}
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getEmail()
	{
		return  driver.findElement(emailAddress);
	}
	
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	
	}

	
	public WebElement getLoginBtn()
	{
		return driver.findElement(loginBtn);
	}
}
