package SeleniumFinal;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.RobotPractice;
import resources.base;

public class RobotTest extends base {
	
public WebDriver driver;
	
	@BeforeTest
	
	public void initialize() throws IOException
	{
		driver = initializeBrowser();
		
	}
	
	@Test
	public void testRobot() throws AWTException
	{
		driver.get("http://demo.automationtesting.in/Register.html");
		RobotPractice rp = new RobotPractice(driver);
		rp.uploadFile();
	}
	
	

}
