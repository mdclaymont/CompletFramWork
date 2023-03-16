package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Common.BaseClass;


public class AccountPage extends BaseClass {
	
	private By newpost=By.xpath("//*[@name='areaabb']");
	private By go=By.cssSelector("[value='go']");
	private By sellby=By.xpath("//*[contains(text(),'for sale by owner')]//parent::span//preceding-sibling::span/input");
	private By sellcatagory=By.xpath("//*[text()='cell phones - by owner']//parent::div//parent::label/input");
	private By postdatecol=By.xpath("//*[@class='dates posteddate active']/time");
	private By delete=By.xpath("//*[@name='go' and (@value='delete' or @value='repost')]");
	private By status=By.xpath("//*[contains(text(),'Active') or contains(text(),'Deleted')]");
	
	
	
	
	public WebElement newpost()
	{
		return driver.findElement(newpost);
	}
	/****************************************************************************************************/	
	public WebElement Go()
	{
		return driver.findElement(go);
	}
	/****************************************************************************************************/	
		public WebElement SellBy()
	{
		return driver.findElement(sellby);
	}
		/****************************************************************************************************/	
	public WebElement SellCatagory()
	{
		return driver.findElement(sellcatagory);
	}
	/****************************************************************************************************/	
	
	public List<WebElement> postDateCol()
	{
		return driver.findElements(postdatecol);
	}
	/****************************************************************************************************/	
	public List<WebElement> delete()
	{
		return driver.findElements(delete);
	}
	/****************************************************************************************************/	
	public List<WebElement> Status()
	{
		return driver.findElements(status);
	}
	
	
	

}
