package ua.khpi.oop.kotenko14;

import ua.khpi.oop.kotenko12.*;
import java.sql.Time;
import java.util.Random;

public class Generate_Data {

    public static My_Linked_List<Ticket_office> generator(int size) {
        char b, c;
        My_Linked_List<Ticket_office> list = new My_Linked_List<>();
        String[] namesOfDays = new String[]{
                "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
        };
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int i = 0; i < size; i++) {
        	final Random random = new Random();
        	int sits, num, sits_a;
        	Ticket_office test = new Ticket_office();
            My_Data now = new My_Data();
            sits = (int) (Math.random() * 55 + 10);
            sits_a = (int) (Math.random() * 10 + 10);
            num = (int) (Math.random() * 999 + 1);
            b = AlphaNumericString.charAt((int) (Math.random() * 25));
            c = AlphaNumericString.charAt((int) (Math.random() * 25));
            StringBuilder numberGenerator = new StringBuilder();
            test.set_total_number_of_sits(sits);
            test.set_number_of_seats_available(sits_a);

            final int millisInDay = 24 * 60 * 60 * 1000;
            Time time = new Time((long) random.nextInt(millisInDay));

            now.setHours(time.getHours());
            now.setMinutes(time.getMinutes());

            test.set_departure(now);

            numberGenerator.append(num);
            numberGenerator.append(b);
            numberGenerator.append(c);

            test.set_flight_number(numberGenerator.toString());
            test.set_days(namesOfDays[(int) (Math.random() * 6)]);
            list.add(test);
        }
        return list;
    }
}
