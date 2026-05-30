package ua.khpi.oop.lab01;

public class Schedule {
    private String dayOfWeek;
    private String time;

    public Schedule(String dayOfWeek, String time) {
        this.dayOfWeek = dayOfWeek;
        this.time = time;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return dayOfWeek + " о " + time;
    }
}