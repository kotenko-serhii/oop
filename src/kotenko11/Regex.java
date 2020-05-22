package ua.khpi.oop.kotenko11;

public class Regex {

    public static boolean check_time(String input) {
        return input.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]");
    }

    public static boolean check_flight_number(String input) {
        return input.matches("[0-9]{1,4}[a-zA-Z]{2}");
    }

    public static boolean check_sits_all(String input) {
        return input.matches("[0-9]+");
    }
    
    public static boolean check_sits(String input) {
        return input.matches("[0-9]+");
    }

    public static boolean check_name(String input) {
        return input.matches("^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$");
    }

    public static boolean check_days(String input) {
        return input.matches("^(Mon|Tues|Wed(nes)?|Thur(s)?|Fri|Sat(ur)?|Sun)(day)?");
    }
}
