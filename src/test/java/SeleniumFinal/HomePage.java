package SeleniumFinal;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base{
	
	public WebDriver driver;
	
	@BeforeTest
	
	public void initialize() throws IOException
	{
		driver = initializeBrowser();
		
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String UserName , String password) throws IOException
	{	
		driver.get(prop.getProperty("url"));
		LandingPage lp = new LandingPage(driver);
		LoginPage lop=lp.getLogin();
		
	
		lop.getEmail().sendKeys(UserName);
		lop.getPassword().sendKeys(password);
		lop.getLoginBtn().click();
		ForgotPassword fp = lop.forgotPwd();
		fp.getEmail().sendKeys("abc@123.com");
		fp.sendMeInstructions().click();
		
		
	}
	
	
	@DataProvider()
	public  Object[][] getData()
	{
		
		//Row stands for how many different data types test should run(enter username pwd twice)
		
		//Column stands for how many values per each test(username,pwd etc)
		
		
		Object[][] data = new Object[2][2];
		data[0][0] = "abc@xyz.com";
		data[0][1]="abc@1234";
		data[1][0]="xyz@abc.com";
		data[1][1]="xyz@1234";
		
		return data;
	}
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}


