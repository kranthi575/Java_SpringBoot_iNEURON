import java.util.*;
public class ReverseSentence {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		System.out.println("Please enter the Sentence : ");
		String sen1=sc.nextLine();
		String revsen="";
		
		String splitsen[]=sen1.split(" ");
		
		for(int i=0;i<splitsen.length;i++) {
			
			String str=splitsen[i];
			for(int j=str.length()-1;j>=0;j--) {
				revsen=revsen+str.charAt(j);
				
			}
			revsen=revsen+" ";
		}
		System.out.println("The reversed Sentence  with prserving positions:\n"+revsen);
	}

}
