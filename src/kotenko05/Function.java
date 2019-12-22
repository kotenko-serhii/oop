package ua.khpi.oop.kotenko05;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Function {
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
	    
	    public static void Operation(String droppedString) {
	    	StringBuffer string_1 = new StringBuffer(droppedString);
	    	ArrayList<String> words = new ArrayList<String>();
	    	LinkedList<String> un_words = new LinkedList<String>();
	    	int temp = string_1.indexOf(" ") + 1;
		       
		       while(string_1.length() != 0) {
		    	    
		    	   String temp_str= new String(string_1.substring(0,temp));
		    	   temp_str = temp_str.trim();
		    	    
		    	    words.add(temp_str);
		    	    
		    	    string_1 = new StringBuffer(string_1.substring(temp)); 
		    	    
		    	    temp = string_1.indexOf(" ")+1;
		    	    if(temp == 0) { 
		    	      
		    	      temp = string_1.length(); 
		    	    
		    	      }
		    	    }
	    	
			 boolean exist = false;
		       Iterator<String> iter = un_words.iterator();
		       for(int i = 0; i<words.size();i++) {
		    	   iter = un_words.iterator();
		    	   exist = false;
		    	   while(iter.hasNext()) {
		    		   String value = iter.next();
		    		   if(Function.Equal(words.get(i),value)) {
		    			   exist = true;
		    			   break;
		    		   }
		    	   }
		    	   if(!exist) un_words.add(words.get(i));
		       }
		       
		       int[] count_word = new int[un_words.size()];
		       Iterator<String> it = un_words.iterator();
		      for(int i = 0; i < un_words.size(); i++) {
		    	   String word_1 = it.next();
		    	   iter = words.iterator();
		    	   while(iter.hasNext()) {
		    		   String word_2 = iter.next();
		    		   if(word_1.equals(word_2)) {
		    			   count_word[i]++;
		    		   }
		    	   }
		       }
		      it = un_words.iterator();
				 System.out.println("----------------------------------");
			     System.out.println("|" + " ¹ " + "|" + "      Words     " + "|" + " Iteration " + "|");
				 System.out.println("----------------------------------");
			     for(int i = 0; i  < un_words.size(); i++) {
			    	 System.out.println("| " + (i+1) + " |  " + it.next() + "     |     " + count_word[i] + "     |");
			    	 System.out.println("----------------------------------");
			    	 System.out.println();
			     }
	    }
}
