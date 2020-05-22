package ua.khpi.oop.kotenko08;

import java.util.ArrayList;

public class Ticket_office {
	private String departure_time; // ����� ��������
	private int number_of_seats_available; // ���-�� ��������� ����
	private int the_total_number_of_seats; // ���� �����
	private String days; // ���� ������
	private int number; // ����� �����
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
		System.out.println("�������:");
		for(Station a : stations) {
			System.out.println("�������� �������: " + a.get_station_name());
			System.out.println();
			System.out.println("����� ��������: " + a.get_arrival_time());
		}
		System.out.printf("����� �����: " + this.number + '\n'
				+ "���� ������: " + this.days + '\n'
				+ "����� ��������: " + this.departure_time + '\n'
				+ "����� ����: " + this.the_total_number_of_seats + '\n'
				+ "���������� ��������� ����: " + this.number_of_seats_available);
	}

	public ArrayList<Station> getStations() {
		return stations;
	}

	public void setStations(ArrayList<Station> stations) {
		this.stations = stations;
	}
}