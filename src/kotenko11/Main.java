package ua.khpi.oop.kotenko11;

public class Main {

    public static void main(String[] args) {
        try {
            Interface.starter(args);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Error");
            System.err.println(e.getMessage());
        }
    }
}