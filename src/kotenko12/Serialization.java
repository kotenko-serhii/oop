package ua.khpi.oop.kotenko12;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class Serialization {

    public static <E> void LongTermPersistenceWrite(My_Linked_List<E> object, String path) throws FileNotFoundException {
        XMLEncoder encoder = new XMLEncoder(
                new BufferedOutputStream(
                        new FileOutputStream(path)));
        for (E elem : object) {
            encoder.writeObject(elem);
        }
        encoder.close();
    }

    @SuppressWarnings("unchecked")
    public static <E extends Ticket_office> My_Linked_List<E> LongTermPersistenceRead(String path) throws FileNotFoundException {
        boolean test = true;
        My_Linked_List<E> object = new My_Linked_List<>();
        try {
            XMLDecoder decoder = new XMLDecoder(
                    new BufferedInputStream(
                            new FileInputStream(path)));
            while (test) {
                try {
                    E elem = ((E) decoder.readObject());
                    object.add(elem);
                } catch (Exception e) {
                    test = false;
                }
            }
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        return object;
    }

    public static <E extends Ticket_office> void ObjectWrite(My_Linked_List<E> object, String path) throws IOException, ClassNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(object);
        objectOutputStream.close();
    }

    @SuppressWarnings("unchecked")
    public static <E> My_Linked_List<E> ObjectRead(My_Linked_List<E> object, String path) throws IOException, ClassNotFoundException {
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            object = (My_Linked_List<E>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (Exception e) {
            System.out.println("Error");
            System.err.println(e.getMessage());
        }
        return object;
    }
}
