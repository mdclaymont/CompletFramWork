package ProblemSloved;

import java.util.Scanner;

public class FactorialNumber {

	public static void main(String[] args) {
		long expNum = 0;
		System.out.println("For exist Please Enter '-99'");
		System.out.println("Please Enter Your Number For Factorial Number:\n");
		Scanner sc = new Scanner(System.in);
		do {
			expNum = sc.nextLong();
			factorialNumber(expNum);

		} while (expNum != -99);
		sc.close();
	}
	public static void factorialNumber(long expNum) {
		long result = 1;
		for (int i = 1; i <= expNum; i++) {
			result = result * i;
		}
		System.out.println("Expected Factorial Number: " + result);
	}
}