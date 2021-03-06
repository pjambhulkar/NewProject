package SeleniumFinal;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentResports;
import resources.base;

public class Listeners extends base implements ITestListener{
	
	ExtentTest test ;
	ExtentReports extent =ExtentResports.getReportObject(); 
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public void onFinish(ITestContext arg0) {
		
		extent.flush();
	}

	

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		
		extentTest.get().fail(result.getThrowable());
		WebDriver driver=null;
		String failedMethodName = result.getMethod().getMethodName();
		try {
			driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch(Exception e)
		{
			
		}
		
			
		
		
		try {
			extentTest.get().addScreenCaptureFromPath(getScreenShot(failedMethodName,driver),result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}


	public void onTestSuccess(ITestResult result) {
		
		extentTest.get().log(Status.PASS, "Test Passed");
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult result) {
	
		 test = extent.createTest(result.getMethod().getMethodName());
		 extentTest.set(test);
		
	}

}
