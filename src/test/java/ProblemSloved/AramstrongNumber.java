package ProblemSloved;

import java.util.Scanner;

public class AramstrongNumber {

	public static void main(String[] args) {
		String expType;
		Scanner sc=new Scanner(System.in);
		do {
			System.out.println("Please enter Your Number ");
			int expNum=sc.nextInt();
			int actualNum=expNum;
			double result=0;
			while(actualNum!=0) {
				int n=expNum%10;
				result=result+Math.pow(n,3);
				actualNum=actualNum/10;
			}
			if(result==expNum) {
				System.out.println(expNum+" is Aramstrong Number");
			}
			else {
				System.out.println(expNum+"is Not Aramstrong Number");
			}
			result=0;
			System.out.println("To Continue press any char and Enter To exit Enter 'No' ");
			expType=sc.next();
		}while(!expType.toLowerCase().contains("no"));
		
		
		
		sc.close();
	}

	private static double Math(int n, int i) {
		// TODO Auto-generated method stub
		return 0;
	}

}
