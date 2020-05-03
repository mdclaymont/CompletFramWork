package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.BaseClass;

public class DescriptionPage extends BaseClass{
	
	private By postingtitle=By.xpath("//input[@name='PostingTitle']");
	private By price=By.xpath("//input[@name='price']");
	private By postalcode=By.xpath("//input[@name='postal']");
	private By description=By.xpath("//*[@id='PostingBody']");
	private By condition=By.xpath("//*[@name='condition']");
	private By mobileosclick=By.xpath("//*[@name='mobile_os']//following-sibling::span");
	private By mobileOs=By.xpath("//*[@class='ui-selectmenu-menu ui-front ui-selectmenu-open']/ul/li");
	private By showphone=By.xpath("//*[@name='show_phone_ok']");
	private By phonenumber=By.xpath("//*[@name='contact_phone']");
	private By continueclick=By.xpath("//*[text()='continue']");
	private By addimage=By.xpath("//*[text()='Add Images']");
	private By doneimage=By.xpath("//*[text()='done with images']");
	private By publish=By.xpath("//*[text()='publish']");
	
	
	/****************************************************************************************************/	
	
	public WebElement postingTitle()
	{
		return driver.findElement(postingtitle);
	}
	/****************************************************************************************************/	
	public WebElement price()
	{
		return driver.findElement(price);
	}
	/****************************************************************************************************/	
	public WebElement postalCode()
	{
		return driver.findElement(postalcode);
	}
	/****************************************************************************************************/	
	public WebElement description()
	{
		return driver.findElement(description);
	}
	/****************************************************************************************************/	
	public WebElement condition()
	{
		return driver.findElement(condition);
	}
	/****************************************************************************************************/	
		
	public WebElement mobileOsClick()
	{
		return driver.findElement(mobileosclick);
	}
	/****************************************************************************************************/	
	//By mobileOs=By.xpath("//*[@name='mobile_os']/option");
	public List<WebElement> mobileOs()
	{
		return driver.findElements(mobileOs);
	}
	/****************************************************************************************************/	
	public  void setOs(String ExpOs)
	{
		mobileOsClick().click();
		//setSelect(dp.mobileOs()).
		
		
		for(int i=0;i<mobileOs().size();i++)
		{
		//	dp.mobileOs().sendKeys(Keys.ARROW_DOWN);
			String listValue=mobileOs().get(i).getText();
			System.out.println(listValue);
			if(listValue.contains(ExpOs))
			{
				mobileOs().get(i).click();
				break;
			}
		}
	}	
	/****************************************************************************************************/	
	public WebElement showPhone()
	{
		return driver.findElement(showphone);
	}
	/****************************************************************************************************/	
	public WebElement phoneNumber()
	{
		return driver.findElement(phonenumber);
	}
	/****************************************************************************************************/	
	public WebElement continueClick()
	{
		return driver.findElement(continueclick);
	}
	/****************************************************************************************************/	
	public WebElement addImage()
	{
		return driver.findElement(addimage);
	}
	/****************************************************************************************************/	
	public WebElement doneImage()
	{
		return driver.findElement(doneimage);
	}
	/****************************************************************************************************/	
	public WebElement publish()
	{
		return driver.findElement(publish);
	}

}
