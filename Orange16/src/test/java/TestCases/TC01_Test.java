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
import java.util.concurrent.TimeUnit;

//import org.testng.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.testng.Reporter;
import org.testng.annotations.*;

public class TC01_Test
{
	
	WebDriver driver;
	Reporter1 R1;
	ImageAttachmentInDocument1 IA;
	
	SimpleDateFormat sdfDate1 = new SimpleDateFormat("yyyy_MMM_dd_h_mm_ss_a");
	Date now1 = new Date();
	String strDate1 = sdfDate1.format(now1);
	
	//String TestName="TC01_Add_Nationality_"+strDate1;
	String TestName="TC019_"+strDate1;
	
	
	
	@DataProvider(name = "TC01_Add_Nationality")
	public static Object[][] Authentication1() throws Exception {
		
		ExcelApiTest4 eat = new ExcelApiTest4();
		Object[][] testObjArray = eat.getTableArray("C://HTML Report//OrangeHRM6//TC01_Nationality8.xlsx", "Sheet1");
		System.out.println(testObjArray.length);
		return (testObjArray);
	}

	
	
	
	@Test(dataProvider="TC01_Add_Nationality")
	public void Test567(String Browser,String TestURL,String UserName,String Password,String Nationality) throws Exception
	{
		
		try
		{
			

			if(Browser.equalsIgnoreCase("Chrome"))
			{
				driver = TestBrowser.OpenChromeBrowser();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				//driver.get(TestURL);
			
		    }
			

			
		
		IA = new ImageAttachmentInDocument1();
		IA.CreateHeader("Test Case : TC020 Add Nationality");
		
		/*SimpleDateFormat sdfDate1 = new SimpleDateFormat("yyyy_MMM_dd_h_mm_ss_a");
		Date now1 = new Date();
		String strDate1 = sdfDate1.format(now1);
		String TestName="TC01_Add_Nationality_"+strDate1;*/
		
			 
		R1= new Reporter1(driver, TestName );
		
		/*
		
	   // String str=R1.getScreenShotPath(driver);
		String str=R1.TakeScreenShotAuto(driver,"Login Page - Open OrangeHRM","Pass");
	    IA.PasteImage("Pass- open Orangehrm",str);
	    
	    
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
		findElement(By.id("btnLogin")).click();  */
		 
		 Login l1= new Login();
		 l1.Login(driver, R1,IA);
		 l1.Login_Screen(TestURL, "Admin", "admin123");
	
		Nationality Nati = new Nationality();
		Nati.Nationality(driver, R1,IA);
		Nati.NationalityDetails(Nationality);
		
		
		HomePage h1= new HomePage();
		h1.HomePage(driver, R1, IA);
		h1.Logout();
		
		}
		
		catch(NoSuchElementException e)
		{
			System.out.println("Error Message :"+e.getMessage());
			 R1.TakeScreenShotAuto(driver,e.getMessage(),"Fail");
		}
	 	
		catch(NoSuchFrameException  e)
		{
			System.out.println("Error Message :"+e.getMessage());
			 R1.TakeScreenShotAuto(driver,e.getMessage(),"Fail");
		}
		
		catch(Exception  e)
		{
			System.out.println("Error Message :"+e.getMessage());
			 R1.TakeScreenShotAuto(driver,e.getMessage(),"Fail");
		}
		
		
		finally
		{
			driver.close();
		    String Filename=IA.WordOutput_File(TestName);		    
		    WordConvertPDF.main(Filename);
		    
		}
		
	
		
		
		
		
	
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












