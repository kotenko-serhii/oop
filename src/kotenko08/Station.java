package ua.khpi.oop.kotenko08;

public class Station {
private String station_name; // Название станции
private String arrival_time; // Время прибытия

//public Station(String enter_station_name, String enter_arrival_time) {
//	this.station_name = enter_station_name;
//	this.arrival_time = enter_arrival_time;
//}

public Station() {
	
}

public void set_station_name(String temp) {
    this.station_name = temp;
}

public void set_arrival_time(String temp) {
    this.arrival_time = temp;
}

public String get_station_name() {
    return station_name;
}

public String get_arrival_time() {
    return arrival_time;
}

}

