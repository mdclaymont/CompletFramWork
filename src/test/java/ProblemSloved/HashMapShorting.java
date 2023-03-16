package ProblemSloved;

import java.util.HashMap;

public class HashMapShorting {

	public static void main(String[] args) {
		
		HashMap< Integer, String> hm=new HashMap<Integer,String>();
		hm.put(1,"Appale");
		hm.put(2,"Strabery");
		hm.put(3,"Orange");
		hm.put(4,"Appale");
		hm.put(5,"Strabery");
		hm.put(6,"Orange");
		System.out.println(hm);
		
		for(int i=1;i<=hm.size();i++) {
			System.out.println(hm.get(i));
		}

	}

}
