//Write a Java program to repeat every character twice in the original string.

package practicedays_JAVA;

import java.util.Scanner;

public class RepeatCharacterString {

	public static String repeatTwice(String s) {

		int lenght= s.length();

		String newstring = "";

		for (int i = 0; i < lenght; i++) {

			newstring += s.substring(i, i+1) + s.substring(i, i+1);

		}

		return newstring;


	}


	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a String :");
		String input= sc.next();
		System.out.println("Output string :"+repeatTwice(input));

	}

}
