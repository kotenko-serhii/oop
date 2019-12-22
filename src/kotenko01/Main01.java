package ua.khpi.oop.kotenko01;

public class Main01 {
	
  public static void main(String arg[]) {
    final int The_score_book = 0x4676;
    final long Number = 380992969225L;
    final int Binary_code = 0b11001;
    final int Last_four = 22011;
    final int Remainder = ((9-1)%26)+1;
    final char Symbol = 73; 
    
    System.out.println(The_score_book);
    System.out.println(Number);
    System.out.println(Binary_code);
    System.out.println(Last_four);
    System.out.println(Remainder);
    System.out.println(Symbol);
    
    System.out.println("------------------------");
    System.out.println("Even numbers:");
    System.out.println(getEven(The_score_book));
    System.out.println(getEven(Number));
    System.out.println(getEven(Binary_code));
    System.out.println(getEven(Last_four));
    System.out.println(getEven(Remainder));
    System.out.println(getEven(Symbol));
    
    System.out.println("------------------------");
    System.out.println("Odd numbers:");
    System.out.println(getOdd(The_score_book));
    System.out.println(getOdd(Number));
    System.out.println(getOdd(Binary_code));
    System.out.println(getOdd(Last_four));
    System.out.println(getOdd(Remainder));
    System.out.println(getOdd(Symbol));
    
    System.out.println("------------------------");
    System.out.println("Binary numbers:");
    System.out.println(BinaryCode(The_score_book));
    System.out.println(BinaryCode(Number));
    System.out.println(BinaryCode(Binary_code));
    System.out.println(BinaryCode(Last_four));
    System.out.println(BinaryCode(Remainder));
    System.out.println(BinaryCode(Symbol));
    
  }
  
  public static int getEven(long i) {
      int res = 0;
      long temp = i;
      long count = 0;
      while (temp != 0) {
    	  count = temp % 10;
    	  temp = temp / 10;
          if (count % 2 == 0)
        	  res++;
      }
      return res;
  }
  
  public static int getEven(int i) {
      int res = 0;
      int temp = i;
      int count = 0;
      while (temp != 0) {
    	  count = temp % 10;
    	  temp = temp / 10;
          if (count % 2 == 0)
        	  res++;
      }
      return res;
  }
  
  public static int getOdd(long i) {
      int res = 0;
      long temp = i;
      long count = 0;
      while (temp != 0) {
    	  count = temp % 10;
    	  temp = temp / 10;
          if (count % 2 != 0)
        	  res++;
      }
      return res;
  }
  
  public static int getOdd(int i) {
      int res = 0;
      int temp = i;
      int count = 0;
      while (temp != 0) {
    	  count = temp % 10;
    	  temp = temp / 10;
          if (count % 2 != 0)
        	  res++;
      }
      return res;
  }
  
  public static int BinaryCode(int i) {
	    String temp = Integer.toBinaryString(i);
	    int one = 0;
	    int res = 0;
	    for(int j = 0;j < temp.length();j++) {
	      one = (int)temp.charAt(j);
	      if(one == 49) {
	        res++ ; 
	      }
	    }
	    
	    return res;
	  }
	  
  public static int BinaryCode(long i) {
	    String temp = Long.toBinaryString(i);
	    long one = 0;
	    int res = 0;
	    for(int j = 0;j < temp.length();j++) {
	      one = (int)temp.charAt(j);
	      if(one == 49) {
	        res++ ; 
	      }
	    }
	    return res;
	  }
  
}