package ua.khpi.oop.kotenko08;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import ua.khpi.oop.kotenko08.Function;
import ua.khpi.oop.kotenko08.Ticket_office;

public class Main08 {
	public static ArrayList<Ticket_office> ticket = new ArrayList<Ticket_office>();
	
	@SuppressWarnings("resource")
	public static void main(final String args[]) throws Exception{
		System.setProperty("console.encoding","Cp886");
		Scanner in = new Scanner(System.in);
    	int option = 0;
		Scanner inn = new Scanner(System.in);
		System.out.print("Enter the size of array: ");
		int size = inn.nextInt();

		
    	do {
    		System.out.println("Enter your option: " + '\n' 
    	+ "0 - Exit" + '\n' 
    	+ "1 - Add data" + '\n' 
    	+ "2 - Show data" + '\n'
    	+ "3 - Clear" + '\n'
    	+ "4 - Operation at data" + '\n');
    		option = in.nextInt();
    		
    		switch (option) {
    			case 1: {
    				add_data(size);
    				break;
    			}
    			
    			case 2:{
                	if (!ticket.isEmpty()) {
                		for(int i = 0; i < ticket.size();i++) {
                			
                		for(int j = 0 ; j < ticket.get(i).getStations().size() ; j++) {
							System.out.println("�������� �������: " + ticket.get(i).getStations().get(j).get_station_name() + '\n'
						+ "����� ��������: " + ticket.get(i).getStations().get(j).get_arrival_time());
						}
                		
                	   System.out.println("����� ��������: " + ticket.get(i).get_departure_time() + "\n" +
                		"���-�� ��������� ����: " + ticket.get(i).get_number_of_seats_available() + "\n" +
                		"���-�� ���� �����: " + ticket.get(i).get_the_total_number_of_seats() + "\n" +
                		"���� ������(��������): " + ticket.get(i).get_days() + "\n" +
                		"����� �����: " + ticket.get(i).get_number() + "\n");
                		}
                	} else {
                	    System.out.println("�������� ����������!");
                	}
                        break;
    			}	
    			
    			case 3:{
    				ticket.clear();
    				break;
    			}
    			
    			case 4:{
    				String xml = ""; 
    	               int z = 0;
    	               System.out.println("1. ��������� ���� ������");
    	               System.out.println("2. ������������ ���� ������");
    	               String path = "C:\\Users\\������\\eclipse-workspace\\kotenko-serhii";
    	               xml = in.next();     
    	                 try {
    	                     z = Integer.parseInt(xml);
    	                 } catch (NumberFormatException e){
    	                     System.out.println("�������� ������ ������");
    	                 }
    	                 switch(z) {
    	                 
    	                 case 1:
    	                   String find = "";
    	                   int k = 0;
    	                   while(!"0".equals(find)) {
    	                        System.out.println("������� ����: " + path);
    	                        System.out.println("1. ���������� ����� �����");
    	                        System.out.println("2. ������� ���� � ������� ����������");
    	                        System.out.println("3. �� ���������� ����");
    	                        System.out.println("0. �����");
    	                        find = in.next();
    	                     try {
    	                         k = Integer.parseInt(find);
    	                     } catch (NumberFormatException e){
    	                         System.out.println("�������� ������ ������");
    	                     }
    	                     
    	                     switch(k) {
    	                       case 1:
    	                       path = Files.chooseFile(Files.getListOfFiles(path));
    	                       break;
    	                       case 2:
    	                         path = Files.createFile(path);
    	                         break;
    	                       case 3:
    	                          path = Files.moveHigher(path);
    	                          break;
    	                       case 0:
    	                       break;
    	                     }
    	                   }
    	                   
    	                   
    	                     try {
    	                   Function.LongTermPersistenceWrite(ticket,path);
    	                     } catch (FileNotFoundException e) {
    	                       System.out.println("��� ������ �����");
    	                       System.out.println("������� ����� ������� ��� �����������...");
    	                       new java.util.Scanner(System.in).nextLine();
    	                     }
    	                   break;
    	                   
    	                 case 2:
    	                   
    	                   String find2 = "";
    	                   int k2= 0;
    	                   while(!"0".equals(find2)) {
    	                     System.out.println("������� ����: " + path);
 	                        System.out.println("1. ���������� ����� �����");
 	                        System.out.println("2. �� ���������� ����");
 	                        System.out.println("0. �����");
    	                     find2 = in.next();
    	                     try {
    	                         k2 = Integer.parseInt(find2);
    	                     } catch (NumberFormatException e){
    	                         System.out.println("�������� ������ ������");
    	                     }
    	                     
    	                     switch(k2) {
    	                       case 1:
    	                       path = Files.chooseFile(Files.getListOfFiles(path));
    	                       break;
    	                       case 2:
    	                          path = Files.moveHigher(path);
    	                          break;
    	                       case 0:
    	                       break;
    	                     }
    	                   }
    	                   
    	                   try {
    	                     ticket = Function.LongTermPersistenceRead(path);
    	                       } catch (FileNotFoundException e) {
    	                         System.out.println("��� ������ �����");
    	                         System.out.println("������� ����� ������� ��� �����������...");
    	                         new java.util.Scanner(System.in).nextLine();
    	                       }
    	                   
    	                   break;
    	                 }
    			}
    			
    			default:
    				break;
    		}  
    	}while (option != 0);
    	in.close();
    }
	
	public static void  add_data(int size) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		Ticket_office temp = new Ticket_office();
		Station tempp = null;
		ArrayList<Station>tmp = new ArrayList<Station>();
		System.out.println("�������� �����: " 
				+ '\n' + "1 - �������� �������� ������� � ����� ��������" 
				+ '\n' + "0 - �����");
		String add = "";
		int y = 0;
		for(int i = 0; i < size; i++) {
			while(!"0".equals(add)){
            add = in.next(); 
              try {
                   y = Integer.parseInt(add);
              } catch (NumberFormatException e){
                  System.out.println("�������� ������ ������");
              }
              switch(y) {
              case 1:{
            tempp = new Station();
            tempp.set_station_name(Function.enter_station_name());
            tempp.set_arrival_time(Function.enter_arrival_time());
            tmp.add(tempp);
            tempp = null;
              }
              }
              }
			temp.setStations(tmp);
			temp.set_departure_time(Function.enter_departure_time());
			temp.set_number_of_seats_available(Function.enter_number_of_seats_available());
			temp.set_the_total_number_of_seats(Function.enter_the_total_number_of_seats());
			temp.set_days(Function.enter_days());
			temp.set_number(Function.enter_number());
			ticket.add(temp);
	}
}
}