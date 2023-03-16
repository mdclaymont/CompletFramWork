package Test;

import java.io.IOException;
import Common.BaseClass;

public class Tf extends BaseClass {
	public static void main(String[] args) throws IOException {
		//System.out.println(bc.EXPLICIT_TIME_OUT);
		initilizeDriver("chrom");
		openUrl("");
		click(lp.myAccount());
		writeText(lip.Inputid(),"iphonepnt@gmail.com");
		writeText(lip.InputPassword(),"Tester@7453");
	}

}
