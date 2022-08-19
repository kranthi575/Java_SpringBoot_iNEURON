import java.util.*;

public class CountVowCons {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		
		String str=sc.nextLine();
		
		int vow=0;
		int cons=0;
		
		for(int i=0;i<str.length();i++) {
			
			char ch=str.charAt(i);
			if(ch>='A'&&ch<='Z' || ch>='a'&&ch<='z') {
			if(ch=='a'|| ch=='A'||ch=='e'||ch=='E'||ch=='i'||ch=='I'||ch=='o'||ch=='O'||ch=='u'||ch=='U') {
				
				vow++;
			}
			else
				cons++;
			}
		}
		System.out.println("Vowels : "+vow+"\nConsonants : "+cons);
		
		
	}

}
