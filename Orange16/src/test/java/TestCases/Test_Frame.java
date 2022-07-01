package TestCases;

import static org.junit.Assert.assertFalse;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import CommonUtil.OR;
import CommonUtil.TestBrowser;

public class Test_Frame {
	
	WebDriver driver;
	
  @Test
  public void frames1() throws Exception {
	  
	  driver=TestBrowser.OpenChromeBrowser();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  driver.get("https://s1.demo.opensourcecms.com/s/44");
	  
		Thread.sleep(6000);
	  
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		//System.out.println("Numnber of frames: " + frames.size());
		
		driver.switchTo().frame(frames.get(0));
	  
	  findElement(By.xpath(OR.username_sendkey)).sendKeys("opensourcecms");
	  findElement(By.xpath(OR.password_sendkey)).sendKeys("opensourcecms");
		findElement(By.id("btnLogin")).click();
	  
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(5000);
		
		 driver.get("https://s2.demo.opensourcecms.com/orangehrm/");
		 
		 String pageSource = driver.getPageSource();
		 
		 System.out.println(pageSource);
		 
		
		
		// driver.get(" https://s2.demo.opensourcecms.com/orangehrm/");
		
		//Frame 
		//driver.switchTo().frame(frames.get(1));
		
		
		//Frame 
		///List<WebElement> frames1 = driver.findElements(By.tagName("iframe"));
		//System.out.println(" Total frames on homepage : " + frames1.size());
		
			//driver.switchTo().frame(frames1.get(0));
				
				WebElement Admin=findElement(By.xpath(OR.Admin12));
				WebElement Qualifications=findElement(By.xpath(OR.Qualifications12));
				WebElement SKills=findElement(By.xpath(OR.SKills12));

				
				Actions actions = new Actions(driver);
				 actions.moveToElement(Admin).
				 moveToElement(Qualifications).
				 moveToElement(SKills).click().build().perform();
				 
			
				 
				 // driver.findElement(By.xpath("//li[@id='admin']/ul/li[3]/ul/li/a/span")).click();
				    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | index=0 | ]]
				//    driver.findElement(By.id("btnAdd")).click();
				 
				// driver.switchTo().defaultContent();
				 
				 // driver.findElement(By.xpath("//li[@id='admin']/ul/li[3]/ul/li/a/span")).click();
				    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | index=0 | ]]
				   // driver.findElement(By.id("btnAdd")).click();
				 
				 
				// findElement(By.xpath("//*[@id='btnAdd']"));
				 
				// Thread.sleep(5000);
				 
				// driver.navigate().refresh();
				 
					//List<WebElement> frames2 = driver.findElements(By.tagName("iframe"));
					//System.out.println(" Total frames on homepage : " + frames2.size());
					
					//driver.switchTo().frame(frames2.get(1));
					
					 Thread.sleep(5000);
					 
					// findElement(By.id("rightMenu"));
					 
					 //driver.switchTo().frame(driver.findElement(By.id("rightMenu")));
					 
					 //waitForPageLoaded(driver);
					 
					 //https://s2.demo.opensourcecms.com/orangehrm/
					 
				
					
					 
					 driver.switchTo().frame("rightMenu");
					 findElement(By.xpath("//h2[text()='Skills']"));
					 
					 
				
					 
					// findElement(By.xpath("/html/body/div[6]/iframe"));
					// findElement(By.xpath("//*[@id='rightMenu']"));
					 
					// driver.switchTo().frame(driver.findElement(By.xpath("/html/body/div[6]/iframe")));
					 
					 //findElement(By.cssSelector("input#btnAdd.addbutton"));
					 
					
				
					findElement(By.xpath("//*[@id=\"btnAdd\"]"));
					findElement(By.xpath("//*[@id=\"btnAdd\"]")).click();
					// List<WebElement> obj=driver.findElements(By.xpath("//*[@id='Container']//*"));
					 
					 
					 /*WebElement frame=driver.findElement(By.id("recordsListDiv"));
					 driver.switchTo().frame(frame);
						
					WebElement AddButton=findElement(By.cssSelector("input#btnAdd.addbutton"));
					// actions.moveToElement(AddButton).click().build().perform();
					 
					  JavascriptExecutor js = (JavascriptExecutor)driver;
				        
				       
				        js.executeScript("arguments[0].click();", AddButton);*/
					
					// driver.switchTo().defaultContent();
				 
				 
	  
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
	
	
	public void waitForPageLoaded(WebDriver driver) {
	    ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
	        public Boolean apply(WebDriver driver) {
	            return ((JavascriptExecutor) driver).executeScript(
	            "return document.readyState").equals("complete");
	        }
	    };
	    Wait<WebDriver> wait = new WebDriverWait(driver, 30);
	    try {
	        wait.until(expectation);
	    } catch (Throwable error) {
	        assertFalse("Timeout waiting for Page Load Request to complete.",
	        true);
	    }
	}
  
  
}
