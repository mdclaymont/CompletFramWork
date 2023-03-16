package ProblemSloved;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {
		List<Integer> ar=new ArrayList<Integer>();
		ar.add(15);
		ar.add(26);
		//Print Different way
		//System.out.println(ar);
		
		//System.out.println("\n");
		ar.remove(1);
	//	System.out.println(ar);
		ar.add(151);
		ar.add(261);
		ar.add(15);
		ar.add(26);
		//System.out.print("\n");
		Collections.sort(ar);
		System.out.print(ar);
		
		
	}

}
