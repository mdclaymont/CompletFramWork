package Guru;

import Common.BaseClass;

public class Tf extends BaseClass {

	public static void main(String[] args){
		
		//primeNumber(100);
		//palindrom(789);
		findDuplicateWord("this is my test  count word this count word is worrk");
		
	}	
	public static void countWord(String expString) {
		int count;
		String str[]=expString.split(" ");
		for(int i=0;i<str.length;i++) {
			count=1;
			for(int j=i+1;j<str.length;j++) {
				if(str[i].equals(str[j])) {
					count++;
					str[j]="0";	
				}
			}
			if(count>1 && str[i]!="0") {
				System.out.println(str[i]+"\t"+count);
			}
		}
	}
	
}