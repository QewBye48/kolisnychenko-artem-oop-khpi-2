package ua.khpi.oop.lab02;

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
    public int hashCode() { return Objects.hash(dayOfWeek, startTime, durationMinutes); }

    @Override
    public String toString() {
        return String.format("Розклад [%s о %s, %d хв]", dayOfWeek, startTime, durationMinutes);
    }
}