package TestNgProblemSlove;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import Common.BaseClass;
import Utilities.TestListeners;
@Listeners(TestListeners.class)
public class DescriptionAnotation extends BaseClass {
	@BeforeTest
	//@Parameters("browserName")
	public void setUp() throws IOException {
		System.out.println("SetUp");
		//getData("CrigList,4");
		System.out.println(browserName);
		//initilizeDriver("");
		//openUrl("");
	}
	@Test(description="This Is Test For Description")
	
	public void Description() {
	
	//	softAssert().assertEquals(false,true);
		System.out.println("This Is Description Method");
	}
	
	@Test(description="This Is Parameter Test")
	@Parameters({"browser","Url"})
	public void Parameter(String browser,String Url) {
		System.out.println(browser);
		System.out.println(Url);
		System.out.println("postIphone(");
		//TestListener.test.log(Status.FAIL,"Exptest Test Pass Failed");	
	}
	@Test(groups= {"Save"})
	public void Testc1() {
		System.out.println("Test1");
		softAssert().assertEquals(false,true);
	}
	
	@Test
	public void postIphone1() {
		System.out.println("postIphone1(");
		//TestListener.test.log(Status.FAIL,"Exptest Test Pass Failed");	
	}
	@AfterTest
	public void tearDown() {
		System.out.println("tear");
		softAssert().assertAll("All Result");
	}

}
