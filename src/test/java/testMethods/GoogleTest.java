package testMethods;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pom.GoogleSearchPage;
import pom.SearchResultPage;
import utilityFunctions.InitializeDriver;
import utilityFunctions.ScreenShotCapture;

public class GoogleTest {
	WebDriver driver;
	
	@BeforeMethod
	public void setup() throws IOException{
		InitializeDriver id=new InitializeDriver();		
		 driver=id.getDriver();		
	
	}

	@Test
	public void googleSearchTest1(){
	 driver.get("http://www.google.com");	
	 GoogleSearchPage gsp=new GoogleSearchPage(driver);
	 gsp.isLogoDisplayed();
	}
	
	@Test
	public void googleSearchTest2() throws IOException{			
		GoogleSearchPage gsp=new GoogleSearchPage(driver);
		gsp.enterTextInSearchBox("mobile integration workgroup");
		Reporter.log("Google search with selenium");
		ScreenShotCapture.capture("Google Search");
		gsp.enterSearch();		
		SearchResultPage srp=new SearchResultPage(driver);
		ScreenShotCapture.capture("Google Search Result");
		Reporter.log("Google search result page is displayed");
		String href=srp.getFirstLink();
		Assert.assertEquals(href, "https://miwtech.com/");
		ScreenShotCapture.capture("FirstLink");
		Reporter.log("First link is displayed");
	}

	@AfterTest
	public void cleanUp(){
		driver.close();
	}

}
