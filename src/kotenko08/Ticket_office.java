package ua.khpi.oop.kotenko08;

import java.util.ArrayList;

public class Ticket_office {
	private String departure_time; // Время отправки
	private int number_of_seats_available; // Кол-во свободных мест
	private int the_total_number_of_seats; // Мест всего
	private String days; // День недели
	private int number; // Номер рейса
	private ArrayList<Station> stations;
	
//	public Ticket_office(String departure_time,int number_of_seats_available,int the_total_number_of_seats,String days,int number, ArrayList<Station> stations) {
//		this.departure_time = departure_time;
//		this.number_of_seats_available = number_of_seats_available;
//		this.the_total_number_of_seats = the_total_number_of_seats; 
//		this.days = days;
//		this.the_total_number_of_seats = the_total_number_of_seats;
//		this.stations = stations;
//    } 
	
	public Ticket_office() {
        
    }
	
	public void set_departure_time(String temp) {
        this.departure_time = temp;
    }
	
	public void set_number_of_seats_available(int temp) {
        this.number_of_seats_available = temp;
    }
	
	public void set_the_total_number_of_seats(int temp) {
        this.the_total_number_of_seats = temp;
    }
	
	public void set_days(String temp) {
        this.days = temp;
    }

	public void set_number(int temp) {
        this.number = temp;
    }
	
    public String get_departure_time() {
        return departure_time;
    }
    
    public String get_days() {
        return days;
    }
    
	public int get_number_of_seats_available() {
		return number_of_seats_available;
	}
	
	public int get_the_total_number_of_seats() {
		return the_total_number_of_seats;
	}
	
	public int get_number() {
		return number;
	}
	
	public void print() {
		System.out.println();
		System.out.println("Маршрут:");
		for(Station a : stations) {
			System.out.println("Название станции: " + a.get_station_name());
			System.out.println();
			System.out.println("Время отправки: " + a.get_arrival_time());
		}
		System.out.printf("Номер рейса: " + this.number + '\n'
				+ "День недели: " + this.days + '\n'
				+ "Время отправки: " + this.departure_time + '\n'
				+ "Всего мест: " + this.the_total_number_of_seats + '\n'
				+ "Количество свободных мест: " + this.number_of_seats_available);
	}

	public ArrayList<Station> getStations() {
		return stations;
	}

	public void setStations(ArrayList<Station> stations) {
		this.stations = stations;
	}
}