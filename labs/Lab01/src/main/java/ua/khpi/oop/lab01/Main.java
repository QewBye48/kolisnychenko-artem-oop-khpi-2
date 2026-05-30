package ua.khpi.oop.lab01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Coach coach = new Coach("Володимир Кличко", "Бокс");
        Schedule schedule = new Schedule("Понеділок та Середа", "18:00");
        SportSection section = new SportSection("Університетський бокс", coach, schedule);

        System.out.print("Введіть ім'я студента: ");
        String name = scanner.nextLine();

        Student student = new Student(name);

        while (true) {
            System.out.println("\n ГОЛОВНЕ МЕНЮ ");
            System.out.println("1 - Інформація про секцію");
            System.out.println("2 - Інформація про тренера");
            System.out.println("3 - Дані студента");
            System.out.println("0 - Вихід");
            System.out.print("Оберіть дію: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> System.out.println(section);
                case 2 -> System.out.println(coach);
                case 3 -> System.out.println(student);
                case 0 -> {
                    System.out.println("Роботу завершено.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Невірний вибір");
            }
        }
    }
}