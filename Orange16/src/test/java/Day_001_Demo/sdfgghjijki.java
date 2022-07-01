package Day_001_Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class sdfgghjijki {
	
WebDriver driver;	

String username,Password;

		@Test
		public void login_test() throws Exception
		{
			
			initlaunch();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		sdfgghjijki T1=new sdfgghjijki();
		T1.getInputdata();
		username="Admin";
		Password="admin123";
		//getInputdata();
		
		driver.findElement(By.name("txtUsername")).sendKeys(username);
		//driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys(Password);
		driver.findElement(By.id("btnLogin")).click();	
		
	
	
		}
		
		
		public void initlaunch()throws Exception
		{
			System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
			driver =new ChromeDriver();
			driver.manage().window().maximize() ;	
		}
		
		public void getInputdata() throws Exception
		{
			String username1="Admin";
			String Password1="admin123";
		}
		
		
	

}
