# Лабораторна робота №8

## Тема

Файлове введення-виведення, серіалізація та винятки в Java.

## Варіант

Варіант 5 — засоби командної роботи над проєктами.

## Опис

У роботі реалізовано простий застосунок для обліку елементів командної роботи над проєктом.

Класи предметної області:

- `TaskCard` — картка завдання;
- `BugReport` — звіт про помилку;
- `ReviewNote` — примітка до рев'ю.

Клас-контейнер:

- `ProjectWorkspace`.

Клас для роботи з файлами:

- `WorkspaceFileManager`.

Користувацький виняток:

- `InvalidWorkspaceDataException`.

## Текстовий формат

Кожен запис зберігається в один рядок. Поля розділені символом `;`.

Формат:

```text
TASK;id;title;assignee;commentsCount
BUG;id;severity;assignee;commentsCount
REVIEW;id;author;text;commentsCount
```

Приклад:

```text
TASK;TASK-1;Створити сторінку входу;Колісниченко Артем;2
BUG;BUG-101;Висока;Іван Петренко;1
REVIEW;NOTE-1;Артем;Код потребує невеликих виправлень;3
```

## Що реалізовано

- додавання об'єктів у контейнер;
- перегляд усіх записів;
- пошук за ідентифікатором;
- збереження у текстовий файл;
- читання з текстового файлу;
- серіалізація у бінарний файл;
- десеріалізація з бінарного файлу;
- користувацький виняток для некоректних даних;
- JUnit тести;
- UML-діаграма.

## Структура проєкту

```text
Lab08
├── pom.xml
├── README.md
├── REPORT.md
├── requirements.md
├── docs
│   └── uml.puml
└── src
    ├── main
    │   └── java
    │       └── ua/khpi/oop/lab08
    │           ├── demo
    │           ├── exception
    │           ├── model
    │           ├── persistence
    │           └── service
    └── test
        └── java
            └── ua/khpi/oop/lab08
```

## Запуск програми

```bash
mvn exec:java -Dexec.mainClass="ua.khpi.oop.lab08.demo.Main"
```

Або запустити `Main.java` через IntelliJ IDEA.

## Запуск тестів

```bash
mvn test
```

## Результат роботи

Після запуску створюються файли:

```text
build/lab08/workspace.txt
build/lab08/workspace.bin
build/lab08/broken-workspace.txt
```
