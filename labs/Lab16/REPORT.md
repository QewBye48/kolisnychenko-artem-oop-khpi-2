# Звіт до лабораторної роботи №16

## Тема

Автоматизована збірка, тестування і CI для Java-проєкту.

## Варіант

Варіант 5 — нормалізація значень.

## Мета роботи

Метою лабораторної роботи є набуття практичних навичок підготовки Java-проєкту до автоматизованої збірки, тестування та безперервної інтеграції.

Також у роботі потрібно показати взаємодію Java-коду з native-кодом через JNI.

## Суть задачі

Потрібно реалізувати нормалізацію масиву чисел до діапазону `0..1`.

Операція реалізована у двох версіях:

* звичайною мовою Java;
* мовою C++ через JNI.

Формула нормалізації:

```text
(x - min) / (max - min)
```

Якщо всі елементи масиву однакові, програма повертає масив нулів, щоб уникнути ділення на нуль.

## Структура проєкту

Основні файли проєкту:

```text
src/main/java/ua/khpi/oop/lab16/Main.java
src/main/java/ua/khpi/oop/lab16/JavaNormalizer.java
src/main/java/ua/khpi/oop/lab16/NativeNormalizer.java
src/main/java/ua/khpi/oop/lab16/NormalizerService.java

src/test/java/ua/khpi/oop/lab16/NormalizerTest.java

native/native_normalizer.cpp
native-headers/ua_khpi_oop_lab16_NativeNormalizer.h

.github/workflows/ci.yml
pom.xml
README.md
REPORT.md
```

## Java-реалізація

Клас `JavaNormalizer` виконує нормалізацію масиву засобами Java.

Спочатку знаходяться мінімальне і максимальне значення, після чого кожен елемент перетворюється за формулою:

```text
(x - min) / (max - min)
```

## Native-реалізація

Клас `NativeNormalizer` містить native-метод:

```java
public native double[] normalize(double[] values);
```

Реалізація цього методу знаходиться у файлі:

```text
native/native_normalizer.cpp
```

Native-код виконує ту саму операцію нормалізації, що і Java-код.

## JNI

Для зв’язку Java з C++ використовується JNI.

Header-файл генерується командою:

```bash
javac -h native-headers -d target/classes src/main/java/ua/khpi/oop/lab16/NativeNormalizer.java
```

Native-бібліотека завантажується в Java-класі так:

```java
System.loadLibrary("nativenormalizer");
```

Для запуску потрібно вказати шлях до бібліотеки:

```text
-Djava.library.path=target/native
```

## Тестування

У проєкті реалізовано модульні тести `NormalizerTest`.

Тести перевіряють:

* коректність Java-реалізації;
* коректність native-реалізації;
* однаковість результатів Java та native;
* випадок, коли всі значення однакові;
* некоректні вхідні дані для Java-реалізації.

## GitHub Actions

Для автоматичної перевірки створено workflow:

```text
.github/workflows/ci.yml
```

Workflow виконує такі кроки:

* отримує код репозиторію;
* встановлює JDK 21;
* генерує JNI header;
* збирає native-бібліотеку;
* компілює Java-проєкт;
* запускає тести.

## Технічна проблема

Під час запуску можлива помилка:

```text
UnsatisfiedLinkError
```

Вона виникає, якщо JVM не знаходить native-бібліотеку.

Для виправлення потрібно перевірити:

* чи зібрана бібліотека;
* чи вона лежить у `target/native`;
* чи правильно вказано `java.library.path`;
* чи назва бібліотеки відповідає `System.loadLibrary("nativenormalizer")`.

## Висновок

У лабораторній роботі реалізовано Java-проєкт із підтримкою JNI та автоматизованої перевірки через GitHub Actions.
Операцію нормалізації значень виконано у двох варіантах: Java та C++ через JNI.
Модульні тести підтверджують, що обидві реалізації повертають однакові результати для однакових вхідних даних.
CI workflow дозволяє автоматично перевіряти збірку Java-проєкту, native-бібліотеки та запуск тестів після змін у репозиторії.
