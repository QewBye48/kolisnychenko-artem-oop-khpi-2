package ua.khpi.oop.lab01;

import java.util.Objects;

public class Coach {
    private String fullName;
    private String sportType;

    public Coach(String fullName, String sportType) {
        this.fullName = fullName;
        this.sportType = sportType;
    }

    public String getFullName() {
        return fullName;
    }

    public String getSportType() {
        return sportType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coach coach = (Coach) o;
        return Objects.equals(fullName, coach.fullName) && Objects.equals(sportType, coach.sportType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, sportType);
    }

    @Override
    public String toString() {
        return "Тренер: " + fullName + " (Спорт: " + sportType + ")";
    }
}