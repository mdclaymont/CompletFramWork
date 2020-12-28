package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.BaseClass;


public class LandingPage extends BaseClass {
	//public static WebDriver driver;
	private By Myaccount=By.xpath("//*[text()='my account']");
	
	public WebElement myAccount()
	{
		
		return driver.findElement(Myaccount);
	}
	
	
	
	
	
	

}
