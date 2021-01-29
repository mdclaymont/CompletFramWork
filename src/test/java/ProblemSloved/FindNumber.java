package ProblemSloved;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FindNumber {

	public static void main(String[] args) {
		List<Double>expNum=new ArrayList<Double>();
		double num=0;
		System.out.println("For Exit Please Enter '-121'\n");
		System.out.println("\t Please Enter Exp Number: \n");
		Scanner sc=new Scanner(System.in);
		do {
			num=sc.nextDouble();
			if(num!=-121) {
				expNum.add(num);
			}
			
		}while(num!=-121);
		sc.close();
		System.out.println(expNum);
		sortNumber(expNum);
	}
	public static void sortNumber(List<Double> expNum) {
		Collections.sort(expNum);
		System.out.println(expNum);
		System.out.println(expNum.get(0));
		System.out.println(expNum.get(expNum.size()-1));
	}
	
	public static void highestNumber(List<Double> expNum) {
		Collections.sort(expNum);
		System.out.println(expNum.get(expNum.size()-1));
	}
	public static void LowsestNumber(List<Double> expNum) {
		Collections.sort(expNum);
		System.out.println(expNum.get(0));
	}
	
}
