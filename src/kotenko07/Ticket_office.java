package ua.khpi.oop.kotenko07;

interface Printable {
	void print();
}

public class Ticket_office {
	private String station_name; // �������� �������
	private String arrival_time; // ����� ��������
	private String departure_time; // ����� ��������
	private int number_of_seats_available; // ���-�� ��������� ����
	private int the_total_number_of_seats; // ���� �����
	private String days; // ���� ������
	private int number; // ����� �����
	
	public Ticket_office(String station_name, String arrival_time, String departure_time,int number_of_seats_available, int the_total_number_of_seats, String days, int number) {
        this.station_name = station_name;
        this.arrival_time = arrival_time;
        this.departure_time = departure_time;
        this.number_of_seats_available = number_of_seats_available;
        this.the_total_number_of_seats = the_total_number_of_seats;
        this.days = days;
        this.number = number;
    }

    public String get_station_name() {
        return station_name;
    }

    public String get_arrival_time() {
        return arrival_time;
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
		System.out.println("Route:");
		System.out.printf("Station name: " + this.station_name + '\n'
				+ "Flight number: " + this.number + '\n'
				+ "Days: " + this.days + '\n'
				+ "Time: " + this.departure_time + " - " + this.arrival_time + '\n'
				+ "The total number of seats: " + this.the_total_number_of_seats + '\n'
				+ "Number of seats available: " + this.number_of_seats_available);
	}
}
