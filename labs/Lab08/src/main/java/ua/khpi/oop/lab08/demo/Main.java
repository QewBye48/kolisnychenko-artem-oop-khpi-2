package ua.khpi.oop.lab08.demo;

import ua.khpi.oop.lab08.exception.InvalidWorkspaceDataException;
import ua.khpi.oop.lab08.model.BugReport;
import ua.khpi.oop.lab08.model.ReviewNote;
import ua.khpi.oop.lab08.model.TaskCard;
import ua.khpi.oop.lab08.persistence.WorkspaceFileManager;
import ua.khpi.oop.lab08.service.ProjectWorkspace;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        Path textPath = Path.of("build", "lab08", "workspace.txt");
        Path binaryPath = Path.of("build", "lab08", "workspace.bin");
        Path brokenPath = Path.of("build", "lab08", "broken-workspace.txt");

        WorkspaceFileManager fileManager = new WorkspaceFileManager();

        try {
            ProjectWorkspace workspace = new ProjectWorkspace();

            workspace.addTask(new TaskCard(
                    "TASK-1",
                    "Створити сторінку входу",
                    "Колісниченко Артем",
                    2
            ));

            workspace.addBug(new BugReport(
                    "BUG-101",
                    "Висока",
                    "Іван Петренко",
                    1
            ));

            workspace.addReviewNote(new ReviewNote(
                    "NOTE-1",
                    "Артем",
                    "Код потребує невеликих виправлень",
                    3
            ));

            System.out.println("Початковий робочий простір");
            System.out.println(workspace.showAll());

            System.out.println("Пошук завдання TASK-1:");
            workspace.findTaskById("TASK-1").ifPresent(System.out::println);

            fileManager.saveAsText(workspace, textPath);
            System.out.println("\nДані збережено у текстовий файл: " + textPath);

            ProjectWorkspace loadedFromText = fileManager.loadFromText(textPath);
            System.out.println("\nДані, відновлені з текстового файлу");
            System.out.println(loadedFromText.showAll());

            fileManager.serialize(loadedFromText, binaryPath);
            System.out.println("Дані серіалізовано у бінарний файл: " + binaryPath);

            ProjectWorkspace loadedFromBinary = fileManager.deserialize(binaryPath);
            System.out.println("\nДані, відновлені з бінарного файлу");
            System.out.println(loadedFromBinary.showAll());

            System.out.println("Демонстрація помилкової ситуації");
            Files.createDirectories(brokenPath.getParent());
            Files.writeString(
                    brokenPath,
                    "TASK;ONLY_TWO_FIELDS\n",
                    StandardCharsets.UTF_8
            );

            fileManager.loadFromText(brokenPath);

        } catch (InvalidWorkspaceDataException exception) {
            System.out.println("Помилка даних робочого простору: " + exception.getMessage());
        } catch (IOException exception) {
            System.out.println("Помилка введення/виведення: " + exception.getMessage());
        } catch (ClassNotFoundException exception) {
            System.out.println("Помилка десеріалізації: " + exception.getMessage());
        }
    }
}