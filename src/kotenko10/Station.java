package ua.khpi.oop.kotenko10;

import java.io.Serializable;

public class Station implements Serializable {

    private String station_name;
    private My_Data time;

    private static final long serialVersionUID = 1L;

    public Station(Station readObject) {
        this.station_name = readObject.station_name;
        this.time = readObject.time;
    }

    public Station() {
        time = new My_Data();
    }

    public String getName() {
        return station_name;
    }

    public void setName(String str) {
        this.station_name = str;
    }

    public My_Data getTime() {
        return time;
    }

    public void setTime(My_Data time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "\nName of station: " + station_name +
                "\nTime of arrival: " + time.toString();
    }

}


