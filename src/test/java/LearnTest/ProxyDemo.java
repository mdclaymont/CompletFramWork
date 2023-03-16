package LearnTest;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ProxyDemo {

	public static void main(String[] args) {
		Proxy proxy=new Proxy();
		proxy.setAutodetect(false);
		proxy.setHttpProxy("localhost:8080");
		proxy.setSslProxy("localhost:8080");
		ChromeOptions op=new ChromeOptions();
		op.setCapability("proxy",proxy);
		WebDriver driver=new ChromeDriver(op);
		driver.get("https://delaware.craigslist.org/");
	}

}
