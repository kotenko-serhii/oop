package ua.khpi.oop.kotenko02;

public class Main02 {

	public static void main(String arg[]) {
		
	System.out.println("-------------------------------------------------");
	System.out.println("|  2-й вид   | 16-й вид | Кол-во латинских букв |");
	System.out.println("-------------------------------------------------");
		
	for (int j = 0 ; j < 10 ; j++) {
		
	double c = Math.random()*1000000000L;
	long a = (long)c;
	String convert = Long.toHexString(a);
	char temp;
	int charCount = 0;
	 
	 for (int i = 0; i < convert.length(); i++) {
	        temp = convert.charAt(i);

	        if (Character.isLetter(temp)) {
	            charCount++;
	        } 
	    }
	 
	 System.out.println("|  " + a + " " + " | " + convert + " |           " + charCount + "           |");
	 System.out.println("-------------------------------------------------");
	 
	}
	}	
}
