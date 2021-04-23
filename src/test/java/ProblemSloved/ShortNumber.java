package ProblemSloved;

public class ShortNumber {

	public static void main(String[] args) {
	//	int expNum[]= {4,5,1,2,1,4,2,8,9,22,14};
		int expNum[]= {8,4};
		shortNumber(expNum);
	}

	public static void shortNumber(int expNum[]) {
		if(expNum.length<2) {
			System.out.println("User Provied Only One Number " + expNum[0]);
		}
		else {
			for(int i=0;i<expNum.length;i++) {
				int tem;
				for(int j=i+1;j<expNum.length;j++) {
					if(expNum[i]>expNum[j]) {
						tem=expNum[j];
						expNum[j]=expNum[i];
						expNum[i]=tem;
					}
				}
				
			}
			System.out.println("Shorted Number Is");
			for(int i=0;i<expNum.length;i++) {
				System.out.print(expNum[i]+" ");
			}
		}
	
		
		
	}
	
}
