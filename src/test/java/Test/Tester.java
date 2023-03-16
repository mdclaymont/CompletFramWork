package Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Tester {

	public static void main(String[] args) {

		List<Integer> it=new ArrayList<Integer>();
		it.add(10);
		it.add(20);
		it.add(30);
		it.add(40);
		it.add(20);
		it.add(30);
		it.add(30);
		int d = 0;
		int c=1;
		it.sort(Comparator.naturalOrder());
		System.out.println(it);
		for(int i=0;i<it.size();i++) {
			for(int j=i+1;j<it.size();j++) {
						int a=it.get(i);
						int b=it.get(j);
						if(a==b) {
							c++;
							d=a;
						}
					}
			}
		if(c>1) {
			System.out.println(d+"Total Count "+ c);
		}

	}

}
