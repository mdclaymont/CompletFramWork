package ProblemSloved;

import java.util.Scanner;

public class Fabboni {

	public static void main(String[] args) {
		Scanner obSc=new Scanner(System.in);
		System.out.println("Please Enter Number Range:=");
		int num=obSc.nextInt();
		int t1=0;
		int t2=1;
		for(int i=1;i<=num;i++) {
			System.out.print(t1+" ");
			int sum=t1+t2;
			t1=t2;
			t2=sum;
		}
		obSc.close();
	}

}
