package ProblemSloved;

import java.util.Scanner;

public class NumberOfDigit {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String type;
		do {
			System.out.println("Please Enter Your Number ");
			long num=sc.nextLong();
			int count=0;
			while(num!=0) {
				num=num/10;
				++count;
			}
			System.out.println("Total Number "+count);
			System.out.println("To Continue Press Any Char And Enter To Exit Please Enter 'No'");
			type=sc.next();
		}while(!type.toLowerCase().contains("no"));
			sc.close();
	}
}
