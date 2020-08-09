package practicedays_JAVA;

public class AlternativePrime {

	public static void main(String[] args) {

		int num = 20;
		int count = 0;

		for (int i = 2; i < num; i++) {

			boolean isprime = true;

			for (int j = 2; j < i; j++) {

				if (i % j == 0) {

					isprime = false;
					break;
				}

			}

			
			/*
			 * if (isprime) {
			 * 
			 * System.out.print(i+" ");
			 * 
			 * }
			 */
			 
			if (isprime)
				count++;

			
			  if((isprime)&&(count%2==0))
			  
			  System.out.println(i);
			 
		}

	}

}
