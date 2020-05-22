package ua.khpi.oop.kotenko12;

public class Regex {

    public static boolean check_work_days(String input) {
        return input.matches("[\\S\\s]*(Mon|Fri)(day)?[\\S\\s]*");
    }
    
    public static boolean check_time_am(String input) {
        return input.matches("(1[789]|2[0-3]):[0-5][0-9]");
    }
    
    public static boolean check_stations(String input,String[] station) {
        return input.matches("[\\S\\s]" + station[0]) ;
    }
    
    public static boolean check_time(String input) {
        return input.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]");
    }

    public static boolean check_sits(String input) {
        return input.matches("[0-9]+");
    }
    
    public static boolean check_sits_all(String input) {
        return input.matches("[0-9]+");
    }

    public static boolean check_name(String input) {
        return input.matches("^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$");
    }

    public static boolean check_days(String input) {
        return input.matches("^(Mon|Tues|Wed(nes)?|Thur(s)?|Fri|Sat(ur)?|Sun)(day)?");
    }

	public static boolean check_flight_number(String input) {
        return input.matches("[0-9]{1,4}[a-zA-Z]{2}");
    }
}
