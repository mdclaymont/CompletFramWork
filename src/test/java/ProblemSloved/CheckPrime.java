package ProblemSloved;

import java.util.Scanner;

public class CheckPrime {

	public static void main(String[] args) {
		String expType;
		Scanner sc=new Scanner(System.in);
		
		do {
			System.out.println("Please enter Your Number For Check: ");
			int expNum=sc.nextInt();
			if(checkPrime(expNum)) {
				System.out.println(expNum+" is Not Prime Number");
			}
			else {
				System.out.println(expNum+" Is prime Number");
			}
			
			System.out.println("To exit enter 'No' or press Any char and enter to Continue: ");
			expType=sc.next();
			
		}while(!expType.toLowerCase().contains("no"));
		sc.close();

	}
	public static boolean checkPrime(int expNum) {
		boolean flag=false;
		for(int i=2;i<=expNum/2;i++) {
			if(expNum%i==0) {
				flag=true;
				break;
			}
		}
		return flag;
	}
	

}
