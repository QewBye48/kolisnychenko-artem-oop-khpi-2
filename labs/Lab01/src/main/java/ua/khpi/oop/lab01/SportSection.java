package ua.khpi.oop.lab01;

import java.util.Objects;

public class SportSection {
    private final String sectionName;
    private final String sportType;
    private final String location;

    public SportSection(String sectionName, String sportType, String location) {
        if (sectionName == null || sectionName.isEmpty()) {
            throw new IllegalArgumentException("sectionName cannot be null or empty");
        }
        this.sectionName = sectionName;
        this.sportType = sportType;
        this.location = location;
    }

    public String getSectionName() {
        return sectionName;
    }

    public String getSportType() {
        return sportType;
    }

    public String getLocation() {
        return location;
    }

    // Той самий "змістовний" метод для діаграми
    public String getDetails() {
        return String.format("Секція: %s (%s), Місце: %s", sectionName, sportType, location);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SportSection that = (SportSection) o;
        return Objects.equals(sectionName, that.sectionName) &&
                Objects.equals(sportType, that.sportType) &&
                Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sectionName, sportType, location);
    }

    @Override
    public String toString() {
        return "SportSection{" +
                "sectionName='" + sectionName + '\'' +
                ", sportType='" + sportType + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}