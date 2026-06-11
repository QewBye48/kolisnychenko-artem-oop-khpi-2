package ua.khpi.oop.lab01;

public class SportSection {
    private String name;
    private Coach coach;
    private Schedule schedule;

    public SportSection() {
        this.name = "Невідома секція";
    }

    public SportSection(String name, Coach coach, Schedule schedule) {
        this.name = name;
        this.coach = coach;
        this.schedule = schedule;
    }

    public String getName() {
        return name;
    }

    public Coach getCoach() {
        return coach;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    @Override
    public String toString() {
        return "Секція: " + name + "\n" + coach.toString() + "\nРозклад: " + schedule.toString();
    }
}