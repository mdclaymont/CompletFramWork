package ProblemSloved;

import java.util.Scanner;

public class CheckPrime {

	public static void main(String[] args) {
		String expType;
		Scanner sc=new Scanner(System.in);
		
		do {
			System.out.println("Please enter Your Number For Check: ");
			int expNum=sc.nextInt();
			printPrime(expNum);
			System.out.println("To exit enter 'No' or press Any char and enter to Continue: ");
			expType=sc.next();
			
		}while(!expType.toLowerCase().contains("no"));
		sc.close();

	}
	public static boolean checkPrime(long expNum) {
		boolean ckprime=false;
		for(int i=2;i<=expNum/2;i++) {
			if((expNum%i==0)) {
				ckprime=true;
				break;
			}
		}
		return ckprime;
	}
	public static void printPrime(long expNum) {
		if(!checkPrime(expNum)) {
			System.out.println("Expeted Number Is Prime Number ");
		}
		else {
			System.out.println("Expeted Number Is Not Prime Number ");
		}
	}
	public static void prime(long expNum) {
		for(int i=2;i<=expNum;i++) {
			if(!checkPrime(i)) {
				System.out.print(i +" ");
			}
		}
	}

}
