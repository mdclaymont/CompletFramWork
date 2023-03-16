package PageObject;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Common.BaseClass;

public class LogInPage extends BaseClass {
	private By inputid=By.xpath("//*[@name='inputEmailHandle']");
	private By UiPassword=By.xpath("//*[@name='inputPassword']");
	private By login=By.xpath("//*[contains(@id,'login')]");
	private By logout=By.xpath("//a[text()='Log out']");
	
	
	/****************************************************************************************************/	
	public WebElement Inputid()
		{
			return driver.findElement(inputid);
		}
	/****************************************************************************************************/	
	public WebElement InputPassword()
	
		{
			return driver.findElement(UiPassword);
		}
	/****************************************************************************************************/	
    public WebElement LogInButton()
	
		{
			return driver.findElement(login);
		}
    /****************************************************************************************************/	
    public WebElement LogOutButton()
	
		{
			return driver.findElement(logout);
		}
    /**
     * @return 
     * @throws InterruptedException 
     * @throws IOException **************************************************************************************************/	
    public void LogIn() throws InterruptedException, IOException
    {
     /*	Inputid().sendKeys(userId);
       	InputPassword().sendKeys(userPassword);
    	LogInButton().click();
    	*/
    	writeText(Inputid(),userId);
    	writeText(InputPassword(),userPassword);
    	click(LogInButton());
    	
       //	Thread.sleep(3000);
       	//validateClick(login,"submit");
    	//return new DescriptionPage(); 
    	
    }
	
	
	
	
	
}
