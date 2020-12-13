package Guru;
import java.io.IOException;

import org.testng.annotations.Test;
import Common.BaseClass;
import PageObject.LogInPage;

public class TC_001_LogInTest extends BaseClass{
	
	public static LogInPage lip;
	@Test
	public void loginTest() throws IOException, InterruptedException
	{
		log.info("test info");
		log.error("test error message");
		log.warn("test warning");
		log.debug("debug");
		log.fatal("test fatal");
		///openUrl("");
		//validateUrl();
		//LogInPage lip=new LogInPage(driver);
		//lip.LogIn();
		//validateTitle("Guru99 Bank Manager HomePage");
	}
}
