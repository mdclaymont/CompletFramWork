package ProblemSloved;

import java.util.Scanner;

public class PrimeNumber {

	public static void main(String[] args) {
		String exp=null;
		do {
			Scanner sc=new Scanner(System.in);
			System.out.println("Please Enter You Number \n");
			int n=sc.nextInt();
			for(int j=1;j<=n;j++) {
				boolean flag=false;
				for(int i=2;i<=j/2;i++) {
					if(j%i==0) {
						flag=true;
						break;
					}
				}
				if(!flag) {
					System.out.print(j+" ");
				}
			}

			System.out.println("\n For Exit Enter No Or Press Any Character For Continue");
			exp=sc.next();
		}while(!exp.toLowerCase().contains("no"));
	}

}
