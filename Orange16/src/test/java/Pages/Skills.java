package  Pages;
//import MercuryDemoTours;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import CommonUtil.OR;
import Reporter_Example_Word.Reporter1;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Reporter_Example_Word.ImageAttachmentInDocument1;


public class Skills
{
	
	
	//public  static 	String UserName, Password ;
	 WebDriver driver;
	
	 ImageAttachmentInDocument1 IA1;
	 
	 Reporter1 R1;

	
	public void  Skills(WebDriver driver,Reporter1 R1 , ImageAttachmentInDocument1 IA2)throws Exception
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
	
	
	
	
	
	



public   void SkillsNavigation()throws Exception
{  
	

	try 
	{
	
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		//System.out.println("Numnber of frames: " + frames.size());
		
		
		//Frame 
		driver.switchTo().frame(frames.get(0));
		
		WebElement Admin=findElement(By.xpath(OR.Admin12));
		WebElement Qualifications=findElement(By.xpath(OR.Qualifications12));
		WebElement SKills=findElement(By.xpath(OR.SKills12));

		
		Actions actions = new Actions(driver);
		 actions.moveToElement(Admin).
		 moveToElement(Qualifications).
		 moveToElement(SKills).click().build().perform();
		 
		
		 
		 
		driver.switchTo().defaultContent();
		 
		// WebDriverWait wait = new WebDriverWait(driver, 15);
     //    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("preview-frame"));
		
		 
			//List<WebElement> frames1 = driver.findElements(By.tagName("iframe"));
			//System.out.println("Numnber of frames afte resfreh: " + frames1.size());
			
			
			//Frame 
		
		 
		 Thread.sleep(5000);
		 
		 
		  findElement(By.xpath("//h2[text()='Skills']"));
			
			//driver.switchTo().frame(findElement(By.xpath("//h2[text()='Skills']")));
			

			findElement(By.id("btnAdd")).click();
			    driver.findElement(By.id("skill_name")).click();
			    driver.findElement(By.id("skill_name")).clear();
			    driver.findElement(By.id("skill_name")).sendKeys("Oracle10");
			    driver.findElement(By.id("skill_description")).click();
			    driver.findElement(By.id("skill_description")).clear();
			    driver.findElement(By.id("skill_description")).sendKeys("Oracle10dex");
			    driver.findElement(By.id("btnSave")).click();
				
			    driver.switchTo().defaultContent();
	 
		
	} 
	
	
	catch(NoSuchElementException e)
	{
		System.out.println("Error Message :"+e.getMessage());
		String str= R1.TakeScreenShotAuto(driver,e.getMessage(),"Fail");
		 IA1.PasteImage("Nationality Page - Scroll and verify the record details",str);
	}
	
 	catch(NoSuchFrameException  e)
	{
		System.out.println("Error Message :"+e.getMessage());
		String str= R1.TakeScreenShotAuto(driver,e.getMessage(),"Fail");
		 IA1.PasteImage(" Invalid ",str);
	}
	catch(Exception  e)
	{
		System.out.println("Error Message :"+e.getMessage());
		String str= R1.TakeScreenShotAuto(driver,e.getMessage(),"Fail");
		 IA1.PasteImage(" Invalid ",str);
	}
 	
 	
	 
	
 
}
	
	
		 











// Add skill method starts


public   void AddSkills(String SkillName1,String Skilldescr1)throws Exception
{  
	

	
		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		Thread.sleep(5000);
		
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		System.out.println("Numnber of frames 123: " + frames.size());
		
		Thread.sleep(5000);
		
		//Frame 
		//driver.switchTo().frame(driver.findElement(By.name("preview-frame")));
		
		
		//findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[2]/div/input[1]"));
		//findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[2]/div/input[1]")).click();
		
		System.out.println("Numnber of frames 1234: " + frames.size());
		
		
		findElement(By.id("btnAdd")).click();
		    driver.findElement(By.id("skill_name")).click();
		    driver.findElement(By.id("skill_name")).clear();
		    driver.findElement(By.id("skill_name")).sendKeys("Oracle10");
		    driver.findElement(By.id("skill_description")).click();
		    driver.findElement(By.id("skill_description")).clear();
		    driver.findElement(By.id("skill_description")).sendKeys("Oracle10dex");
		    driver.findElement(By.id("btnSave")).click();
	    
		 driver.switchTo().defaultContent();
		 
		 
		
	 
	
 
}
	



//Add SKill method ends
























		 
}
	


	
	