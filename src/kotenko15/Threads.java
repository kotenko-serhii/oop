package ua.khpi.oop.kotenko15;

import ua.khpi.oop.kotenko12.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Threads {

    public static void test1() throws InterruptedException {
        int count = 0;
        System.out.println("First Thread started");
        try {
            for (Ticket_office elem : Interface.object) {
                if (!Thread.currentThread().isInterrupted()) {
                    if (Regex.check_work_days(elem.get_days())) {
                        count++;
                    }
                } else {
                    throw new InterruptedException();
                }
            }
            System.out.println("Number of trips in monday and friday: " + count);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void test2() throws InterruptedException {
        int count = 0;
        System.out.println("Second Thread started");
        try {
            for (Ticket_office elem : Interface.object) {
                if (!Thread.currentThread().isInterrupted()) {
                    count += elem.get_total_number_of_sits();
                } else {
                    throw new InterruptedException();
                }
            }
            count /= Interface.object.size();
            System.out.println("Average total number of sits: " + count);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void test3() throws InterruptedException {
        My_Data now = new My_Data(00, 00);
        System.out.println("Third Thread started");
        try {
            for (Ticket_office elem : Interface.object) {
                if (!Thread.currentThread().isInterrupted()) {
                    if (now.getToCompare() > elem.get_departure().getToCompare()) {
                        now = elem.get_departure();
                    }
                } else {
                    throw new InterruptedException();
                }
            }
            System.out.println("Earliest trip is at: " + now);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }


    public static void startThreads() {
        System.out.println("Set the timer [0 - 100 000 ms]: ");
        int timer_num = Enter_Data.enter_total_number_of_sits();
        System.out.println("Starting all threads...");

        Thread1 first = new Thread1();
        Thread t1 = new Thread(first, "FirstThread");

        Thread2 second = new Thread2();
        Thread t2 = new Thread(second, "SecondThread");

        Thread3 third = new Thread3();
        Thread t3 = new Thread(third, "ThirdThread");

        t1.start();
        t2.start();
        t3.start();
        Timer timer = new Timer(timer_num, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.out.println("Interrupting thread...");
                t1.interrupt();
                t2.interrupt();
                t3.interrupt();
            }
        });
        timer.setRepeats(false);
        timer.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            timer.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finishing all threads...");
    }

    public static long cParallel() {
        long time_start = System.currentTimeMillis();
        System.out.println("Starting all threads...");
        Thread1 first = new Thread1();
        Thread t1 = new Thread(first, "FirstThread");

        Thread2 second = new Thread2();
        Thread t2 = new Thread(second, "SecondThread");

        Thread3 third = new Thread3();
        Thread t3 = new Thread(third, "ThirdThread");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finishing all threads...");
        return System.currentTimeMillis() - time_start;
    }

    public static long comparisonSequential() {
        long time_start = System.currentTimeMillis();
        System.out.println("Starting sequence...");
        try {
            Threads.test1();
            Threads.test2();
            Threads.test3();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finishing sequence...");
        return System.currentTimeMillis() - time_start;
    }

}

class Thread1 implements Runnable {
    public void run() {
        int count = 0;
        System.out.println("First Thread started");
        try {
            for (Ticket_office elem : Interface.object) {
                if (!Thread.currentThread().isInterrupted()) {
                    if (Regex.check_work_days(elem.get_days())) {
                        count++;
                    }
                } else {
                    throw new InterruptedException();
                }
            }
            System.out.println("Number of trips in monday and friday : " + count);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}

class Thread2 implements Runnable {
    public void run() {
        int count = 0;
        System.out.println("Second Thread started");
        try {
            for (Ticket_office elem : Interface.object) {
                if (!Thread.currentThread().isInterrupted()) {
                    count += elem.get_total_number_of_sits();
                } else {
                    throw new InterruptedException();
                }
            }
            count /= Interface.object.size();
            System.out.println("Average number of sits: " + count);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

    }
}

class Thread3 implements Runnable {
    public void run() {
        My_Data now = new My_Data(00, 00);
        System.out.println("Third Thread started");
        try {
            for (Ticket_office elem : Interface.object) {
                if (!Thread.currentThread().isInterrupted()) {
                    if (now.getToCompare() > elem.get_departure().getToCompare()) {
                        now = elem.get_departure();
                    }
                } else {
                    throw new InterruptedException();
                }
            }
            System.out.println("Earliest trip is at : " + now);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}

