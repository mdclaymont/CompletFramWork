package ProblemSloved;

public class CheckAlphabet {

	public static void main(String[] args) {
		char expChar='p';
		if((expChar>='a' && expChar<='z')||(expChar>='A' && expChar<='Z')) {
			System.out.println("Exptected Character is alphabet");
		}
		else {
			System.out.println("Exptected Character is not alphabet");
		}
	}

}
