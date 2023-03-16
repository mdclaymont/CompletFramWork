package CrigList;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Common.BaseClass;
import Utilities.TestListeners;
@Listeners(TestListeners.class)
public class tf extends BaseClass {
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		System.out.println("Test");
	}
	@Test()
	public void PostData() {
		System.out.println("tEST Result");
	}
	
	
	@AfterMethod
	public void afterMethod() {
	System.out.println("After Method");
	}
	
}
