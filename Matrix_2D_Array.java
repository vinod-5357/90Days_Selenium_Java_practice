package javaTestLeaf;

public class Matrix_2D_Array {

	public static void main(String[] args) {
		
		int rows= 2, columns=4;
		
int[][] matrixA= {{1,2,3,4} , {5,6,7,8}};
int[][] matrixB= {{4,3,2,1} , {8,7,6,5}};

int[][]sum = new int [rows][columns];

for (int i = 0; i < rows; i++) {
	
	for (int j = 0; j < columns; j++) {
		
		sum[i][j]= matrixA[i][j]+matrixB[i][j];
		
		
	}
	
}

System.out.println("Sum of given matrices is:");

for (int i = 0; i < rows; i++) {
	
	for (int j = 0; j < columns; j++) {
		
		System.out.print(sum[i][j]+" ");
		
	}
	
	System.out.println();
	
}
}

}