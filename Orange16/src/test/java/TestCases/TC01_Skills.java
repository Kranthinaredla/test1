package  TestCases;
import CommonUtil.*;
import ExcelUtil.ExcelApiTest4;
import Pages.*;

import Reporter_Example_Word.ImageAttachmentInDocument1;

import Reporter_Example_Word.Reporter1;
import Reporter_Example_Word.WordConvertPDF;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

//import org.testng.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.testng.Reporter;
import org.testng.annotations.*;

public class TC01_Skills
{
	
	WebDriver driver;
	Reporter1 R1;
	ImageAttachmentInDocument1 IA;
	String TestName="TC019";
	
	
	
	@DataProvider(name = "TC01_Add_Nationality")
	public static Object[][] Authentication1() throws Exception {
		
		ExcelApiTest4 eat = new ExcelApiTest4();
		Object[][] testObjArray = eat.getTableArray("C://HTML Report//OrangeHRM6//TC01_EMPExport4.xlsx", "Sheet1");
		System.out.println(testObjArray.length);
		return (testObjArray);
	}

	
	
	
	@Test(dataProvider="TC01_Add_Nationality")
	public void Test567(String Browser,String TestURL,String UserName,String Password,String SKillName,String SkillDescr) throws Exception
	{
		
			

			if(Browser.equalsIgnoreCase("Chrome"))
			{
				driver = TestBrowser.OpenChromeBrowser();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.get(TestURL);
			
		    }
			

			
		
		IA = new ImageAttachmentInDocument1();
		IA.CreateHeader("Test Case : TC019 Add Nationality");
		
		/*SimpleDateFormat sdfDate1 = new SimpleDateFormat("yyyy_MMM_dd_h_mm_ss_a");
		Date now1 = new Date();
		String strDate1 = sdfDate1.format(now1);
		String TestName="TC01_Add_Nationality_"+strDate1;*/
		
			 
		R1= new Reporter1(driver, TestName );
		
	   // String str=R1.getScreenShotPath(driver);
		String str=R1.TakeScreenShotAuto(driver,"Login Page - Open OrangeHRM","Pass");
	    IA.PasteImage("Pass- open Orangehrm",str);
	    
	    
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		System.out.println("Numnber of frames: " + frames.size());
		
		
		//Frame 
		driver.switchTo().frame(frames.get(0));
	    
		findElement(By.xpath(OR.username_sendkey)).sendKeys(UserName);
		str=R1.TakeScreenShotAuto(driver,"Login Page - Enter Username","Pass");
		//str=R1.getScreenShotPath(driver);
		
	    IA.PasteImage("Pass- Enter User Name",str);
		
		
	    findElement(By.xpath(OR.password_sendkey)).sendKeys(Password);	
	    
	    str=R1.TakeScreenShotAuto(driver,"Login Page - Enetr Password","Pass");
	    IA.PasteImage("Pass- Enter Password",str);
		
	    
		findElement(By.id("btnLogin"));
		str=R1.TakeScreenShotAuto(driver,"Login Page - Click Loginbutton","Pass");
		IA.PasteImage("Pass- Enter Password",str);
		
	
		
		R1.TakeScreenShotAuto(driver,"Login Page - Total Signin Page","Pass");
		findElement(By.id("btnLogin")).click();
		
		driver.switchTo().defaultContent();
		

		Skills s1=new Skills();
		s1.Skills(driver, R1, IA);
		s1.SkillsNavigation();
		///s1.AddSkills(SKillName,SkillDescr);
		
		//HomePage h1= new HomePage();
		//h1.HomePage(driver, R1, IA);
		//h1.Logout();
	
		
	
		    String Filename=IA.WordOutput_File(TestName);		    
		    WordConvertPDF.main(Filename);
		    
		
		
	
		
		
		
		
	
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
		
	
	
	
	
	
	
	
	

}












