//Write a Java program to count the number of words ending in 'm' or 'n'.

package practicedays_JAVA;

public class WordsEndingM_N {
	
	public int charEndWithMorN(String s) {
		
		int length= s.length();
		int ctr=0;
		
		s = s.toLowerCase();
		
		for (int i = 0; i < length; i++) {
			
			if (s.charAt(i)=='m' || s.charAt(i)=='n') {
				
				if (i< length-1 && !Character.isLetter(s.charAt(i+1))) 
					
					ctr++;
				
				else if(i==length-1)
					ctr++;
				
				
			}
			
		}
		
		return ctr;
		
	}

	public static void main(String[] args) {
	
		WordsEndingM_N obj= new WordsEndingM_N();

		String input= "Run on the lane Ram";
		System.out.println("Output string :"+obj.charEndWithMorN(input));
	}

}
