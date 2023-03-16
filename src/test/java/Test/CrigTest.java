package Test;

import java.io.IOException;

import Common.BaseClass;



public class CrigTest extends BaseClass {
	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		closeExpAppByExe("chrome.exe");
		initilizeDriver("");
		openUrl("");
		lp.myAccount().click();
		lip.LogIn();
		
	}

}
