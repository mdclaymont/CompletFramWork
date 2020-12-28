package CrigList;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Common.BaseClass;

public class PostList extends BaseClass {
	@BeforeMethod
	public void beforMethod() {
//	TestListener.test.log(Status.PASS,"Exptest Test Pass");	
	System.out.println("befor Method");	
	}
	@Test
	public void Testc() {
	System.out.println("Test");
	//TestListener.test.log(Status.FAIL,"Exptest Test Pass Failed");	
	}
	
	@Test
	public void postIphone() {
	System.out.println("postIphone(");
	//TestListener.test.log(Status.FAIL,"Exptest Test Pass Failed");	
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("Test After Method");
	}
	
}
