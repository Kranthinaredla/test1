package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import Extent_Reports.ExtentReport;

public class Homepage1 {
	
	WebDriver driver;
	
	ExtentTest logger;
	ExtentReporter extent;
	String screenShotPath;
	String TestScriptName;

	
	public void Homepage1(WebDriver driver,String TestScriptName,ExtentTest logger,ExtentReporter extent2)
	{
		this.driver=driver;
		this.logger=logger;
		this.extent=extent2;
		this.TestScriptName=TestScriptName;
	}
	
	
	public void logout() throws Exception
	{
		
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	    findElement(By.id("welcome")).click();
		
	    screenShotPath=ExtentReport.capture(driver, TestScriptName);
	    logger.pass("Homepage-Logout",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
	    
		findElement(By.linkText("Logout")).click();
		
	}
	
	
	public   WebElement findElement(By by) throws Exception 
	{

		WebElement elem = driver.findElement(by);  
		
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		return elem;
}
}
