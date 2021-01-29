package ProblemSloved;

import java.util.Scanner;

public class PalindromeString {

	public static void main(String[] args) {
		String num ="", expStr;
		System.out.println("For exit Please Enter 'No'");
		System.out.println("Please Enter Your String : \n");
		Scanner sc = new Scanner(System.in);
		do {
			expStr = sc.next();
			palindromeString(expStr);
		} while (!expStr.toLowerCase().equals("no"));
		sc.close();
	}

	public static void palindromeString(String expStr) {
		StringBuffer sb = new StringBuffer(expStr);
		String res = sb.reverse().toString();
		System.out.println(res);
		System.out.println(expStr);
		if (res.equalsIgnoreCase(expStr)) {
			System.out.println("Expected String " + expStr + " is Palindrome");
		} else {
			System.out.println("Expected String " + expStr + " Is Not Palindrome Number");
		}

	}
	public static void palindromeString1(String expStr) {
		String res="";
		for(int i=0;i<expStr.length();i++) {
			res=res+expStr.charAt(expStr.length()-i);
		}

		System.out.println(res);
		System.out.println(expStr);
		if (res.equalsIgnoreCase(expStr)) {
			System.out.println("Expected String " + expStr + " is Palindrome");
		} else {
			System.out.println("Expected String " + expStr + " Is Not Palindrome Number");
		}

	}

}
