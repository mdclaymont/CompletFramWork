package ProblemSloved;

import java.util.Scanner;

public class Fabboni {

	public static void main(String[] args) {
		int num = 0;
		System.out.println("For Exit After Expected Number Please enter '-121' \n");
		System.out.println("Please Enter Your Number \n");
		Scanner sc = new Scanner(System.in);
		do {
			num = sc.nextInt();
			fibonacci(num);

		} while (num != -121);
		sc.close();
	}

	public static void fibonacci(int expNum) {
		int a = 0;
		int b = 1, res = 0;
		for (int i = 1; i <= expNum; i++) {
			System.out.print(res + " ");
			res = a + b;
			a = b;
			b = res;
		}
	}

}
