package ua.khpi.oop.lab01;

public class Main {
    public static void main(String[] args) {
        System.out.println("Системний аналіз предметної галузі: Спортивні секції");

        SportSection boxingSection = new SportSection("Секція Боксу ХПІ", "Бокс", "Спортивний зал №3");
        Coach coach = new Coach("Іванов І.І.", "Бокс", 10);
        Student student = new Student("Артем Колісниченко", "КН-924в-05", 2);
        Schedule schedule = new Schedule("Понеділок", "16:00", 90);

        System.out.println(boxingSection);
        System.out.println(coach);
        System.out.println(student);
        System.out.println(schedule);

        System.out.println("\nДемонстрація методів");

        System.out.println(boxingSection.getDetails());
        System.out.println("Тренер досвідчений? " + coach.isExperienced());
        schedule.printTime();
        student.enroll(boxingSection);
    }
}