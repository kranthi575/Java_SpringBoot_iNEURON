import java.util.*;

public class SortStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str="asddfeaysbczpqfi";
		
		int arr[]=new int[26];
		
		for(int i=0;i<str.length();i++) {
			
			arr[str.charAt(i)-'a']=arr[str.charAt(i)-'a']+1;
			
		}
		for(int i=0;i<arr.length;i++) {
			
			char ch=(char)(i+'a');
			for(int j=0;j<arr[i];j++) {
				System.out.print(ch);
			}
		}
		
		

	}

}
