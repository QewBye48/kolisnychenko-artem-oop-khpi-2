package ua.khpi.oop.lab01;

public class Main {
    public static void main(String[] args) {
        Coach coach = new Coach("Іванов І.І.", "Бокс");
        Schedule schedule = new Schedule("Понеділок", "16:00");
        SportSection section = new SportSection("Секція Боксу ХПІ", coach, schedule);

        Student student = new Student("Артем Колісниченко");

        System.out.println("Інформація про спортивну секцію");
        System.out.println(section);

        System.out.println("\nІнформація про студента");
        System.out.println(student);
    }
}