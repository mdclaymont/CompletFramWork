package CrigList;

import java.io.IOException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Common.BaseClass;

public class PostList extends BaseClass {
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		getData("CrigList,4");
		initilizeDriver();
		openUrl("");
		click(lp.myAccount());
		lip.LogIn();
	}
	@Test
	public void Post() {
		click(acp.Go());
		click(acp.SellBy());
		click(acp.SellCatagory());
		writeText(dp.postingTitle(),TcData.get(0).get("Title"));
		writeText(dp.description(),TcData.get(0).get("Description"));
		writeText(dp.price(),TcData.get(0).get("Price"));
		writeText(dp.postalCode(),TcData.get(0).get("PostalCode"));
		click(dp.mobileOsClick());
		setObjectByText("apple iOS",dp.mobileOs());
		click(cf.Continue());
		click(cf.Continue());
		click(dp.doneImage());
		click(cf.Publish());
	}
	@AfterMethod
	public void afterMethod() {
		closeBrowser("");
	}
	
}
