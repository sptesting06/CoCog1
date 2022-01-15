package cogTestNG;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TryTestNG1 {
WebDriver driver;
@BeforeMethod
public void tngmethod2() {
	System.out.println("this is before  method");
}
@Test
public void tngmethod1() {
	System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("https://www.orangehrm.com/");
	String expected = driver.getTitle();
	String actualTitle = "OrangeHRM HR Software | Free & Open Source HR Software | HRMS | HRIS";	
	Assert.assertEquals(driver.getTitle(), actualTitle);
	System.out.println("This title is not matched nowwwwwwwww");
	WebElement photo = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div[4]/div[1]/div[2]/img"));
	//if photo.isDisplayed()*
}
@AfterMethod
public void tngmethod3(ITestResult result) throws Exception{
	if(result.getStatus()==ITestResult.FAILURE) {
		TakesScreenshot tc = (TakesScreenshot) driver;
		File src = tc.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src,new File(result.getName()+".png"));
		
		
	}
	System.out.println("this is aftermethod");
}
	
	
	
	
	
	
}
