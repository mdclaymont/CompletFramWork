package ProblemSloved;

import java.util.Scanner;

public class PalindromNumber {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String expType;
		do {
			int rev=0;
			System.out.println("Enter Your Check Number: ");
			int expNum=sc.nextInt();
			int actualNum=expNum;
			while(expNum!=0) {
				int n=expNum%10;
				rev=rev*10+n;
				expNum=expNum/10;
			}
			if(actualNum==rev) {
				System.out.println("Expeted Number is Palindrom Number");
			}
			else {
				System.out.println("Expected Number Is not Palindrom Number");
			}
			rev=0;
			System.out.println("To Exit enter 'No' or Press any Char and Enter To Continue");
			expType=sc.next();
			
		}while(!expType.toLowerCase().contains("no"));
		sc.close();
	}
}
