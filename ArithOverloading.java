package practicedays_JAVA;

public class ArithOverloading {
	
	
	public int add(int x, int y) {
		
		int sum;
		
		sum=x+y;
		
		return sum;
		
	}
	
public int add(int x, int y, int z) {
	
	int sum;
	
	sum= x+y+z;
	
	return sum;
		
	}



	public static void main(String[] args) {


		ArithOverloading obj = new ArithOverloading();
		int a = obj.add(5, 10);
		int b = obj.add(5, 10, 15);
		
		System.out.println("Sum of two argument :"+a);
		System.out.println("Sum of three argument :"+b);
		
		
		

	}

}
