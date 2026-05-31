package ua.khpi.oop.lab04;

public class Schedule {
    private String dayOfWeek;
    private String time;

    public Schedule(String dayOfWeek, String time) {
        this.dayOfWeek = dayOfWeek;
        this.time = time;
    }

    @Override
    public String toString() {
        return dayOfWeek + " о " + time;
    }
}