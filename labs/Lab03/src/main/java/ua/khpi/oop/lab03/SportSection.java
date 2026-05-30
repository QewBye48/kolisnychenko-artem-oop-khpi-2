package ua.khpi.oop.lab03;

import java.util.Objects;

public class SportSection {
    private final String sectionName;
    private final String sportType;
    private final String location;
    private boolean openForRegistration;

    public SportSection(String sectionName, String sportType, String location) {
        if (sectionName == null || sectionName.isEmpty()) {
            throw new IllegalArgumentException("Назва секції не може бути порожньою");
        }
        this.sectionName = sectionName;
        this.sportType = sportType;
        this.location = location;
        this.openForRegistration = true;
    }

    public String getSectionName() { return sectionName; }
    public boolean isOpenForRegistration() { return openForRegistration; }

    public void setRegistrationStatus(boolean status) {
        this.openForRegistration = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SportSection)) return false;
        SportSection that = (SportSection) o;
        return Objects.equals(sectionName, that.sectionName);
    }

    @Override
    public int hashCode() { return Objects.hash(sectionName); }

    @Override
    public String toString() {
        return String.format("Секція [Назва='%s', Вид='%s', Статус відкриття=%b]",
                sectionName, sportType, openForRegistration);
    }
}