package ProblemSloved;

public class countDuplicateCharacter {

	public static void main(String[] args) {
		String str="Test Result";
		countChar(str);

	}
	
	public static void countChar(String expStr) {
		int clength=expStr.length();
		char cstr[]=expStr.toCharArray();
		if(expStr.isEmpty() || expStr.isBlank()) {
			System.out.println("You String Is empty Or Blank");
		}
		else if(clength==1) {
			System.out.println("You String Is Only One Character");
		}
		else {
			for(int i=0;i<clength;i++) {
				int count =1;
				for(int j=i+1;j<clength;j++) {
					if(cstr[i]==cstr[j] & cstr[i]!=' ') {
						count++;
						cstr[j]='0';
					}
				}
				if(count>1 & cstr[i]!='0') {
					System.out.println(cstr[i]+" This Character Number of Occarance Is "+count);
				}
			}
		}
	}

}
