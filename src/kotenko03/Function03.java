package ua.khpi.oop.kotenko03;

public class Function03 {
    public static boolean Equal(String word_1,String word_2) {
    	
   	 if(word_1.length() != word_2.length()) {
            return false;
        }
   	 
       for (int i = 0; i < word_1.length(); i++) {
           char ch_1 = word_1.charAt(i);
           char ch_2 = word_2.charAt(i);
           if(ch_1 != ch_2) {
            return false;
           }
       }
       return true;
   } 
}
