package ua.khpi.oop.lab01;

import java.util.Objects;

public class Schedule {
    private final String dayOfWeek;
    private final String startTime;
    private final int durationMinutes;

    public Schedule(String dayOfWeek, String startTime, int durationMinutes) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.durationMinutes = durationMinutes;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public String getStartTime() {
        return startTime;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    // Змістовний метод
    public void printTime() {
        System.out.println("Заняття у " + dayOfWeek + " о " + startTime + " (тривалість: " + durationMinutes + " хв)");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return durationMinutes == schedule.durationMinutes &&
                Objects.equals(dayOfWeek, schedule.dayOfWeek) &&
                Objects.equals(startTime, schedule.startTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dayOfWeek, startTime, durationMinutes);
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "dayOfWeek='" + dayOfWeek + '\'' +
                ", startTime='" + startTime + '\'' +
                ", durationMinutes=" + durationMinutes +
                '}';
    }
}