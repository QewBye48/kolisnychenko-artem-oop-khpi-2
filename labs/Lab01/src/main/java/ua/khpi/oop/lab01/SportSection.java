package ua.khpi.oop.lab01;

import java.util.Objects;

public class SportSection {
    private String sectionName;
    private String sportType;
    private String location;

    public SportSection() {
    }

    public SportSection(String sectionName, String sportType, String location) {
        this.sectionName = sectionName;
        this.sportType = sportType;
        this.location = location;
    }

    public String getSectionName() { return sectionName; }
    public void setSectionName(String sectionName) { this.sectionName = sectionName; }

    public String getSportType() { return sportType; }
    public void setSportType(String sportType) { this.sportType = sportType; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SportSection)) return false;
        SportSection that = (SportSection) o;
        return Objects.equals(sectionName, that.sectionName) &&
                Objects.equals(sportType, that.sportType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sectionName, sportType);
    }

    @Override
    public String toString() {
        return String.format("SportSection [Name='%s', Type='%s', Hall='%s']",
                sectionName, sportType, location);
    }
}