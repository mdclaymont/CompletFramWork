package ProblemSloved;

import java.util.Arrays;
import java.util.LinkedHashSet;

public class GetUniqueValueFromGiven {

	public static void main(String[] args) {
		Object expArray[]={4689,7,8,9,9,7,6};
		getFromArray(expArray) ;

	}
	public static void getFromArray(Object expArray[]) {
		LinkedHashSet<Object> lh=new LinkedHashSet<Object>(Arrays.asList(expArray));
		Object result[] =new Object[ lh.size()];
		Object te=lh.toArray(result);
	
		System.out.println(te);
		
		
	}

}
