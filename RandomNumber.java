package practicedays_JAVA;

import java.util.Random;

public class RandomNumber {
	
	public static void main(String[] args) {
		
		int count;
		
		Random num = new Random();
		
		System.out.println("Random numbers :");
		
		for(count=1; count<=5; count++)
		{
			System.out.println(num.nextInt(300));
		}
		
		
	}

}
