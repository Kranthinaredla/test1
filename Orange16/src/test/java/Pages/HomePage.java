package  Pages;
//import MercuryDemoTours;


import Reporter_Example_Word.ImageAttachmentInDocument1;
import Reporter_Example_Word.Reporter1;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



public class HomePage
{
	
	
	//public  static 	String UserName, Password ;
	 WebDriver driver;

	
	 Reporter1 R1;
	
	 ImageAttachmentInDocument1 IA1;

	
	public void  HomePage(WebDriver driver,Reporter1 R1 , ImageAttachmentInDocument1 IA2)throws Exception
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
	
	
	
	public   void Logout()throws Exception
	 {
		
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 findElement(By.id("welcome")).click();	 
		 
		 //Thread.sleep(300);
		 findElement(By.linkText("Logout"));
		 
		 //R1.TakeScreenShotAuto(driver,"HomePage - Logout","Pass");
		 
		   String str=R1.TakeScreenShotAuto(driver,"HomePage - Logout","Pass");
		    IA1.PasteImage("HomePage - Logout",str);
		 
		 
		 findElement(By.linkText("Logout")).click();
		 
		// Thread.sleep(300);
	
		 
		 	str=R1.TakeScreenShotAuto(driver,"Login - after Logout","Pass");
		    IA1.PasteImage("HomePage -  after Logout",str);
		 
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
		 


	


	
	