package javaTestLeaf;

import java.util.Scanner;

public class PalindromeString {

	public static void main(String[] args) {
		
		String str, rev = "";
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter a String ");
		str= sc.nextLine();
		
		int length= str.length();
		
		for (int i = length-1; i >=0; i--) 
			
			rev=rev+str.charAt(i);
			
		if(str.equals(rev))
			
			System.out.println("Entered string is palindrome");
		
		else
			
			System.out.println("Entered string is not palindrome");
		

	}

}
