package ProblemSloved;

public class CovertNumber {

	public static void main(String[] args) {
		binaryToDecimal(10011011);

	}
	
	public static void binaryToDecimal(long expNum) {
		double decimal=0,i=0;
		while(expNum!=0) {
			long r=expNum%10;
			expNum=expNum/10;
			decimal=decimal+r*Math.pow(2,i);
			++i;
		}
		System.out.println(decimal);
	
		
		
	}

}
