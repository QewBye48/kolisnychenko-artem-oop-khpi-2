package ua.khpi.oop.lab01;

import java.util.Objects;

public class Coach {
    private String fullName;
    private String specialization;
    private int experienceYears;

    public Coach() {
    }

    public Coach(String fullName, String specialization, int experienceYears) {
        this.fullName = fullName;
        this.specialization = specialization;
        this.experienceYears = experienceYears;
    }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    public int getExperienceYears() { return experienceYears; }
    public void setExperienceYears(int experienceYears) { this.experienceYears = experienceYears; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coach)) return false;
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
        return String.format("Coach [Name='%s', Specialization='%s', Experience=%d years]",
                fullName, specialization, experienceYears);
    }
}