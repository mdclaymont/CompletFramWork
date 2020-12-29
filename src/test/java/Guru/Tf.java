package Guru;

import java.io.IOException;

import Common.BaseClass;
import PageObject.LogInPage1;
import Utilities.TestListeners;

public class Tf extends BaseClass {

	public static void main(String[] args) throws IOException, InterruptedException{
		//TestListeners.onStart();
		initilizeDriver();
		System.out.println(appProperties.getProperty("GuruUrl"));
		openUrl(appProperties.getProperty("GuruUrl"));
		validateUrl();
		//LogInPage lip=new LogInPage(driver);
		//lip.LogIn();
		//validateTitle("Guru99 Bank Manager HomePage");
		//TestListeners.onFinish();
	}	
}