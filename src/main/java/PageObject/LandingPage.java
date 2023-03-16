package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Common.BaseClass;


public class LandingPage extends BaseClass {
	
	private By Myaccount=By.xpath("//*[text()='my account']");
	
	public WebElement myAccount()
	{
		
		return driver.findElement(Myaccount);
	}
	
	
	
	
	
	

}
