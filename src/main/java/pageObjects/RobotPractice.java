package pageObjects;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RobotPractice {
	public WebDriver driver;

	
	
	public void uploadFile() throws AWTException
	{

		 WebElement img=driver.findElement(By.id("imagesrc"));
			img.click();
		Robot r = new Robot();
		
	}
	public RobotPractice(WebDriver driver)
	{
		this.driver=driver;
	}
}
