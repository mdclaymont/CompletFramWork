package ProblemSloved;

import java.util.Scanner;

public class ReveraseNum {
	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	String expType;
	long rev=0;
	do {
		System.out.println("Enter Your Number => ");
		long expNum=sc.nextLong();
		while(expNum!=0) {
			long n=expNum%10;
			rev=rev*10+n;
			expNum=expNum/10;
		}
		System.out.println("Reverse Number Is => "+rev);
		System.out.println("To Continue Press Any Char and Enter To Exit Enter 'No'");
		expType=sc.next();
		rev=0;
	}while(!expType.toLowerCase().contains("no"));
	sc.close();
	}
}
