package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage {
	
	WebDriver driver;
	
	public SearchResultPage(WebDriver driver){
		this.driver=driver;
	}
	
	private final By link_results=By.xpath("//div[@id='search']//div[@class='r']/a");
	private final By firstLink=By.xpath("(//div[@id='search']//a)[1]");
	private final By p_message=By.xpath("//p[@role='heading']");
	
	
	public void clickOnPerticularLink(int number){
		
		List<WebElement> list=driver.findElements(link_results);
		
		for(int i=0;i<list.size();i++){
			
			WebElement element=list.get(i);
			
			if(i==(number-1)){
				element.click();
				break;
			}
			
			
		}
			
	}
	
	public String getFirstLink(){		
		String text=driver.findElement(firstLink).getAttribute("href");
		return text;
	}
	
	
	public String getSearchResult(){
		
		String strMessage=driver.findElement(p_message).getText();
		
		return strMessage;
		
	}
	
	

}
