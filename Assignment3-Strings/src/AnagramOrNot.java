import java.util.*;
public class AnagramOrNot {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter string1 : ");
		String str1=sc.nextLine();
		StringBuilder sb1=new StringBuilder(str1);
		
		System.out.println("Enter String2 : ");
		String str2=sc.nextLine();
		StringBuilder sb2=new StringBuilder(str2);
		
		char ch1[]=str1.toCharArray();
		char ch2[]=str2.toCharArray();
		
		String temp="";
		
		for(int i=ch1.length-1;i>=0;i--) {
			temp=temp+"*";
			int j;
			boolean flag=false;
			for(j=ch2.length-1;j>=0;j--) {
			
				if(ch1[i]==ch2[j]) {
					
					flag=true;
					ch2[j]='*';
					System.out.println(ch1);
					System.out.println(ch2);
					break;
				}
				
			}
			
			
		}
		String st=new String(ch2);
	
		if(st.equals(temp))
		System.out.println("Given Strings are Anagram");
		else
		System.out.println("Given strings are not anagram");
		
		
	}

}
