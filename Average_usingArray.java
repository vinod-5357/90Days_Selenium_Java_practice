package practicedays_JAVA;

public class Average_usingArray {

	public static void main(String[] args) {
	
		double numbers[]= {10.5,11.8,15,22};
		
		double sum= 0, Avg;
		
		
		/* Alternative for loop
		 * 
		 * for (int i = 0; i < numbers.length; i++) {
		 * 
		 * sum=sum+numbers[i];
		 * 
		 * }
		 */
		
		for (double d : numbers) {
			
			sum=sum+d;
			
		}
		
		Avg= sum/numbers.length;
				
		System.out.println("Average of a given numbers is :"+Avg);
	}

}
