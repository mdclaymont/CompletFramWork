package ProblemSloved;

public class CheckPositiveNagative {

	public static void main(String[] args) {
	
		checkNumber(0);
	}
	
	public static void checkNumber(double expNumber) {
		if(expNumber>0.0) {
			System.out.println("Expected Number Is "+expNumber+" Positive");
		}
		else if(expNumber<0.0) {
			System.out.println("Expected Number Is "+expNumber+" Nagative ");
		}
		else {
			System.out.println("Expected Number Is Zero");
		}
	}

}
