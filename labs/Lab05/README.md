# Лабораторна робота №5

## Тема

Успадкування в Java.

## Варіант

Варіант 5 — міська інфраструктура.

## Мета роботи

Навчитися будувати просту ієрархію класів у Java, використовувати успадкування, конструктори, `super(...)`, `@Override`, `final`, а також виконати JOL-дослідження структури об'єкта.

## Ієрархія класів

Основна ієрархія:

```text
Building -> PublicBuilding -> EducationalBuilding -> UniversityCampusBuilding
```

Додаткове відгалуження:

```text
PublicBuilding -> MedicalBuilding
```

## Опис класів

### `Building`

Базовий клас, який описує звичайну будівлю.

Поля:

- `address` — адреса будівлі;
- `yearBuilt` — рік побудови.

### `PublicBuilding`

Клас громадської будівлі. Є різновидом `Building`.

Додає поле:

- `visitorCapacity` — кількість відвідувачів.

### `EducationalBuilding`

Клас навчальної будівлі. Є різновидом `PublicBuilding`.

Додає поле:

- `classroomsCount` — кількість аудиторій.

### `UniversityCampusBuilding`

Клас університетського корпусу. Є різновидом `EducationalBuilding`.

Додає поле:

- `facultyName` — назва факультету.

Клас оголошено як `final`.

### `MedicalBuilding`

Клас медичної будівлі. Є окремим різновидом `PublicBuilding`.

Додає поле:

- `doctorsCount` — кількість лікарів.

## Що реалізовано

У роботі реалізовано:

- ієрархію класів глибиною 4 рівні;
- додаткове відгалуження в ієрархії;
- власний стан у кожному класі;
- конструктори для всіх класів;
- виклик `super(...)`;
- перевизначення методу `description()` через `@Override`;
- використання `final`;
- клас `Main` для демонстрації роботи;
- клас `JolMain` для JOL-дослідження;
- тести TestNG для кожного класу.

## Запуск програми

Основний запуск:

```bash
mvn exec:java -Dexec.mainClass="ua.khpi.oop.lab05.Main"
```

Або через IntelliJ IDEA: запустити файл `Main.java`.

## Запуск JOL

```bash
mvn exec:java -Dexec.mainClass="ua.khpi.oop.lab05.JolMain"
```

Або через IntelliJ IDEA: запустити файл `JolMain.java`.

## Запуск тестів

```bash
mvn test
```

Також тести можна запустити через Maven у IntelliJ IDEA:

```text
Maven -> Lab05 -> Lifecycle -> test
```

## Приклад результату роботи Main

```text
Building [address=Харків, проспект Науки, 10, yearBuilt=1980]
Building [address=Харків, вулиця Сумська, 20, yearBuilt=1995], visitorCapacity=300
Building [address=Харків, вулиця Кирпичова, 2, yearBuilt=1965], visitorCapacity=500, classroomsCount=25
Building [address=Харків, вулиця Кирпичова, 2, yearBuilt=1965], visitorCapacity=500, classroomsCount=25, facultyName=Комп'ютерні науки
Building [address=Харків, вулиця Пушкінська, 15, yearBuilt=2005], visitorCapacity=200, doctorsCount=40
```

## JOL-дослідження

Для JOL-дослідження використано клас `UniversityCampusBuilding`.

У виводі JOL видно, що один об'єкт містить поля всіх рівнів ієрархії:

- `Building.yearBuilt`;
- `Building.address`;
- `PublicBuilding.visitorCapacity`;
- `EducationalBuilding.classroomsCount`;
- `UniversityCampusBuilding.facultyName`.

Розмір екземпляра становить 32 bytes.

Це показує, що під час успадкування об'єкт дочірнього класу містить як власні поля, так і поля батьківських класів.

## Висновок

У лабораторній роботі було створено просту ієрархію класів для міської інфраструктури. Кожен клас додає власний стан, тому ієрархія не є штучною. Було використано `extends`, `super(...)`, `@Override` та `final`. Також було виконано JOL-дослідження, яке показало, що об'єкт дочірнього класу залишається одним об'єктом у пам'яті JVM, але містить поля всіх рівнів успадкування.