package practicedays_JAVA;

import java.util.Scanner;

public class FloydsTriangle {

	public static void main(String[] args) {
		
		int a, b,n, num=1;
		
		 Scanner in = new Scanner(System.in);
	      System.out.println("Enter the number of rows of floyd's triangle you want");
	      n = in.nextInt();
	      
	      System.out.println("Floyd's triangle :");
	      
	      for(a=1; a<=n; a++) {
	    	  
	    	  for(b=1; b<=a; b++) {
	    		  
	    		  System.out.print(num+" ");
	    		  num++;
	    	  }
	    	  
	    	  System.out.println();
	      }

	}

}



