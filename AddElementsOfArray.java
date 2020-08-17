package practicedays_JAVA;

public class AddElementsOfArray {

	public static void main(String[] args) {


		int numbers[] = {1,3,5,7,9};
		int sum=0;
		
		for (int a : numbers) {
			
			sum=sum+a;
			
		}

		
		System.out.println("Sum of the numbers :"+sum);
	}

}
