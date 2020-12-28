package CrigList;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Common.BaseClass;

public class PostList extends BaseClass {
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		initilizeDriver();
		openUrl("");
		click(lp.myAccount());
		lip.LogIn();
	}
	@Test
	public void Testc() {
	System.out.println("Test");
	//TestListener.test.log(Status.FAIL,"Exptest Test Pass Failed");	
	}
	@AfterMethod
	public void afterMethod() {
		closeBrowser("");
	}
	
}
