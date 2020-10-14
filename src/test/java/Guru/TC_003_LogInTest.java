package Guru;
import java.io.IOException;

import org.testng.annotations.Test;
import Common.BaseClass;
import PageObject.LogInPage;

public class TC_003_LogInTest extends BaseClass{
	
	public static LogInPage lip;
	@Test
	public void loginTest() throws IOException, InterruptedException
	{
		openUrl("");
		validateUrl();
		LogInPage lip=new LogInPage(driver);
		lip.LogIn();
		validateTitle("Guru99 Bank Manager HomePage");
	}
}
