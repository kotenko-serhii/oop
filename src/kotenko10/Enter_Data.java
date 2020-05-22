package ua.khpi.oop.kotenko10;

import java.util.ArrayList;
import java.util.Scanner;

public class Enter_Data {
    private static Scanner in = new Scanner(System.in);

    public static Ticket_office insert() {
    	Ticket_office output = new Ticket_office();
        output.set_flight_number(enter_flight_number());
        output.set_total_number_of_sits(enter_total_number_of_sits());
        output.set_number_of_seats_available(enter_number_of_seats_available());
        output.set_departure(enter_time());
        output.set_days(enter_days());
        output.set_storage(enter_stations());
        return output;
    }

    private static My_Data enter_time() {
        System.out.println("Enter departure time(hh:mm): ");
        String time = in.next();
        return parser(time);
    }

    private static String enter_days() {
        System.out.println("Enter days : ");
        String days = in.next();
        return days;
    }

    public static String enterName() {
        System.out.println("Enter name of the station: ");
        String name = in.next();
        return name;
    }

    public static int enter_number_of_seats_available() {
        System.out.println("Enter number of available sits : ");
        String output = in.next();
        return Integer.parseInt(output);
    }
    
    public static int enter_total_number_of_sits() {
        System.out.println("Enter total number of sits: ");
        String output = in.next();
        return Integer.parseInt(output);
    }

    private static String enter_flight_number() {
        System.out.println("Input flight number (xxxxFF): ");
        String numb = in.next();
        return numb;
    }

    private static ArrayList<Station> enter_stations() {
        String tempStr;
        Station tempSt;
        ArrayList<Station> output = new ArrayList<>();
        @SuppressWarnings("resource")
		Scanner in2 = new Scanner(System.in);;
		System.out.print("Use exit to stop adding or ENTER to continue ");
		tempStr = in2 .nextLine();
        while (!tempStr.equals("exit")) {
            tempSt = new Station();
            tempSt.setName(enterName());
            tempSt.setTime(enter_time());
            output.add(tempSt);
            System.out.print("Use exit to stop adding or ENTER to continue ");
            tempStr = in2.nextLine();
        }
        return output;
    }

    private static My_Data parser(String input) {
        My_Data output = new My_Data();
        String[] arrOfStr = input.split(":");
        output.setHours(Integer.parseInt(arrOfStr[0]));
        output.setMinutes(Integer.parseInt(arrOfStr[1]));
        return output;
    }

}