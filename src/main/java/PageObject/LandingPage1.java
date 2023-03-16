package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Common.BaseClass;


public class LandingPage1 extends BaseClass {
	WebDriver driver;
	public LandingPage1(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);			//Create WebElements
	}
	@FindBy(xpath="//*[text()='my account']") public static WebElement myaccount; 
	
	
	
	
		
	
	
	
	
	
	
	
	
	

}
