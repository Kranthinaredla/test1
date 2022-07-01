package Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentTest;

public class Employeelist1 {
	WebDriver driver;
	
	ExtentTest logger;
	ExtentReporter Extent;
	String screenShotPath;
	String TestScriptName;
	
	public void Employeelist1(WebDriver driver,ExtentTest logger,ExtentReporter Extent,String TestScriptName) throws Exception
	{
		this.driver=driver;
		this.logger=logger;
		this.Extent=Extent;
		this.TestScriptName=TestScriptName;
		
	}
	
	public void personalDetails(String Firstname,String MiddleName,String LastName,String FilePath) throws Exception
	{
		
    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    
    findElement(By.linkText("PIM")).click();
    findElement(By.linkText("Employee List")).click();
    findElement(By.linkText("0272")).click();	
    
  //*[@id="btnSave"]
    findElement(By.xpath("//*[@id='btnSave']")).click();
    
    findElement(By.linkText("Personal Details")).click();	
    findElement(By.id("personal_txtEmpFirstName")).sendKeys(Firstname);
    findElement(By.id("personal_txtEmpMiddleName")).sendKeys(MiddleName);
    findElement(By.id("personal_txtEmpLastName")).sendKeys(LastName);
    findElement(By.id("btnSave")).click();	
    findElement(By.id("btnSave")).click();	
    //add customFields
    
    findElement(By.id("btnEditCustom")).click();	
   
    List<WebElement> elements=driver.findElements(By.name("custom1"));
    
    for(WebElement element:elements)
    {
    	if(element.getText().equalsIgnoreCase("AB+"))
    	{
    		element.click();
    	}
    	System.out.println(element.getText());
    }
     
    //Select dropDown=new Select(driver.findElement(By.name("custom1")));
    //dropDown.selectByValue("A+");
    
    findElement(By.id("btnEditCustom")).click();
    
    
    
    findElement(By.id("btnAddAttachment")).click();
    
    
    WebElement SelectFile=findElement(By.id("ufile"));
    Actions actions=new Actions(driver);
    actions.moveToElement(SelectFile).click().build().perform();
    
    PhotoUpload(FilePath);
    
    
	}
	
	

	public void PhotoUpload(String filePath) throws Exception {
		StringSelection sel=new StringSelection(filePath); //ctrl  C action
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
		
		//ctrl v
    	Robot robot=new Robot();
    	robot.keyPress(KeyEvent.VK_CONTROL);
    	robot.keyPress(KeyEvent.VK_V);;
    	
    	robot.keyRelease(KeyEvent.VK_CONTROL);
    	robot.keyRelease(KeyEvent.VK_V);
    	
    	
		//Enter key action
    	
    	robot.keyPress(KeyEvent.VK_ENTER);
    	robot.keyRelease(KeyEvent.VK_ENTER);
    	
    	findElement(By.id("txtAttDesc")).click();
    	
    	findElement(By.id("btnSaveAttachment")).click();
	}

	
	public   WebElement findElement(By by) throws Exception 
	{

		WebElement elem = driver.findElement(by);  
		
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		return elem;

}
}