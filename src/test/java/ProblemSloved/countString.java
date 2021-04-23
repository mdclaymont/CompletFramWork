package ProblemSloved;

public class countString {

	public static void main(String[] args) {
	String str="4 45 6 12 12 3 6 63 63"
			+ "generated method stub"
			+ "";
	String exp[]=str.split(" ");
	countDuplicateString(exp);

	}
	public static void countDuplicateString(String expString[]) {
		for(int i=0;i<expString.length;i++) {
			int count=1;
			for(int j=i+1;j<expString.length;j++) {
				if(expString[i].equals(expString[j])) {
					count++;
					expString[j]="0";
				}
			}
			if(count>1 & expString[i]!="0") {
				System.out.println("' "+expString[i]+" ==> ' Total Occarance Is ==> "+count);
			}
			
		}
		
	}

}
