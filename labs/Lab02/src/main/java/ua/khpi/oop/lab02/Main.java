package ua.khpi.oop.lab02;

public class Main {
    public static void main(String[] args) {
        SportsClub club = new SportsClub("ХПІ Спорт");

        Coach coach = new Coach("Іванов І.І.", "Бокс");
        Schedule schedule = new Schedule("Понеділок", "16:00");
        SportSection section = new SportSection("Секція Боксу ХПІ", coach, schedule);

        Student student = new Student("Артем Колісниченко");

        club.addSection(section);
        club.registerStudent(student);

        club.enrollStudent(student, section, "15.09.2026");

        club.printClubStats();
    }
}