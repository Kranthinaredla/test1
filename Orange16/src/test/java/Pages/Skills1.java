package  Pages;
//import MercuryDemoTours;


import Reporter_Example_Word.ImageAttachmentInDocument1;
import Reporter_Example_Word.Reporter1;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;



public class Skills1
{
	
	
	String username_sendkey="//input[@id='txtUsername']";
	String password_sendkey="//input[@id='txtPassword1233']";
	String login_click="//input[@id='btnLogin']";
	
	String uid="txtUsername";
	
	//public  static 	String UserName, Password ;
	 WebDriver driver;
	 String str;
	
	 Reporter1 R1;
	
	 ImageAttachmentInDocument1 IA1;

	
	public void  Login(WebDriver driver,Reporter1 R1 , ImageAttachmentInDocument1 IA2)throws Exception
	{  
		this.driver=driver;
		this.R1=R1;
		this.IA1=IA2;
	}
	
	
	
	
	// Draws a red border around the found element. Does not set it back anyhow.
	public  WebElement findElement(By by) throws Exception {
		
	    WebElement elem = driver.findElement(by);
	    	    
	    // draw a border around the found element
	    if (driver instanceof JavascriptExecutor) {
	        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	        
	  //  TH3.HTMLScreenShot("Screen Shot","Click Here","Pass", HtmlOutputFileName,driver);
	        
	    }
	    return elem;
	}
	
	
	
	public   void AddSKills1(String TestURL,String UserName,String Password)throws Exception
	 {
		 
		 	try
		 	{
		 		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 		 driver.get(TestURL);
		 		 
		 		 str=R1.TakeScreenShotAuto(driver,"Login Page - Orange HRM Login Page","Pass");
		 		 IA1.PasteImage("Login Page - Orange HRM Login Page",str);
		
		 		 
				
	
				findElement(By.xpath(username_sendkey)).sendKeys(UserName); 
				findElement(By.xpath(password_sendkey)).sendKeys(Password);
				findElement(By.xpath(login_click));
				
				str=R1.TakeScreenShotAuto(driver,"Login Page - credentials","Pass");
			    IA1.PasteImage("Login Page - credentials",str);
		
			 	findElement(By.xpath(login_click)).click();
			 	
 
	 		}
		 	catch(NoSuchElementException e)
			{
		 		System.out.println("Error Message :"+e.getMessage());
				String str= R1.TakeScreenShotAuto(driver,e.getMessage(),"Fail");
				 IA1.PasteImage(" NoSuchElementException Occured ",str);
			}
		 	catch(NoSuchFrameException  e)
			{
				System.out.println("Error Message :"+e.getMessage());
				 R1.TakeScreenShotAuto(driver,e.getMessage(),"Fail");
			}
		 	catch(ElementNotInteractableException  e)
			{
				System.out.println("ElementNotInteractableException :"+e.getMessage());
				 R1.TakeScreenShotAuto(driver,e.getMessage(),"Fail");
			}
		 	catch(Exception  e)
			{
				System.out.println("Error Message :"+e.getMessage());
				String str= R1.TakeScreenShotAuto(driver,e.getMessage(),"Fail");
				 IA1.PasteImage(" Invalid ",str);
			}
		 	
		 	
		 	
		 	
		 	
	 }
	
	
	 
}
	
	
	
	
	
	
	
	
	
	
	
	
	





























	
	
	
	
	
	
	
	
	/*public   void Admin()throws Exception
	 {
		 findElement(By.linkText("Admin")); 
		 Thread.sleep(100);
		 TH3.HTMLScreenShot("HomePage - Admin Menu ","Clicked on Admin","Pass", HtmlOutputFileName,driver);
		 findElement(By.linkText("Admin")).click(); 
	 }
	
	public   void PIM()throws Exception
	 {
		 findElement(By.linkText("PIM")); 
		 Thread.sleep(100);
		 TH3.HTMLScreenShot("HomePage - PIM Menu ","Clicked on PIM","Pass", HtmlOutputFileName,driver);
		 findElement(By.linkText("PIM")).click(); 
	 }
	
	
	public   void Leave()throws Exception
	 {
		 findElement(By.linkText("Leave")); 
		 Thread.sleep(100);
		 TH3.HTMLScreenShot("HomePage - Leave Menu ","Clicked on Leave","Pass", HtmlOutputFileName,driver);
		 findElement(By.linkText("Leave")).click(); 
	 }
	
	
	public   void Time()throws Exception
	 {
		 findElement(By.linkText("Time")); 
		 Thread.sleep(100);
		 TH3.HTMLScreenShot("HomePage - Time Menu ","Clicked on Time","Pass", HtmlOutputFileName,driver);
		 findElement(By.linkText("Time")).click(); 
	 }
	
	public   void Recruitment()throws Exception
	 {
		 findElement(By.linkText("Recruitment")); 
		 Thread.sleep(100);
		 TH3.HTMLScreenShot("HomePage - Recruitment Menu ","Clicked on Recruitment","Pass", HtmlOutputFileName,driver);
		 findElement(By.linkText("Recruitment")).click(); 
	 }
	
	
	public   void Performance()throws Exception
	 {
		 findElement(By.linkText("Performance")); 
		 Thread.sleep(100);
		 TH3.HTMLScreenShot("HomePage - Performance Menu ","Clicked on Performance","Pass", HtmlOutputFileName,driver);
		 findElement(By.linkText("Performance")).click(); 
	 }
	
	
	public   void Dashboard()throws Exception
	 {
		 findElement(By.linkText("Dashboard")); 
		 Thread.sleep(100);
		 TH3.HTMLScreenShot("HomePage - Dashboard Menu ","Clicked on Dashboard","Pass", HtmlOutputFileName,driver);
		 findElement(By.linkText("Dashboard")).click(); 
	 }
	
	public   void Directory()throws Exception
	 {
		 findElement(By.linkText("Directory")); 
		 Thread.sleep(100);
		 TH3.HTMLScreenShot("HomePage - Directory Menu ","Clicked on Directory","Pass", HtmlOutputFileName,driver);
		 findElement(By.linkText("Directory")).click(); 
	 }
	
	
	public   void Maintenance()throws Exception
	 {
		 findElement(By.linkText("Maintenance")); 
		 Thread.sleep(100);
		 TH3.HTMLScreenShot("HomePage - Maintenance Menu ","Clicked on Maintenance","Pass", HtmlOutputFileName,driver);
		 findElement(By.linkText("Maintenance")).click(); 
	 }
	
	
	*/
		 


	


	
	