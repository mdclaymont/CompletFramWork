package ProblemSloved;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ShortNumberList {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Number ");
		int n=sc.nextInt();
		System.out.println("Please Enter Your Total Number You Want Short  =>" +n +"\n");
		List<Integer> ar=new ArrayList<Integer>();
		for(int i=0;i<n;i++) {
			int a=sc.nextInt();
			ar.add(a);
		}
		System.out.println("Finish Enter Number");

		ar.sort(Comparator.naturalOrder());
		for(int i=0;i<ar.size();i++) {
			int c=1;
			if(i!=ar.size()-1) {
				for(int j=i+1;j<ar.size();j++) {
					if(ar.get(i)==ar.get(j)) 
						c++;
					else	
						break;	
				}
			}
			System.out.println(ar.get(i)+" -> "+c);
			i+=c-1;
		}


	}

}
