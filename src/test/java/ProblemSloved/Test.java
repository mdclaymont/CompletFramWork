package ProblemSloved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		String expNum[]= {"12","34","32","32","12"};
		List<String> te=new ArrayList<String>();
		te.add("Orange");
		te.add("Apple");
		te.add("Apple");
		te.add("Apple");
		te.add("Apple");
		System.out.println(te);
		LinkedHashSet<String> li =new LinkedHashSet<String>(te) ;
		System.out.println(li);
		
		for(int i=0;i<expNum.length;i++) {
			int count=0;
			for(int j=0;j<i+1;j++) {
				if(expNum[i].equals(expNum[j])) {
					count++;
					expNum[i
					       
					       expNumexpNumexpNum]="0";
				}
			}
			if(count>1 && expNum[i]!="0") {
				System.out.println("Total duplicat Value"+count +"Worrd Is "+ expNum[i]);
			}
		
		}
		
		
		
		
	//	removeDuplicatNumber(expNum);
	}

	public static void removeDuplicatNumber(Integer []expNum) {
		String temp ="";
		List<Integer> num=new ArrayList<Integer>(Arrays.asList(expNum));
		
		for(int i=0;i<num.size();i++) {
			for(int j=i+1;j<num.size();j++) {
				if(num.get(i)==num.get(j)) {
					num.remove(i);
				}
			}
				
		}
		System.out.println(num);
	
		}
		
}
