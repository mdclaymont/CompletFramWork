package ProblemSloved;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ShortNumberUsingLinkList {

	public static void main(String[] args) {
		List<Integer> li=new LinkedList<Integer>();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Total Array you Add");
		int n=sc.nextInt();
		for(int i=0;i<n;i++) {
			int nu=sc.nextInt();
			li.add(nu);
		}
		
		System.out.println(li);
		for(int i=0;i<li.size();i++) {
			System.out.print(li.get(i));
		}

	}

}
