package testMethods;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilityFunctions.InitializeDriver;

public class RbaAuctionTest {

	WebDriver driver;
	
	@BeforeMethod
	public void setup() throws IOException{
		InitializeDriver id=new InitializeDriver();		
		 driver=id.getDriver();		
		 driver.navigate().to("https://www.rbauction.com");
	}
	

	@Test
	public void test1() throws IOException{			
	driver.findElement(By.id("adv-toggle-down")).click();
	driver.findElement(By.id("adv-keyword")).sendKeys("excavator");
	driver.findElement(By.xpath("//input[@aria-activedescendant='react-select-2--value']")).sendKeys("Construction");
	driver.findElement(By.xpath("//input[@aria-activedescendant='react-select-2--value']")).sendKeys(Keys.TAB);
	driver.findElement(By.id("adv-make")).sendKeys("CATERPILLAR");
	driver.findElement(By.id("adv-model")).sendKeys("2017");
	driver.findElement(By.id("adv-submit-button")).click();
	
	String meterReads=driver.findElement(By.xpath("(//p[contains(@id,'ci_meterReads')])[3]")).getText();
	System.out.println("Meter Reads for 3rd result: "+meterReads);
	
	String details=driver.findElement(By.xpath("(//p[contains(@id,'_ci_details')])[3]")).getText();
	System.out.println("Details for 3rd Result "+ details);
	
	
	
	}
}
