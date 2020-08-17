package practicedays_JAVA;

public class LargestSmallest_Array {

	public static void main(String[] args) {
	
		int numbers[]= new int[] {10,8,19,55,0,17};
		int smallest= numbers[0];
		int largest= numbers[0];
		
		
		for (int i = 1; i < numbers.length; i++) {
			
			
			if(numbers[i]>largest)
				
				largest=numbers[i];
			
			else if(numbers[i]<smallest)
				
				smallest=numbers[i];
			
		}
		
		
		System.out.println("Largest number is :"+largest);
		System.out.println("Smallest number is :"+smallest);
	}

}
