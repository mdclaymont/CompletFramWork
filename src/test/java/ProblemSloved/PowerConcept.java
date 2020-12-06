package ProblemSloved;

import java.util.Scanner;

public class PowerConcept {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String expType;
		do {
			System.out.println("Please Enter Your Base: ");
			int base = sc.nextInt();
			System.out.println("Please enter Your Exponent ");
			int exponent = sc.nextInt();
			long result = 1;
			while (exponent != 0) {
				result *= base;
				--exponent;
			}
			System.out.println("Exptet Result Is " + result);
			result = 0;
			System.out.println("To Continue press any char and Enter to Exit Enter 'No'");
			expType = sc.next();
		} while (!expType.toLowerCase().contains("no"));
		sc.close();
	}
}