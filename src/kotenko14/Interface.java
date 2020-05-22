package ua.khpi.oop.kotenko14;

import ua.khpi.oop.kotenko12.*;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Interface {
    private static Scanner in = new Scanner(System.in);
    public static My_Linked_List<Ticket_office> object = new My_Linked_List<>();

    public static void starter(String[] arg) {
        if (arg.length == 0) {
            menu();
        } else if ("-auto".equals(arg[0])) {
            autoMode();
        }
    }

    private static void menu() {
        int choose;

        settings();
        choose = in.nextInt();
        while (choose != 0) {
            switch (choose) {
                case 1:
                    printList(object);
                    break;
                case 2:
                    object.add(Enter_Data.insert());
                    break;
                case 3:
                    remove(object);
                    break;
                case 4:
                    sorters(object);
                    break;
                case 5:
                    clear(object);
                    break;
                case 6:
                    toStr(object);
                    break;
                case 7:
                	Ticket_office[] test = object.toArray(new Ticket_office[object.size()]);
                    break;
                case 8:
                    save(object);
                    break;
                case 9:
                    object = download();
                    break;
                case 10:
                	setting_search(object);
                    break;
                case 11:
                	 object = Generate_Data.generator(Enter_Data.enter_amount_of_data());
                    break;
                case 12:
                    Threads.startThreads();
                    break;
                case 13:
                    long b = Threads.cParallel();
                    long j = Threads.comparisonSequential();

                    System.out.println("Time via sequential: " + j);
                    System.out.println("Time via parallel: " + b);
                    System.out.println("Diference: " + (double)b/j);
                    break;
            }
            settings();
            choose = in.nextInt();
        }
    }

    private static void save(My_Linked_List<Ticket_office> input) {
        int choose;
        System.out.println("What type of saving do you wish for: ");
        System.out.println("1 - XML");
        System.out.println("2 - Standard Serialization");
        System.out.println("Choose: ");
        choose = in.nextInt();
        try {
            if (choose == 1) {
                Serialization.LongTermPersistenceWrite(input, Files.controller());
            } else {
                Serialization.ObjectWrite(input, Files.controller());
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void autoMode() {
        object = download();
        menu();
    }

    public static boolean checker(Ticket_office input) {
        return Regex.check_flight_number(input.get_flight_number())
                && Regex.check_time(input.get_departure().toString())
                && Regex.check_days(input.get_days())
                && Regex.check_sits_all(String.valueOf(input.get_total_number_of_sits()))
                && Regex.check_sits(String.valueOf(input.get_number_of_seats_available()))
                && Regex.check_name(input.getStorage().toString());
    }

    private static My_Linked_List<Ticket_office> download() {
    	My_Linked_List<Ticket_office> output = new My_Linked_List<>();
        int choose;
        System.out.println("What type of saving do you wish for: ");
        System.out.println("1 - XML");
        System.out.println("2 - Standard Serialization");
        System.out.println("Choose: ");
        choose = in.nextInt();
        try {
            if (choose == 1) {
                output = Serialization.LongTermPersistenceRead(Files.controller());
            } else {
                output = Serialization.ObjectRead(output, Files.controller());
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return output;
    }

    private static void settings() {

        System.out.println("Menu: ");
        System.out.println("0 - Exit");
        System.out.println("1 - Show data");
        System.out.println("2 - Insert");
        System.out.println("3 - Remove");
        System.out.println("4 - Sort");
        System.out.println("5 - Clear");
        System.out.println("6 - to String");
        System.out.println("7 - to Array");
        System.out.println("8 - Save");
        System.out.println("9 - Download");
        System.out.println("10 - Search");
        System.out.println("11 - Generate data");
        System.out.println("12 - Multithreaded");
        System.out.println("13 - Comparison");
        System.out.print("Select: ");

    }

    private static void settingAdvance() {
        System.out.println("Menu of settings: ");
        System.out.println("0 - Exit");
        System.out.println("1 - Sort by total number of sits");
        System.out.println("2 - Sort by days");
        System.out.println("3 - Sort by flight number");
        System.out.println("4 - Show data");
        System.out.print("Select: ");
    }

    private static void sorters(My_Linked_List<Ticket_office> input) {
        int choose;
        settingAdvance();
        choose = in.nextInt();
        while (choose != 0) {
            switch (choose) {
                case 1:
                    input.sort(new Comparator<Ticket_office>() {
                        @Override
                        public int compare(Ticket_office o1, Ticket_office o2) {
                            return (o1. get_total_number_of_sits()) - (o2. get_total_number_of_sits());
                        }
                    }, input.toArray(new Ticket_office[input.size()]));
                    break;
                case 2:
                    input.sort(new Comparator<Ticket_office>() {
                        @Override
                        public int compare(Ticket_office p1, Ticket_office p2) {
                            if (p1.get_days() != p2.get_days()) {
                                return int_get_days(p1.get_days()) - int_get_days(p2.get_days());
                            }
                            return 0;
                        }
                    }, input.toArray(new Ticket_office[input.size()]));
                    break;
                case 3:
                    input.sort(new Comparator<Ticket_office>() {
                        @Override
                        public int compare(Ticket_office p1, Ticket_office p2) {
                            if (p1.get_flight_number() != p2.get_flight_number()) {
                                return extractInt(p1.get_flight_number()) - extractInt(p2.get_flight_number());
                            }
                            return 0;
                        }
                        int extractInt(String s) {
                            String num = s.replaceAll("\\D", "");
                            return num.isEmpty() ? 0 : Integer.parseInt(num);
                        }
                    }, input.toArray(new Ticket_office[input.size()]));
                    break;
                case 4:
                    printList(input);
                    break;
            }
            settingAdvance();
            choose = in.nextInt();
        }
    }
    
    private static void setting_search(My_Linked_List<Ticket_office> input) {
        String[] stations = new String[1];
            stations[0] = Enter_Data.enterName();
        for (Ticket_office elem : input) {
            if (search(elem, stations)) {
                System.out.println(elem);
            }
        }
    }

    private static void remove(My_Linked_List<Ticket_office> input) {
        int num;
        if (input.size() != 0) {
            System.out.println("Input number of note: ");
            num = in.nextInt();
            if (num >= 0 && num < input.size()) {
                input.remove(num);
            }
        } else {
            System.out.println("Error: arr is empty");
        }
    }

    private static void clear(My_Linked_List<Ticket_office> input) {
        System.out.print("Are you sure that you want delete list \n\t\t" + "\"Yes" + "|NO\":");
        if (in.next().matches("Yes|yes")) {
            input.clear();
        }
    }

    private static String toStr(My_Linked_List<Ticket_office> input) {
        return input.toString();
    }

    private static <E> void printList(My_Linked_List<E> input) {
        for (E elem : input) System.out.println(elem);
    }

    private static boolean search(Ticket_office input, String[] input2) {
        if (Regex.check_work_days(input.get_days())) {
            if (Regex.check_time_am(input.get_departure().toString())) {
                return Regex.check_stations(input.getStorage().toString(), input2);
            }
        }
        return false;
    }

    private static int int_get_days(String input) {
    	Map<String, Integer> hashmap = new HashMap<String, Integer>();
    	hashmap.put("Mon", 1);
    	hashmap.put("Tues", 2);
    	hashmap.put("Wed", 3);
    	hashmap.put("Thur", 4);
    	hashmap.put("Fri", 5);
    	hashmap.put("Sat", 6);
    	hashmap.put("Sun", 7);
    	for(Map.Entry<String,Integer> entry : hashmap.entrySet()) {
    		if(input.equals(entry.getKey())) {
    			return entry.getValue();
    		}
    	}
    	return 0;
    }
}
