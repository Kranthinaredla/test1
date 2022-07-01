package Pages;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Reporter_Example_Word.ImageAttachmentInDocument1;
import Reporter_Example_Word.Reporter1;

public class loginpage1 {
	WebDriver driver;
	String str;
	Reporter1 R1;
    ImageAttachmentInDocument1 IA1;
    
    
    String Username="//*[@id='txtUsername']";
    String Password="//*[@id='txtPassword']";
    String Button="//*[@id='btnLogin']";

    public void   loginpage1(WebDriver driver,Reporter1 R1,ImageAttachmentInDocument1 IA2)
    {
this.driver=driver;
this.R1=R1;
this.IA1=IA2;
}
 public void login(String TestURL,String UserName,String Password) throws Exception
 {
	 try
	 {
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 driver.get(TestURL);
		 
		 str=R1.TakeScreenShotAuto(driver, "loginpage-OrangeHRM loginpage", "Pass");
		 IA1.PasteImage("loginpage-OrangeHRM loginpage", str);
		 
		 
		 driver.findElement(By.xpath(Username)).sendKeys(UserName);
		 driver.findElement(By.xpath(Password)).sendKeys(Password); 
		 driver.findElement(By.xpath(Button)).click(); 
		 
	 }
	 catch(NoSuchElementException e)
	 {
		 System.out.println("Error Message:"+e.getMessage());
		 String str=R1.TakeScreenShotAuto(driver,e.getMessage(),"Fail");
		 IA1.PasteImage("NoSuchElementException Occured", str);
	 }
	 catch(NoSuchFrameException e)
	 {
		System.out.println("Error Message:"+e.getMessage());
		String str=R1.TakeScreenShotAuto(driver, e.getMessage(),"Fail");
		IA1.PasteImage("NoSuchFrameException", str);
	 }
	 catch(ElementNotInteractableException e)
	 {
		System.out.println("ElementNotInteractableException:"+e.getMessage());
		String str=R1.TakeScreenShotAuto(driver,e.getMessage(),"Fail");
		IA1.PasteImage("ElementNotInteractableException", str);
	 }
	 catch(Exception e)
	 {
		 System.out.println("Error Message:"+e.getMessage());
		 R1.TakeScreenShotAuto(driver,e.getMessage(),"Fail");
		 IA1.PasteImage("Invalid", str);
	 }
		
 }
 public  WebElement findElement(By by) throws Exception {
		
	    WebElement elem = driver.findElement(by);
	    	    
	   
	    if (driver instanceof JavascriptExecutor) {
	        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	            
	    }
	    return elem;
	}
	 }
 