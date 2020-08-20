package practicedays_JAVA;

import java.util.Scanner;

public class EvenOddArray {

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
	
	System.out.println("odd numbers");
	for (i = 0; i <num; i++) {
		
		if (a[i]%2!=0) {
			
			System.out.print(a[i]+" ");
			
		}
		
		
	}
	
	System.out.println("");
	
	System.out.println("Even numbers");
	
	for (i = 0; i < num; i++) {
		
		if(a[i]%2==0) {
			
			System.out.print(a[i]+" ");
			
		}
		
	}
	
	
	}

}
