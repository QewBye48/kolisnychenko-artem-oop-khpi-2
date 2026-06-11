# Lab 16

Автоматизована збірка, тестування і CI для Java-проєкту.

Варіант 5 — нормалізація значень.

## Суть задачі

У роботі реалізовано нормалізацію масиву чисел до діапазону `0..1`.

Операція виконується у двох версіях:

* Java-реалізація;
* native-реалізація мовою C++ через JNI.

Формула нормалізації:

```text
(x - min) / (max - min)
```

Якщо всі значення однакові, результатом є масив нулів.

## Що реалізовано

У проєкті є такі основні файли:

* `JavaNormalizer.java` — Java-реалізація нормалізації;
* `NativeNormalizer.java` — клас із native-методом;
* `NormalizerService.java` — сервіс для запуску Java та native-реалізацій;
* `Main.java` — демонстраційний запуск;
* `native_normalizer.cpp` — C++ реалізація через JNI;
* `NormalizerTest.java` — модульні тести;
* `ci.yml` — GitHub Actions workflow.

## Запуск Java-проєкту

```bash
mvn compile
```

## Генерація JNI header

```bash
javac -h native-headers -d target/classes src/main/java/ua/khpi/oop/lab16/NativeNormalizer.java
```

## Збірка native-бібліотеки на Windows

```powershell
mkdir target\native

clang++ -std=c++17 -shared `
-I"$env:JAVA_HOME\include" `
-I"$env:JAVA_HOME\include\win32" `
-Inative-headers `
native\native_normalizer.cpp `
-o target\native\nativenormalizer.dll
```

## Збірка native-бібліотеки на Linux

```bash
mkdir -p target/native

clang++ -std=c++17 -shared -fPIC \
-I"$JAVA_HOME/include" \
-I"$JAVA_HOME/include/linux" \
-Inative-headers \
native/native_normalizer.cpp \
-o target/native/libnativenormalizer.so
```

## Запуск тестів

```bash
mvn test
```

## Запуск Main

У IntelliJ IDEA в VM options потрібно вказати:

```text
-Djava.library.path=target/native
```

Після цього можна запускати клас:

```text
ua.khpi.oop.lab16.Main
```

## GitHub Actions

Workflow запускається на:

* `push`;
* `pull_request`.

CI виконує такі кроки:

* checkout репозиторію;
* встановлення JDK 21;
* генерація JNI header;
* збирання native-бібліотеки;
* збирання Java-проєкту;
* запуск тестів.

## Висновок

У роботі показано інтеграцію Java-коду з native-кодом через JNI.

Java- та native-реалізації виконують одну й ту саму операцію нормалізації масиву, а тести перевіряють однаковість результатів.
