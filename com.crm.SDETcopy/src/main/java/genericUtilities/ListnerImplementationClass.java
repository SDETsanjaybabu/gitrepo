package genericUtilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerImplementationClass implements ITestListener
{
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
	   String testName = result.getMethod().getMethodName();
	   System.out.println(testName + "===execute===");
	   
	  EventFiringWebDriver eDriver = new EventFiringWebDriver(BaseClass.sdriver);
	  File srcFile = eDriver.getScreenshotAs(OutputType.FILE);
	  try {
		FileUtils.copyFile(srcFile, new File("./screenShot/"+testName+".PNG"));
	} catch (IOException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}	
}