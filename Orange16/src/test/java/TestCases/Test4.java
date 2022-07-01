package TestCases;

import java.io.File;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import org.testng.annotations.Test;

import Reporter_Example_Word.ImageAttachmentInDocument1;
import Reporter_Example_Word.Reporter1;
import Reporter_Example_Word.WordConvertPDF;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Test4 {
	
	static WebDriver driver;


	
	
	@Test
	public void AddNationalitiess() throws Exception
	{
		
	System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	driver =new ChromeDriver();
	driver.manage().window().maximize() ;	
	// File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	// FileUtils.copyFile(scrFile, new File("C:\\ScreenShot1.jpg"));
	
	 driver.get("https://opensource-demo.orangehrmlive.com/");
	 
		ImageAttachmentInDocument1 IA = new ImageAttachmentInDocument1();
		IA.CreateHeader("Test Case : TC01 Add Nationality");
	
	 TakesScreenshot scrShot1 =((TakesScreenshot)driver);  //Object
	 File SrcFile1=scrShot1.getScreenshotAs(OutputType.FILE); // Converting this Obj into file
	 FileUtils.copyFile(SrcFile1, new File("C:\\TC04_Login\\TC1_ScreenShot1.jpg")); //File -->Name.extn

	 
	 
	 	findElement(By.id("txtUsername")).sendKeys("Admin");
	  TakesScreenshot scrShot2 =((TakesScreenshot)driver);
	  File SrcFile2=scrShot2.getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(SrcFile2, new File("C:\\TC04_Login\\TC1_ScreenShot2.jpg"));
	  
	  
	  findElement(By.id("txtPassword")).sendKeys("admin123");
	  TakesScreenshot scrShot3 =((TakesScreenshot)driver);
	  File SrcFile3=scrShot3.getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(SrcFile3, new File("C:\\TC04_Login\\TC1_ScreenShot3.png"));
	  
	 
	
	
	
	}
	
	
	
	
	
	
	
	
	 public  static WebElement findElement(By by) throws Exception 
		{
					
			 WebElement elem = driver.findElement(by);    	    
			
			 
			if (driver instanceof JavascriptExecutor) 
			{
			 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
		 
			}
			
			return elem;
		}
	 
	
	
	
	
	
	
	
	
	
	
	

}
