package PageObject;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Common.BaseClass;

public class LogInPage1 extends BaseClass {
	WebDriver ldriver;
	public LogInPage1(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath="//*[@name='inputEmailHandle']") WebElement inputid ;
	@FindBy(xpath="//*[@name='inputPassword']" ) WebElement UiPassword  ;
	@FindBy(xpath= "//*[@name='login']") WebElement login   ;
	@FindBy(xpath= "//a[text()='Log out']") WebElement logout   ;
	
	/****************************************************************************************************/	
	public WebElement Inputid()
		{
			return inputid;
		}
	/****************************************************************************************************/	
	public WebElement InputPassword()
	
		{
			return UiPassword;
		}
	/****************************************************************************************************/	
    public WebElement LogInButton()
	
		{
			return login;
		}
    /****************************************************************************************************/	
    public WebElement LogOutButton()
	
		{
			return logout;
		}
    /**
     * @return 
     * @throws InterruptedException 
     * @throws IOException **************************************************************************************************/	
    public void LogIn() throws InterruptedException, IOException
    {
    	writeText(Inputid(),userId);
    	writeText(InputPassword(),userPassword);
       	click(LogInButton());
       	Thread.sleep(3000);
       	validateClick(login,"submit");
    	//return new DescriptionPage(); 
    	
    }
	
	
}
