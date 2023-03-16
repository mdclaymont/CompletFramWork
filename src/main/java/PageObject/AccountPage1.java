package PageObject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Common.BaseClass;

public class AccountPage1 extends BaseClass {
	

	public AccountPage1()
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//*[@name='areaabb']") WebElement newpost;
	@FindBy(css="[value='go']") WebElement go;
	@FindBy(xpath="//*[contains(text(),'for sale by owner')]//parent::span//preceding-sibling::span/input" ) WebElement sellby ;
	@FindBy(xpath="//*[text()='cell phones - by owner']//parent::div//parent::label/input" ) WebElement sellcatagory ;
	@FindBy(xpath="//*[@class='dates posteddate active']/time" ) List<WebElement>  postdatecol;
	@FindBy(xpath="//*[@name='go' and (@value='delete' or @value='repost')]" ) List<WebElement> delete ;
	@FindBy(xpath= "//*[contains(text(),'Active') or contains(text(),'Deleted')]") List<WebElement> status ;
	
	/****************************************************************************************************/	
	public WebElement newpost()
		{
			return newpost;
		}
	/****************************************************************************************************/	
	public WebElement Go()
		{
			return go;
		}
	/****************************************************************************************************/	
	public WebElement SellBy()
		{
			return sellby;
		}
	/****************************************************************************************************/	
	public WebElement SellCatagory()
		{
			return sellcatagory;
		}
	/****************************************************************************************************/	
	public List<WebElement> postDateCol()
	{
		return postdatecol;
	}
	/****************************************************************************************************/	
	public List<WebElement> delete()
		{
			return delete;
		}
	/****************************************************************************************************/	
	public List<WebElement> Status()
		{
			return status;
		}

}
