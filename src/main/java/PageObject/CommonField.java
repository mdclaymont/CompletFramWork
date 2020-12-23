package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.BaseClass;

public class CommonField extends BaseClass {
	public By year=By.xpath("");
	public By day=By.xpath("");
	public By allHeaderEle=By.xpath("");
	public By tableRowValueList=By.xpath("");
	public By rightArrow=By.xpath("");
	public List<WebElement> TableHeaderValue() {
		return driver.findElements(allHeaderEle);
	}
	public List<WebElement> TableRowValueList() {
		return driver.findElements(tableRowValueList);
	}
	public WebElement setYear() {
		return driver.findElement(year);
	}
	public List<WebElement> setDay() {
		return driver.findElements(day);
	}
	public WebElement RightArrow() {
		return driver.findElement(rightArrow);
	}
	
	
}
