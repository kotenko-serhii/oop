package ua.khpi.oop.kotenko09;

import java.io.IOException;
import java.util.Scanner;

public class Interface {
    private static Scanner in = new Scanner(System.in);
    private static My_Linked_List<Ticket_office> object = new My_Linked_List<>();

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
                case 5:
                    clear(object);
                    break;
                case 6:
                    toStr(object);
                    break;
                case 7:
                	@SuppressWarnings("unused") Ticket_office[] test = object.toArray(new Ticket_office[object.size()]);
                    break;
                case 8:
                    save(object);
                    break;
                case 9:
                    object = download();
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
        System.out.println("5 - Clear");
        System.out.println("6 - to String");
        System.out.println("7 - to Array");
        System.out.println("8 - Save");
        System.out.println("9 - Download");
        System.out.println("Select: ");
    }

    private static void remove(My_Linked_List<Ticket_office> input) {
        int num;
        if (input.size() != 0) {
            System.out.println("Enter note number: ");
            num = in.nextInt();
            if (num >= 0 && num < input.size()) {
                input.remove(num);
            }
        } else {
            System.out.println("Array is empty");
        }
    }

    private static void clear(My_Linked_List<Ticket_office> input) {
        System.out.print("Delete that list \n\t\t" + "\"Yes" + "|No\":");
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
}

