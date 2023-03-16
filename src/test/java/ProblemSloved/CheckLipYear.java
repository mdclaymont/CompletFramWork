package ProblemSloved;

public class CheckLipYear {

	public static void main(String[] args) {
		System.out.println(findlipYear(2001));
	}
	
	public static boolean findlipYear(int expYear) {
		boolean res = true;
		if(expYear%4==0) {
			if(expYear%100==0) {
				if(expYear%400==0) {
					res=true;
				}
				else {
					 res=false;
				}
			}
			else {
				res=true;
			}
			
		}else {
			res=false;
		}
		return res;
	}

}
