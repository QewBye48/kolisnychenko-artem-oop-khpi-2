package ua.khpi.oop.lab01;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Системний аналіз предметної галузі: Спортивні секції ===");

        // Демонстрация создания объектов через конструкторы
        Coach coach = new Coach("Іванов І.І.", "Бокс", 10);
        SportSection section = new SportSection("Секція Боксу ХПІ", "Бокс", "Спортивний зал №3");
        Student student = new Student("Колісниченко Артем", "КН-924в-05", 2);
        Schedule schedule = new Schedule("Понеділок", "16:00", 90);

        // Вывод данных через переопределенный toString()
        System.out.println(coach);
        System.out.println(section);
        System.out.println(student);
        System.out.println(schedule);
    }
}