package ua.khpi.oop.kotenko03;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;

public class Main03 {

    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       System.out.println("Enter your string:"); 
       ArrayList<String> words = new ArrayList<String>();
       LinkedList<String> un_words = new LinkedList<String>();
       StringBuffer string_1 = new StringBuffer(in.nextLine());
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
       
       in.close();
       
       boolean exist = false;
       Iterator<String> iter = un_words.iterator();
       for(int i = 0; i<words.size();i++) {
    	   iter = un_words.iterator();
    	   exist = false;
    	   while(iter.hasNext()) {
    		   String value = iter.next();
    		   if(Function03.Equal(words.get(i),value)) {
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
     }
     
    }
         
}