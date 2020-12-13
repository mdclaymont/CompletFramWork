package Guru;

import org.testng.Reporter;
import org.testng.annotations.Test;

import Common.BaseClass;

public class logtestng extends BaseClass {
	
	
	@Test
	public void demo() {
		Reporter.log("Test Report");
		log.debug("Test Debug");
		log.error("Log eroor");
		log.fatal("Test Fatal");
	}

}
