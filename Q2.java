import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Q2 {

	public static final int nIter = 5;
	
	public static void main(String[] args) {
		
		Q2 q2 = new Q2();

		Scanner scan = new Scanner(System.in);
		
		char[] letterArray = {'A','G','C','T'};
		

		for (int i = 0; i<nIter; i++) {
		   
			String line = scan.nextLine();
			String[] inValues = line.split(" ");
			
			
			// only needs two characters
			if (inValues.length != 2 ) {
				System.exit(0);
			}
			
		
			// only considering strings with "A","T","G","C"
			if (inValues[0].matches("[ATGC]+")) {

			}else {
				System.exit(0);
			}
			
			if (inValues[1].matches("[ATGC]+")) {

			}else {
				System.exit(0);
			}

			
			
			// length of string is between 2 and 100
			if (inValues[0].length()<2 || inValues[0].length()>100) {
				System.exit(0);
			}
			
			if (inValues[1].length()<2 || inValues[1].length()>100) {
				System.exit(0);
			}
	
			// find the substring from a string
			int type1 = q2.findSub(inValues[0],inValues[1]);
			
			
			// delete one character
			Set<String> type2 = new HashSet<String>();
			char[] charArray = inValues[0].toCharArray();
			
			
			for (int j=0; j < charArray.length; j++) {
				StringBuilder sb = new StringBuilder(inValues[0]);
			    sb.deleteCharAt(j);
			    type2.add(sb.toString());
			}
			
			int sum2 = 0;
			for (String s : type2) {
			    int temp = q2.findSub(s,inValues[1]);
			    sum2 = sum2 + temp;
			}
	
			
		
			// add one character
			Set<String> type3 = new HashSet<String>();
			
			for (int j=0; j < charArray.length+1; j++) {
				for (int jj = 0; jj<letterArray.length;jj++) {
					StringBuilder sb = new StringBuilder(inValues[0]);
					sb.insert(j,letterArray[jj]);
					type3.add(sb.toString());
				}
			}
			
			int sum3 = 0;
			for (String s : type3) {
			    int temp = q2.findSub(s,inValues[1]);
			    sum3 = sum3 + temp;
			}
			
			// print the final result
			System.out.println(""+type1+" "+sum2+" "+sum3);
		}

	
	}

	// function which returns the number of repeated subS in origS
	public int findSub(String subS, String origS) {
		int lastIndex = 0;
		int count = 0;
		while (lastIndex != -1) {
		    lastIndex = origS.indexOf(subS, lastIndex);
		    if (lastIndex != -1) {
		        lastIndex++;
		        count++;
		    }
		}
		return (count);
	}

	
	
}