import java.util.Scanner;
public class AnagramOrNot2 {

	
	public static void main(String args[]) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter String1:");
		StringBuilder str1=new StringBuilder(sc.nextLine());
		System.out.println("Enter String2: ");
		StringBuilder str2=new StringBuilder(sc.nextLine());
		StringBuilder str3=new StringBuilder("");
		for(int i=str1.length()-1;i>=0;i--) {
			str3.append("*");
			for(int j=str2.length()-1;j>=0;j--) {
				
				if(str1.charAt(i)==str2.charAt(j)) {
					str2.deleteCharAt(j);
					str1.deleteCharAt(i);
					break;
				}
				
			}
			
			
		}
		
		if(str2.isEmpty() && str1.isEmpty()) {
			System.out.println("Anagram");
		}
		else
			System.out.println("Not anagram");
		
	}
}
