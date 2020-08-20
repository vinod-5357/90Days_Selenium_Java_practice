package practicedays_JAVA;

import java.util.Scanner;

public class IncrementArray {

	public static void main(String[] args) {
		
		int num,i;
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Number of elements in an Array");
		num= sc.nextInt();

		int a[]= new int[num];
		
	System.out.println("Enter the elements");
	
	for ( i = 0; i< num; i++) {
		
		a[i]=sc.nextInt();
		a[i]++;
		
	}
	
	
	System.out.println("Element of an Array incremented by 1");
	
	for (i = 0;  i< num-1; i++) {
		
		System.out.println(a[i]);
		
	}
	
		 System.out.println(a[num-1]); 
	
	}

}
