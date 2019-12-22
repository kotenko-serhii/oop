package ua.khpi.oop.kotenko07;

import java.util.Scanner;

public class Function {

	public static String enter_station_name() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.print("Enter station name: ");
		String station_name = in.nextLine();
		return station_name;
	}
	
	public static String enter_arrival_time() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.print("Enter arrival time: ");
		String arrival_time = in.nextLine();
		return arrival_time;
	}
	
	public static String enter_departure_time() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.print("Enter departure time: ");
		String departure_time = in.nextLine();
		return departure_time;
	}
	
	public static int enter_the_total_number_of_seats() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the total number of seats: ");
		int the_total_number_of_seats = in.nextInt();
		return the_total_number_of_seats;
	}
	
	public static String enter_days() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.print("Enter week days: ");
		String days = in.nextLine();
		return days;
	}
	
	public static int enter_number() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.print("Enter flight number : ");
		int number = in.nextInt();
		return number;
	}
	
	public static int enter_number_of_seats_available() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.print("Enter number of seats available: ");
		int number_of_seats_available = in.nextInt();
		return number_of_seats_available;
	}
	
	public static void show_data(Ticket_office[] route) {
		for(int i = 0; i < route.length; i++) {
			route[i].print();
		}		
	}
}
