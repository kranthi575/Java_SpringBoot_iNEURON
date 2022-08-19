import java.util.*;

public class RepeatedlyOccuringCh {

	public static void main(String arga[]) {
		
		int arr[]=new int[26];
		System.out.println("Enter the String:");
		Scanner sc=new Scanner(System.in);
		
		String str=sc.nextLine();
		str=str.toLowerCase();
		
		for(int i=0;i<str.length();i++) {
			
			arr[str.charAt(i)-'a']=arr[str.charAt(i)-'a']+1;
			
		}
		
		for(int i=0;i<arr.length;i++) {
			char c=(char)(i+97);
			if(arr[i]>1)
			System.out.println(c+" "+arr[i]);
		}
		
	}
}
