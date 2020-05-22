package ua.khpi.oop.kotenko13;

import ua.khpi.oop.kotenko12.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Threads {
    public static void startThreads() {
        int timer_num = Enter_Data.enter_timer();
        System.out.println("");

        Thread1 first = new Thread1();
        Thread t1 = new Thread(first, "Thread ¹1");

        Thread2 second = new Thread2();
        Thread t2 = new Thread(second, "Thread ¹2");

        Thread3 third = new Thread3();
        Thread t3 = new Thread(third, "Thread ¹3");

        t1.start();
        t2.start();
        t3.start();
        Timer timer = new Timer(timer_num, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.out.println("");
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
    }
}

class Thread1 implements Runnable {
    public void run() {
        int count = 0;
        System.out.println("First Thread: ");
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
        System.out.println("Second Thread: ");
        try {
            for (Ticket_office elem : Interface.object) {
                if (!Thread.currentThread().isInterrupted()) {
                    count += elem.get_number_of_seats_available();
                } else {
                    throw new InterruptedException();
                }
            }
            count /= Interface.object.size();
            System.out.println("Average number of available sits: " + count);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

    }
}

class Thread3 implements Runnable {
    public void run() {
        My_Data now = new My_Data(00, 00);
        System.out.println("Third Thread: ");
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
            System.out.println("First trip is at : " + now);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}

