package ua.khpi.oop.lab07.demo;

import ua.khpi.oop.lab07.contracts.Assignable;
import ua.khpi.oop.lab07.contracts.Commentable;
import ua.khpi.oop.lab07.model.BugReport;
import ua.khpi.oop.lab07.model.ReviewNote;
import ua.khpi.oop.lab07.model.TaskCard;

public class Main {
    public static void main(String[] args) {
        TaskCard task = new TaskCard(
                "Створити сторінку входу",
                "Додати просту форму авторизації"
        );

        BugReport bug = new BugReport(
                "BUG-101",
                "Висока"
        );

        ReviewNote note = new ReviewNote(
                "Артем",
                "Код потребує невеликих виправлень"
        );

        System.out.println("Обробка об'єктів через інтерфейс Assignable");

        Assignable[] assignableItems = {
                task,
                bug
        };

        for (Assignable item : assignableItems) {
            System.out.println(item.assignTo("Колісниченко Артем"));
        }

        System.out.println();
        System.out.println("Обробка об'єктів через інтерфейс Commentable");

        Commentable[] commentableItems = {
                task,
                bug,
                note
        };

        for (Commentable item : commentableItems) {
            System.out.println(item.addComment("Перевірено куратором проєкту"));
        }

        System.out.println();
        System.out.println("Один об'єкт через два різні інтерфейси");

        Assignable assignableView = task;
        Commentable commentableView = task;

        System.out.println(assignableView.assignTo("Іван Петренко"));
        System.out.println(commentableView.addComment("Завдання було перепризначено"));

        System.out.println();
        System.out.println("Підсумкова інформація");

        System.out.println(task.getInfo());
        System.out.println(bug.getInfo());
        System.out.println(note.getInfo());
    }
}