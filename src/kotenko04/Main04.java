package ua.khpi.oop.kotenko04;
import java.util.Scanner;

public class Main04 {
	
    @SuppressWarnings("resource")
	public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	
    	Input a = new Input();
    	
    	boolean help = false;
    	boolean debugMode = false;
    	
    	for (String s1: args) {
    		if((s1.equals("-h")||s1.equals("-help")) && (!help)) {
    			help = true;
    		}
    		if((s1.equals("-d")||s1.equals("-debug")) && (!debugMode)) {
    			debugMode = true;
    		}
    	}
    	
    	if(help) {
    		System.out.println("Autor: Kotenko Sergey");
    		System.out.println("Task: Creating a Menu");
    		System.out.println("Functions: " + '\n' 
    				+ "1 - Enter data (Name, Surname, Data, Lab_Number)" + '\n'
    				+ "2 - Show data (Show entered information)" + '\n'
    				+ "3 - Do operatio (Execution of the delivered operation)");
    	}
    	
    	if(debugMode) {
    		System.out.println("Autor: Kotenko Sergey");
    		System.out.println("Date: 29.11.2019");
    		System.out.println("Lab_number: 4");
    		System.out.println();
    	}
    	
    	int option = 0;
    	
    	System.out.println("Enter your string: "); 
		String tmp = new Scanner(System.in).nextLine();
		System.out.println();
    	
    	do {
    		System.out.println("Enter your option: " + '\n' + "0 - Exit" + '\n' + "1 - Enter data" + '\n'
    	+ "2 - Show data" + '\n' + "3 - Do operation" + '\n');
    		option = in.nextInt();
    		
    		switch (option) {
    			case 1: {
    		        Function04.Enter_Data(a);
				break;
			}
    			case 2: {
    				Function04.Data(a);
    				break;
    			}
    			case 3:{
    				Function04.Operation(tmp);
    			     break;
    			}
    			default:
    				break;
    		}  
    		
    	}while (option != 0);
    	in.close();
    }
}