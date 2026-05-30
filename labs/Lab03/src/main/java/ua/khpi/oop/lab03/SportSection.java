package ua.khpi.oop.lab03;

public class SportSection {
    private String name;
    private Coach coach;
    private Schedule schedule;

    public SportSection(String name, Coach coach, Schedule schedule) {
        this.name = name;
        this.coach = coach;
        this.schedule = schedule;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Секція: " + name + " [" + coach.toString() + ", " + schedule.toString() + "]";
    }
}