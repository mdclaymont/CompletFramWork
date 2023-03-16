package Guru;
import java.io.IOException;

import org.testng.annotations.Test;
import Common.BaseClass;
import PageObject.LogInPage1;

public class TC_003_LogInTest extends BaseClass{
	
	public static LogInPage1 lip;
	@Test
	public void loginTest() throws IOException, InterruptedException
	{
		openUrl("");
		validateUrl();
		LogInPage1 lip=new LogInPage1(null);
		lip.LogIn();
		validateTitle("Guru99 Bank Manager HomePage");
	}
}
