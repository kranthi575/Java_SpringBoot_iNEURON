import java.util.*;
public class Pangram {

	public static void main(String[] args) {
		
		String str1="abcdefghijklmnopqrstuvwxyz";
		StringBuilder sb=new StringBuilder(str1);
		StringBuilder sb3=new StringBuilder(str1);

		Scanner sc=new Scanner(System.in);
		String str2=sc.nextLine();
		//String str2=" Go, lazy fat vixen; be shrewd, jump quick.";
		str2=str2.toLowerCase();
		StringBuilder sb2=new StringBuilder(str2);
		
		for(int i=sb.length()-1;i>=0;i--) {
			
			for(int j=sb2.length()-1;j>=0;j--) {
				
				if(sb.charAt(i)==sb2.charAt(j)) {
					sb.deleteCharAt(i);
					break;
				}
			}
		}
		System.out.println(sb);
		if(sb.isEmpty())
		System.out.println("Pangram");
		else
			System.out.println("Not Pangram");
		
	
		
		

	}

}
