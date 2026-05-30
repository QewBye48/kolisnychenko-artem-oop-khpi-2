package ua.khpi.oop.lab02;

import java.util.Objects;

public class Coach {
    private final String fullName;
    private final String specialization;
    private final int experienceYears;

    public Coach(String fullName, String specialization, int experienceYears) {
        if (fullName == null || fullName.isEmpty()) {
            throw new IllegalArgumentException("ПІБ тренера не може бути порожнім");
        }
        this.fullName = fullName;
        this.specialization = specialization;
        this.experienceYears = experienceYears;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coach)) return false;
        Coach coach = (Coach) o;
        return Objects.equals(fullName, coach.fullName);
    }

    @Override
    public int hashCode() { return Objects.hash(fullName); }

    @Override
    public String toString() {
        return String.format("Тренер [%s, Спеціалізація: %s, Стаж: %d років]",
                fullName, specialization, experienceYears);
    }
}