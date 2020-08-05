package practicedays_JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PerfectSquare {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));

System.out.println("Please enter an integer :");
int num = Integer.parseInt(reader.readLine());

int sqrt =  (int)Math.sqrt(num);

if (sqrt*sqrt==num) {  
	
	System.out.println("Given number is perfect square ");
}

else
{
	
	System.out.println("Given number is not a perfect square ");
}


	}

}
