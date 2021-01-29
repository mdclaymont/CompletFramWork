package ProblemSloved;

import java.util.Scanner;

public class PalindromNumber {

	public static void main(String[] args) {
		long num = 0, expNum;
		System.out.println("For exit Please Enter -99");
		System.out.println("Please Enter Your Number: \n");
		Scanner sc = new Scanner(System.in);
		do {
			expNum = sc.nextLong();
			palindromeNumber(expNum);
		} while (num != -99);
		sc.close();
	}

	public static void palindromeNumber(long expNum) {
		long temp, res = 0;
		temp = expNum;

		while (expNum != 0) {
			long n = expNum % 10;
			res = res * 10 + n;
			expNum = expNum / 10;
		}
		if (res == temp) {
			System.out.println("Expected Number " + temp + " is Palindrome");
		} else {
			System.out.println("Expected Number " + temp + " Is Not Palindrome Number");
		}

	}
}
