package ProblemSloved;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScanInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void input() {
		List<Double> expNum=new ArrayList<Double>(); 
		double num = 0;
		Scanner sc=new Scanner(System.in);
		System.out.println("For Exit Please Enter '-121'\n");
		System.out.println("\t Please Enter Your Expected Number:\n");
		do {
			num=sc.nextDouble();
			if(num!=-121) {
				expNum.add(num);
			}
		}while(num!=-121);
		System.out.println(expNum);
	}

	

}
