//Swap the first and last character of a string in Java

package practicedays_JAVA;

import java.util.Scanner;

public class SwappingArray {

	public static String swapCharcters(String s) {

		int length = s.length();

		if (length <= 1) { 
			return s; 
		} 

		else 

		{ 
			return s.charAt(length - 1) + s.substring(1, length - 1) + s.charAt(0); 

		}

	}



	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter a String");

		String input= sc.next();

		System.out.println("Output String :"+swapCharcters(input));

	}

}
