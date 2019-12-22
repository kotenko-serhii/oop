package ua.khpi.oop.kotenko06;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import ua.khpi.oop.kononenko05.Helper;
import ua.khpi.oop.kotenko06.Function;

public class Main06 {
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
	    	+ "7 - Clear" + '\n'
	    	+ "8 - Save data" + '\n'
	    	+ "9 - Recover data" + '\n');
	    		option = in.nextInt();
	    		
	    		switch (option) {
	    			case 1: {
	    				Enter_String();
	    				break;
	    			}
	    			
	    			case 2: {
	    				Show_Data();
	    				Helper.Print_info();
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
	    			
	    			case 8:{
	    				Save_Conteiner();
	    				break;
	    			}
	    			
	    			case 9:{
	    				Recover_Container();
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
		public static void Save_Conteiner() throws IOException {
			FileOutputStream outputStream = new FileOutputStream("C:\\eclipse\\tmp\\test.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
		    objectOutputStream.writeObject(list);
		    objectOutputStream.close();
		}
		
		public static void Recover_Container() throws IOException, ClassNotFoundException {
			FileInputStream fileInputStream = new FileInputStream("C:\\eclipse\\tmp\\test.txt");
		    @SuppressWarnings("resource")
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		    list = (String_Function) objectInputStream.readObject();
		}
	    public static void Add_Element() {
			@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
			System.out.println("Enter your string:");
			String tmp = in.nextLine();
			list.add(tmp);
		}
}
