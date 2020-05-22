package ua.khpi.oop.kotenko12;

import java.io.Serializable;
import java.util.ArrayList;

public class Ticket_office implements Serializable,Comparable<Ticket_office>{

	private int number_of_seats_available;
    private int total_number_of_sits;
    private My_Data departure;
    private String days;
    private String flight_number;
    public ArrayList<Station> storage;

    private static final long serialVersionUID = 1L;

    public ArrayList<Station> getStorage() {
        return storage;
    }

    public void set_storage(ArrayList<Station> storage) {
        this.storage = storage;
    }

    public Ticket_office() {
        departure = new My_Data();
        storage = new ArrayList<Station>();
    }

    public Ticket_office(Ticket_office readObject) {
        this.flight_number = readObject.flight_number;
        this.days = readObject.days;
        this.number_of_seats_available = readObject.number_of_seats_available;
        this.total_number_of_sits = readObject.total_number_of_sits;
        this.departure = readObject.departure;
        this.storage = readObject.storage;
    }

    public int get_number_of_seats_available() {
		return number_of_seats_available;
	}

	public void set_number_of_seats_available(int number_of_seats_available) {
		this.number_of_seats_available = number_of_seats_available;
	}
	
    public String get_flight_number() {
        return flight_number;
    }
    
    public void set_flight_number(String flight_number) {
        this.flight_number = flight_number;
    }

    public int get_total_number_of_sits() {
        return total_number_of_sits;
    }

    public void set_total_number_of_sits(int sits) {
        this.total_number_of_sits = sits;
    }

    public My_Data get_departure() {
        return departure;
    }

    public void set_departure(My_Data departure) {
        this.departure = departure;
    }

    public String get_days() {
        return days;
    }

    public void set_days(String days) {
        this.days = days;
    }

    public String toString() {
        StringBuilder test = new StringBuilder("Flight number: " + this.flight_number + 
        		"\nTotal number of sits: " + this.total_number_of_sits +
        		"\nNumber of available sits:  " + this.number_of_seats_available +
        		"\nWorking days: " + this.days + 
        		"\nTime of department: " + this.departure.toString() + "\n");
        for (Station s : storage) {
            test.append(s.toString() + "\n");
        }
        return test.toString();
    }

    @Override
    public int compareTo(Ticket_office o) {
        return Integer.compare(this.total_number_of_sits,o.total_number_of_sits);
    }
}