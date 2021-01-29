package ProblemSloved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Integer expNum[]= {12,34,32,32,56,56,12};
		removeDuplicatNumber(expNum);
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
