package Guru;

import java.io.IOException;
import java.util.ArrayList;
import Common.BaseClass;
import Utilities.XLUtility;

public class log4 extends BaseClass {

	public static void main(String[] args) throws IOException {
		Object[][]testData=XLUtility.getDataForDataProvider("","Crig","");
		System.out.println(testData[0][1]);

	}

}
