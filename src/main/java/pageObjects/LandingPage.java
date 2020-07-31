package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	private By loginBtn=By.cssSelector("a[href*='sign_in']");
	private By featuredCrs = By.xpath("//h2[text()='Featured Courses']");
	private By header =By.cssSelector("ul[class='nav navbar-nav navbar-right']");
	
	
	
	public LandingPage(WebDriver driver) {
	
		this.driver=driver;   //driver in this.driver refers to the driver declared inside the class
	}



	public LoginPage getLogin()
	{
		driver.findElement(loginBtn).click();
		LoginPage lop = new LoginPage(driver);
		return lop;
		
	}

	public WebElement getTitle()
	{
		return driver.findElement(featuredCrs);
	}

	public WebElement getNavBar()
	{
		return driver.findElement(header);
	}
	
}
