package javaTestLeaf;

import java.util.Scanner;

public class SortArray {

	public static void main(String[] args) {

		int count, temp;

		//step 1
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the number of elements in an Array");
		count= sc.nextInt();

		int num[] = new int[count];
		System.out.println("Enter Array Elements");

		for (int i = 0; i < count; i++) {

			num[i]=sc.nextInt();

		}
		
		sc.close();
		
		//step2
		
		for (int i = 0; i < count; i++) {
			
			for (int j = i+1; j < count; j++) {
				
				if (num[i]>num[j]) {
					
					temp = num[i];
					num[i]=num[j];
					num[j]=temp;
					
				}
				
			}
			
		}
		
		
		System.out.println("Array elements in ascending order");
		
		for (int i = 0; i < count-1; i++) {
			
			System.out.println(num[i]+", ");
			
		}
		
		System.out.println(num[count-1]);

	}

}
