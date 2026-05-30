package ua.khpi.oop.lab03;

public class Coach {
    private String fullName;
    private String sportType;

    public Coach(String fullName, String sportType) {
        this.fullName = fullName;
        this.sportType = sportType;
    }

    @Override
    public String toString() {
        return "Тренер: " + fullName + " (Спорт: " + sportType + ")";
    }
}