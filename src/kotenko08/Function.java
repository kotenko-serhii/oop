package ua.khpi.oop.kotenko08;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Function {

	public static String enter_station_name() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.print("¬ведите название станции: ");
		String station_name = in.nextLine();
		return station_name;
	}
	
	public static String enter_arrival_time() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.print("¬ведите врем€ прибыти€: ");
		String arrival_time = in.nextLine();
		return arrival_time;
	}
	
	public static String enter_departure_time() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.print("¬ведите врем€ отправлени€: ");
		String departure_time = in.nextLine();
		return departure_time;
	}
	
	public static int enter_the_total_number_of_seats() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.print("¬ведите общее количество мест: ");
		int the_total_number_of_seats = in.nextInt();
		return the_total_number_of_seats;
	}
	
	public static String enter_days() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.print("¬ведите день недели: ");
		String days = in.nextLine();
		return days;
	}
	
	public static int enter_number() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.print("¬ведите номер рейса: ");
		int number = in.nextInt();
		return number;
	}
	
	public static int enter_number_of_seats_available() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.print("¬ведите количество свободных мест: ");
		int number_of_seats_available = in.nextInt();
		return number_of_seats_available;
	}
	
	public static void LongTermPersistenceWrite(ArrayList<Ticket_office> object,String path) throws FileNotFoundException {
		XMLEncoder encoder = new XMLEncoder(
		           new BufferedOutputStream(
		           new FileOutputStream(path)));
		encoder.writeObject(object);
		encoder.close(); 
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Ticket_office> LongTermPersistenceRead(String path) throws FileNotFoundException {
		XMLDecoder decoder = new XMLDecoder(
			    new BufferedInputStream(
			    new FileInputStream(path)));
			ArrayList<Ticket_office> object = (ArrayList<Ticket_office>) decoder.readObject();
			decoder.close();
			return object;
	}
}