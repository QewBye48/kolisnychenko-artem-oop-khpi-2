package ua.khpi.oop.lab03;

public class Main {
    public static void main(String[] args) {
        System.out.println("Еволюція моделі: Спортивний Клуб (ЛР2)");

        SportsClub polytechClub = new SportsClub("Спортивний Клуб ХПІ", "вул. Весни 12");

        SportSection boxing = new SportSection("Секція Боксу", "Бокс", "Зал №3");
        Student student = new Student("Колісніченко Артем", "КН-924в-05", 2);

        polytechClub.addSection(boxing);
        polytechClub.registerStudent(student);

        System.out.println(polytechClub);

        System.out.println("\nПроцес запису студента");
        Enrollment entry = polytechClub.enrollStudent(student, boxing, "2026-05-30");
        System.out.println(entry);
        System.out.println(polytechClub);

        System.out.println("\nСпроба запису на закриту секцію");
        boxing.setRegistrationStatus(false);
        try {
            polytechClub.enrollStudent(student, boxing, "2026-05-31");
        } catch (IllegalStateException e) {
            System.out.println("Перехоплено очікуване обмеження: " + e.getMessage());
        }
    }
}