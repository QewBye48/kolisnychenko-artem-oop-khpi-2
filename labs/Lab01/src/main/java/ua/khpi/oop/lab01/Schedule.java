package ua.khpi.oop.lab01;

import java.util.Objects;

public class Schedule {
    private String dayOfWeek;
    private String startTime;
    private int durationMinutes;

    public Schedule() {
    }

    public Schedule(String dayOfWeek, String startTime, int durationMinutes) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.durationMinutes = durationMinutes;
    }

    public String getDayOfWeek() { return dayOfWeek; }
    public void setDayOfWeek(String dayOfWeek) { this.dayOfWeek = dayOfWeek; }

    public String getStartTime() { return startTime; }
    public void setStartTime(String startTime) { this.startTime = startTime; }

    public int getDurationMinutes() { return durationMinutes; }
    public void setDurationMinutes(int durationMinutes) { this.durationMinutes = durationMinutes; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Schedule)) return false;
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
        return String.format("Schedule [Day=%s, Time=%s, Duration=%d min]",
                dayOfWeek, startTime, durationMinutes);
    }
}