import java.util.*;
public class ReverseString {
	
	public static void main(String args[]) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Please enter the String you want to reverse:");
		String str1=sc.nextLine();
		String str2="";
		
		System.out.println("Original String is : "+str1);
		
		for(int i=str1.length()-1;i>=0;i--) {
			
			str2=str2+str1.charAt(i);
		}
		
		System.out.print("The reversed String is : "+str2);
		
		
	}

}
