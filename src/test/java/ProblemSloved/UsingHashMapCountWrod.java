package ProblemSloved;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class UsingHashMapCountWrod {

	public static void main(String[] args) {
		String str="This is Automation inteview inteview";
		countWord(str);
	}
	public static void countWord(String expString) {
		String[] st=expString.split(" ");
		HashMap<String,Integer> result=new HashMap<String,Integer>();
		for(String word:st) {
			if(result.containsKey(word)) {
				result.put(word,result.get(word)+1);
			}
			else {
				result.put(word,1);
			}
		}
		Set<String> wordInString=result.keySet();
		for(String word:wordInString) {
		System.out.println(word +" : " +result.get(word));
		}
	}
}
