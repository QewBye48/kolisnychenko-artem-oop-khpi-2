# Звіт до лабораторної роботи №12

## Тема роботи

Stream API в Java.

## Варіант

Варіант 5 — медіатека.

## Мета роботи

Метою лабораторної роботи є отримання практичних навичок використання Stream API у Java для обробки колекцій даних.

У роботі потрібно показати фільтрацію, перетворення, сортування, підрахунок, групування та збирання результатів у зручному вигляді.

---

## 1. Опис предметної області

У лабораторній роботі реалізовано просту модель медіатеки.

Медіатека містить фільми, подкасти та епізоди подкастів. Над цими даними виконуються різні операції обробки через Stream API.

У проєкті реалізовано такі класи:

- `Movie` — фільм;
- `Episode` — епізод подкасту;
- `Podcast` — подкаст;
- `MediaLibrary` — сервіс для обробки даних через Stream API;
- `Main` — демонстраційний клас.

---

## 2. Клас `Movie`

Клас `Movie` описує фільм.

Поля класу:

- `title` — назва фільму;
- `genre` — жанр;
- `year` — рік випуску;
- `rating` — рейтинг;
- `durationMinutes` — тривалість у хвилинах.

Ці поля використовуються у stream-операціях для фільтрації, сортування, підрахунку та агрегування.

---

## 3. Клас `Episode`

Клас `Episode` описує епізод подкасту.

Поля класу:

- `title` — назва епізоду;
- `seasonNumber` — номер сезону;
- `episodeNumber` — номер епізоду;
- `durationMinutes` — тривалість епізоду.

---

## 4. Клас `Podcast`

Клас `Podcast` описує подкаст.

Поля класу:

- `title` — назва подкасту;
- `host` — ведучий;
- `topic` — тема;
- `episodes` — список епізодів.

Подкаст містить список епізодів, тому в роботі можна показати використання `flatMap()` для отримання всіх епізодів з усіх подкастів.

---

## 5. Клас `MediaLibrary`

Клас `MediaLibrary` є основним сервісом лабораторної роботи.

Він зберігає:

```java
private final List<Movie> movies;
private final List<Podcast> podcasts;
```

У цьому класі реалізовано методи, які обробляють колекції через Stream API.

Основні методи:

- `getMoviesByGenre(String genre)`;
- `getMovieTitlesSortedByRating()`;
- `getTopMovies(int limit)`;
- `countMoviesByGenre(String genre)`;
- `groupMoviesByGenre()`;
- `countMoviesByGenreMap()`;
- `getAverageMovieRating()`;
- `getLongestMovie()`;
- `getAllEpisodeTitles()`;
- `buildMovieReport()`;
- `getMoviesByGenreImperative(String genre)`.

---

## 6. Використані Stream API операції

У роботі використано такі операції Stream API:

- `filter()` — відбір фільмів за жанром;
- `map()` — перетворення об'єктів у назви;
- `sorted()` — сортування фільмів за рейтингом;
- `count()` — підрахунок кількості фільмів;
- `toList()` — збирання результату у список;
- `collect()` — збирання результату через колектори;
- `groupingBy()` — групування фільмів за жанром;
- `flatMap()` — отримання всіх епізодів з усіх подкастів;
- `max()` — пошук найдовшого фільму;
- `joining()` — побудова текстового звіту.

---

## 7. Приклади stream-методів

Метод фільтрації фільмів за жанром:

```java
public List<Movie> getMoviesByGenre(String genre) {
    return movies.stream()
            .filter(movie -> movie.getGenre().equalsIgnoreCase(genre))
            .toList();
}
```

Метод отримання назв фільмів, відсортованих за рейтингом:

```java
public List<String> getMovieTitlesSortedByRating() {
    return movies.stream()
            .sorted(Comparator.comparingDouble(Movie::getRating).reversed())
            .map(Movie::getTitle)
            .toList();
}
```

Метод групування фільмів за жанром:

```java
public Map<String, List<Movie>> groupMoviesByGenre() {
    return movies.stream()
            .collect(Collectors.groupingBy(Movie::getGenre));
}
```

Метод отримання назв усіх епізодів:

```java
public List<String> getAllEpisodeTitles() {
    return podcasts.stream()
            .flatMap(podcast -> podcast.getEpisodes().stream())
            .map(Episode::getTitle)
            .toList();
}
```

---

## 8. Складніший конвеєр

У роботі реалізовано побудову текстового звіту за фільмами.

```java
public String buildMovieReport() {
    return movies.stream()
            .sorted(Comparator.comparingDouble(Movie::getRating).reversed())
            .map(movie -> movie.getTitle() + " — " + movie.getRating())
            .collect(Collectors.joining("\n"));
}
```

У цьому методі використано сортування, перетворення об'єктів у рядки та об'єднання результату в один текст.

---

## 9. Порівняння імперативного підходу і Stream API

Для порівняння було реалізовано метод пошуку фільмів за жанром через звичайний цикл:

```java
public List<Movie> getMoviesByGenreImperative(String genre) {
    List<Movie> result = new ArrayList<>();

    for (Movie movie : movies) {
        if (movie.getGenre().equalsIgnoreCase(genre)) {
            result.add(movie);
        }
    }

    return result;
}
```

Також є аналогічний метод через Stream API:

```java
public List<Movie> getMoviesByGenre(String genre) {
    return movies.stream()
            .filter(movie -> movie.getGenre().equalsIgnoreCase(genre))
            .toList();
}
```

Stream API краще показує намір програми: потрібно не описувати цикл вручну, а вказати, які саме елементи треба відібрати.

---

## 10. Демонстрація роботи

У класі `Main` створюються тестові дані:

- список фільмів;
- список епізодів;
- список подкастів.

Після цього створюється об'єкт `MediaLibrary`, через який демонструються основні stream-методи:

- фільтрація фільмів за жанром;
- сортування назв фільмів за рейтингом;
- підрахунок фільмів;
- групування за жанром;
- обчислення середнього рейтингу;
- пошук найдовшого фільму;
- отримання назв епізодів;
- побудова текстового звіту;
- порівняння циклу і Stream API.

---

## 11. Тестування

Для перевірки роботи програми були створені тести JUnit Jupiter.

Тестові класи:

- `MediaLibraryTest`;
- `MainTest`.

Тести перевіряють:

- пошук фільмів за жанром;
- сортування назв фільмів за рейтингом;
- підрахунок фільмів за жанром;
- групування фільмів за жанром;
- обчислення середнього рейтингу;
- пошук найдовшого фільму;
- отримання назв усіх епізодів;
- побудову текстового звіту;
- однаковість результатів імперативного підходу і Stream API;
- запуск `Main` без помилок.

---

## 12. Висновок

У ході виконання лабораторної роботи було реалізовано просту медіатеку з використанням Stream API.

Було створено класи `Movie`, `Episode`, `Podcast` та сервіс `MediaLibrary`.

У роботі використано основні можливості Stream API: `filter()`, `map()`, `sorted()`, `count()`, `toList()`, `collect()`, `groupingBy()`, `flatMap()`, `max()` і `joining()`.

Stream API дозволив зробити обробку колекцій коротшою та зрозумілішою. Замість ручного керування циклами програма описує саму дію: відібрати, перетворити, відсортувати, згрупувати або підрахувати дані.