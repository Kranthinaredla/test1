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
import org.testng.Reporter;
import org.testng.annotations.*;

public class TC01_Add_Language
{
	
	WebDriver driver;
	
	
	//Step1 - Data Provider Syntax
		@DataProvider(name = "Orange1")
		public static Object[][] Authentication1() throws Exception {
			
			ExcelApiTest4 eat = new ExcelApiTest4();
			Object[][] testObjArray = eat.getTableArray("C://HTML Report//OrangeHRM6//TC01_Add_Language11.xlsx", "Sheet1");
			System.out.println(testObjArray.length);
			return (testObjArray);
		}
		
	
	
	
	@Test(dataProvider="Orange1")
	public void Test1(String Browser,String TestURL,String Username,String Password,String LanguageName) throws Exception {
		

		ImageAttachmentInDocument1 IA = new ImageAttachmentInDocument1();
		IA.CreateHeader("Test Case : TC01 Add Language");
		
		SimpleDateFormat sdfDate1 = new SimpleDateFormat("yyyy_MMM_dd_h_mm_ss_a");
		Date now1 = new Date();
		String strDate1 = sdfDate1.format(now1);
		String TestName="TC01_Add_Language_"+strDate1;
		//String TestName="TC001 Add Language";
			 
		Reporter1 R1= new Reporter1(driver, TestName );
		
		//driver = TestBrowser.OpenChromeBrowser();
		
		if(Browser.equalsIgnoreCase("Chrome"))
		{
			driver = TestBrowser.OpenChromeBrowser();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 	
	    }

		if(Browser.equalsIgnoreCase("FireFox"))
		{
				driver = TestBrowser.FirefoxBrowser();
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				Thread.sleep(7000);
		}

		
		
		
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	
	
		Login Log=new Login();
		Log.Login(driver, R1,IA);
		Log.Login_Screen(TestURL,Username,Password);
		
		Language L1=new Language();
		L1.Language(driver, R1,IA);
		L1.AddLanguage(LanguageName);
		
		HomePage h1= new HomePage();
		h1.HomePage(driver, R1, IA);
		h1.Logout();

		
		driver.close();
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












