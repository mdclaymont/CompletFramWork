package ProblemSloved;

import java.util.Scanner;

public class FabinoSeris {

	public static void main(String[] args) {
		int a=0,b=0,c=1,n=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Please Enter Your Number \n");
		n=sc.nextInt();
		for(int i=0;i<=n;i++) {
			a=b;
			b=c;
			c=a+b;
			System.out.print(a+" ");
		}


	}

}
