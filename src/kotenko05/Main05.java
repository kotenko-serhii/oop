package ua.khpi.oop.kotenko05;

import java.io.IOException;
import java.util.Scanner;

import ua.khpi.oop.kotenko06.Function;
import ua.khpi.oop.kotenko06.String_Function;

public class Main05 {
	static String_Function list = new String_Function();
	 public static void main(String[] args) throws IOException, ClassNotFoundException {
	    	Scanner in = new Scanner(System.in);
	    	int option = 0;
	    	
	    	do {
	    		System.out.println("Enter your option: " + '\n' 
	    	+ "0 - Exit" + '\n' 
	    	+ "1 - Enter string" + '\n' 
	    	+ "2 - Show data" + '\n' 
	    	+ "3 - Do operation" + '\n'
	    	+ "4 - Sort" + '\n' 
	    	+ "5 - Add element" + '\n'
	    	+ "6 - Remove element by index" + '\n'
	    	+ "7 - Clear" + '\n');
	    		option = in.nextInt();
	    		
	    		switch (option) {
	    			case 1: {
	    				Enter_String();
	    				break;
	    			}
	    			
	    			case 2: {
	    				Show_Data();
	    				break;
	    			}
	    			
	    			case 3:{
	    				String temp = list.getByIndex(0);
						Function.Operation(temp);
	    			    break;
	    			}
	    			
	    			case 4:{
	    				list.sortArray();
	    				break;
	    			}
	    			
	    			case 5:{
	    				Add_Element();
	    				break;
	    			}
	    			
	    			case 6:{
	    				@SuppressWarnings("resource")
						Scanner inn = new Scanner(System.in);
	    				System.out.println("Enter delete string: ");
	    				String str = inn.nextLine();
	    				list.remove(str);
	    				break;
	    			}
	    			
	    			case 7:{
	    				list.clear();
	    				break;
	    			}
	    			
	    			default:
	    				break;
	    		}  
	    		
	    	}while (option != 0);
	    	in.close();
	    }
	 
		public static void Enter_String() {
	    	@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
			System.out.println("Enter your string:");
			String tmp = in.nextLine();
			list.add(tmp);
	    }
		
	    public static void Show_Data() {
			for(String tmp : list) {
				System.out.println(tmp);
			}
		}
	    
	    public static void Add_Element() {
			@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
			System.out.println("Enter your string:");
			String tmp = in.nextLine();
			list.add(tmp);
		}
}
