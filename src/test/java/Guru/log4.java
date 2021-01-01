package Guru;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import Common.BaseClass;
import Utilities.XLUtility;

public class log4 extends BaseClass {

	public static void main(String[] args) throws IOException {
		List<LinkedHashMap<String, String>>	a=XLUtility.getTcData("","Detailpage","CrigList,4");
		System.out.println(a.get(0).get("Title"));

	}

}
