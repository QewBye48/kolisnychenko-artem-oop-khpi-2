package ua.khpi.oop.lab01;

import java.util.Objects;

public class Coach {
    private final String fullName;
    private final String specialization;
    private final int experienceYears;

    public Coach(String fullName, String specialization, int experienceYears) {
        if (fullName == null || fullName.isEmpty()) {
            throw new IllegalArgumentException("fullName cannot be null");
        }
        this.fullName = fullName;
        this.specialization = specialization;
        this.experienceYears = experienceYears;
    }

    public String getFullName() {
        return fullName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public boolean isExperienced() {
        return experienceYears >= 5;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coach coach = (Coach) o;
        return experienceYears == coach.experienceYears &&
                Objects.equals(fullName, coach.fullName) &&
                Objects.equals(specialization, coach.specialization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, specialization, experienceYears);
    }

    @Override
    public String toString() {
        return "Coach{" +
                "fullName='" + fullName + '\'' +
                ", specialization='" + specialization + '\'' +
                ", experienceYears=" + experienceYears +
                '}';
    }
}