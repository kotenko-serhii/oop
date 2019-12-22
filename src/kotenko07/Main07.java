package ua.khpi.oop.kotenko07;

import java.util.Scanner;
import ua.khpi.oop.kotenko07.Function;
import ua.khpi.oop.kotenko07.Ticket_office;

public class Main07 {
	public static void main(final String args[]){
	@SuppressWarnings("resource")
	Scanner in = new Scanner(System.in);
	System.out.print("Enter the size of array: ");
	int size = in.nextInt();
	Ticket_office[] route = new Ticket_office[size];
	for(int i = 0; i < route.length; i++) {
		route[i] = new Ticket_office(Function.enter_station_name(),	
				Function.enter_arrival_time(), 
				Function.enter_departure_time(), 
				Function.enter_the_total_number_of_seats(), 
				Function.enter_number(), 
				Function.enter_days(), 
				Function.enter_number_of_seats_available() );
	}
	Function.show_data(route);
	}
}
