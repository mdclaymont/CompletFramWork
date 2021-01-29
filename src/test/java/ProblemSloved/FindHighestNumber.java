package ProblemSloved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.google.common.primitives.Ints;

public class FindHighestNumber {
	
	public static void main(String[] args) {
		int [] num= {90,1,430,23,34,56,5,9,89,2,800,900,9};
		findHighestNumber(num);
		findLowsetNumber(num);
		sortNumber1(num);
	}
	
	public static int findHighestNumber(int[] expNumber) {
		int largest=Integer.MIN_VALUE;
		for(int i=0;i<expNumber.length;i++) {
			if(largest<expNumber[i]) {
				largest=expNumber[i];
			}
		}
		return largest;
	}
	public static int findLowsetNumber(int[] expNumber) {
		int largest=Integer.MAX_VALUE;
		for(int i=0;i<expNumber.length;i++) {
			if(largest>expNumber[i]) {
				largest=expNumber[i];
			}
		}
		System.out.println("The Lowest Number Is : "+largest);
		return largest;
	}
	
	public static void sortNumber1(int[] expNumber) {
		Arrays.sort(expNumber);
		System.out.println(Arrays.toString(expNumber));
	}
	
	public static void sortNumber(int[] expNumber) {
		int temp;
		for(int i=0;i<expNumber.length;i++) {
			for(int j=i+1;j<expNumber.length;j++) {
				if(expNumber[i]>expNumber[j]) {
					temp=expNumber[i];
					expNumber[i]=expNumber[j];
					expNumber[j]=temp;
				}
			}
			
		}
		for(int i=0;i<expNumber.length;i++) {
		System.out.print(expNumber[i]+" ");
		}
	}
		
		
		
	

}
