package practicedays_JAVA;

public class ComplexNum {
	
	double real, img;
	
	//constructor
	public ComplexNum(double real, double img) {
		
		this.real=real;
		this.img=img;
		
	}
	
	//method
	
	public static ComplexNum sum(ComplexNum c1, ComplexNum c2) {
		
		ComplexNum temp = new ComplexNum(0, 0);
		temp.real = c1.real + c2.real ;
		temp.img = c1.img + c2.img;
		
		return temp;
		
		
	}

	public static void main(String[] args) {
	
		ComplexNum c1 = new ComplexNum(5, 6);
		ComplexNum c2 = new ComplexNum(3, 4);
		ComplexNum temp = sum(c1, c2);
		
		System.out.println("Sum is "+temp.real+"+ i"+temp.img);

	}

}
