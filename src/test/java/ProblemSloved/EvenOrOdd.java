package ProblemSloved;

import java.util.Scanner;

import org.openqa.selenium.Keys;

public class EvenOrOdd {

	public static void main(String[] args) {
		String chose;
		System.out.println("Please Enter Number:=>");
		Scanner reader=new Scanner(System.in);
		do {
			int expNumber=reader.nextInt();
			int result=expNumber%2;
			if(result==0) {
				System.out.println("Exp Number is even");
			}
			else {
				System.out.println("Exp Number is Odd");
			}
			System.out.println("For exit Enter Y");
			chose=reader.next();
		}
			while(!chose.toLowerCase().contains("y"));
	}

}
