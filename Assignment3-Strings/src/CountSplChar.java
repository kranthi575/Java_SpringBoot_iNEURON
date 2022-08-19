import java.util.*;

public class CountSplChar {
	
		public static void main(String[] args) {

			Scanner sc=new Scanner(System.in);
			System.out.println("Program to count Special Characters in given String:\n");
			System.out.println("Enter the String : ");
			String str=sc.nextLine();
			
			
			int spl=0;
			
			for(int i=0;i<str.length();i++) {
				
				char ch=str.charAt(i);
				
				
				if(!(ch>='A'&&ch<='Z' || ch>='a'&&ch<='z' || ch>='0'&&ch<='9')) {
					
					System.out.println(ch);
					spl++;
				}
				
			}
			System.out.println("Special characters : "+spl);
			
		}

	}




