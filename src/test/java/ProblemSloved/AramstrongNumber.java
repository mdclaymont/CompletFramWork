package ProblemSloved;

import java.util.Scanner;

public class AramstrongNumber {

	public static void main(String[] args) {
		long expNum = 0;
		System.out.println("For exist Please Enter '-99'");
		System.out.println("Please Enter Your Number For Check If Its Amstrong Number:\n");
		Scanner sc = new Scanner(System.in);
		do {
			expNum = sc.nextLong();
			amstringNumber(expNum);

		} while (expNum != -99);
		sc.close();
	}

	public static void amstringNumber(long expNum) {
		long temp = expNum;
		double result = 0;
		while (expNum != 0) {
			long n = expNum % 10;
			result = result + Math.pow(n, 3);
			expNum = expNum / 10;
		}
		if (temp == result) {
			System.out.println("Expected Number Is amstrong Number '" + temp);
		} else {
			System.out.println("Expected Number Ins Not an amstrong Number " + temp);
		}
	}
}