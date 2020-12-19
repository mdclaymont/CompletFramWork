package Test;

import Common.BaseClass;
import Utilities.ReadConfig;

public class Tf extends BaseClass {

	public static void main(String[] args) {
		
	System.out.println(ReadConfig.appProperties.getProperty("UserPassword"));

	}

}
