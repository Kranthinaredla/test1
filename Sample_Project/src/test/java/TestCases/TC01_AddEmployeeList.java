package TestCases;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import CommonUtil.TestBrowser;
import ExcelUtil.ExcelApiTest4;
import Extent_Reports.*;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.Nationalities;
import Pages.loginpage1;
public class TC01_AddEmployeeList {
	WebDriver driver;
	
	Map<String ,HashMap<String,String>> Datatable=new HashMap<String,HashMap<String,String>>();
	
	
	ExtentTest logger;
	ExtentReports extent;
	String screenShotPath;
	public static String TestScriptName;
	public static String TestName;
	
	@BeforeTest
	public void TestsetUp() throws Exception
	{
		driver = TestBrowser.OpenChromeBrowser();
		String TestURL = "https://opensource-demo.orangehrmlive.com/";
		driver.get(TestURL);
	
	
	ExcelApiTest4 eat = new ExcelApiTest4();
	
	 Datatable=eat.getDataTable("C:\\HTML Report\\OrangeHRM6\\TC01_Employeelist.xlsx","Sheet1");
	 
	 TestScriptName=(Datatable.get("TC01").get("TestName"));
	 
	//Extent HTML Report Creation Starts
	 
	SimpleDateFormat sdfDate=new  SimpleDateFormat("yyyy_MM_dd_hh_mm_ss_SSS_a");
	Date now=new Date();
	String strDate=sdfDate.format(now);
	
	TestName=TestScriptName+"_"+strDate+".html";
	 
	TestScriptName=TestScriptName+"_"+strDate;
	
	String TestHtmlName="C:/HTML Report/test-output/ExtentReportScreenShots/"+TestScriptName+"/"+TestName;
	
	ExtentHtmlReporter reporter=new ExtentHtmlReporter(TestHtmlName);
	System.out.println("Html path is:"+TestHtmlName);
	
	 extent=new ExtentReports();
	 extent.attachReporter(reporter);
	 logger=extent.createTest(TestName);
	//Extent HTML Report Creation Ends
	
}
	
  @Test
  public void Test1() {
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	    String UserName= Datatable.get("TC01").get("UserName");
		String Password= Datatable.get("TC01").get("Password");
		String Firstname= Datatable.get("TC01").get("Firstname");
		String MiddleName= Datatable.get("TC01").get("MiddleName");
		String LastName= Datatable.get("TC01").get("LastName");
		String FilePath= Datatable.get("TC01").get("FilePath");
  }
  loginpage1 L1 = new loginpage1();
	L1.loginpage1(driver,TestScriptName,logger,extent);
	L1.login(UserName,Password);
	
	Nationalities N1= new Nationalities();
	N1.Nationalities(driver,TestScriptName,logger,extent);
	N1.AddNationality(Nationality);
	
	HomePage H1= new HomePage();
	H1.HomePage(driver,TestScriptName,logger,extent);
	H1.Logout();
}




@AfterTest 
public void  TestCloser()throws Exception {	
	driver.quit();
	extent.flush();
}
}
