package ua.khpi.oop.kotenko13;

public class Main {

    public static void main(String[] args) {
        try {
            Interface.starter(args);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println(e.getMessage());
        }
    }
}
