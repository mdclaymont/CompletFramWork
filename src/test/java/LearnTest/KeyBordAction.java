package LearnTest;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;

import Common.BaseClass;

public class KeyBordAction extends BaseClass {

	public static void main(String[] args) throws IOException {
		initilizeDriver("");
		driver.get("https://delaware.craigslist.org/");

	}

}
