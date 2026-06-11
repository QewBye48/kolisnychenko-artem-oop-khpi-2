package ua.khpi.oop.lab15.demo;

import ua.khpi.oop.lab15.model.CounterResult;
import ua.khpi.oop.lab15.model.SafeSharedCounter;
import ua.khpi.oop.lab15.model.UnsafeSharedCounter;
import ua.khpi.oop.lab15.service.CounterService;

public class Main {
    private static final int THREAD_COUNT = 4;
    private static final int OPERATIONS_PER_THREAD = 100_000;

    public static void main(String[] args) {
        CounterService service = new CounterService();

        int totalOperations = THREAD_COUNT * OPERATIONS_PER_THREAD;

        System.out.println("Лабораторна робота №15");
        System.out.println("Варіант 5 — лічильник подій");
        System.out.println("Кількість потоків: " + THREAD_COUNT);
        System.out.println("Операцій на потік: " + OPERATIONS_PER_THREAD);
        System.out.println("Очікуваний результат: " + totalOperations);
        System.out.println();

        CounterResult sequentialResult = service.runSequentialScenario(
                "Послідовне виконання",
                new SafeSharedCounter(),
                totalOperations
        );

        System.out.println(service.buildTextReport(sequentialResult));

        try {
            CounterResult unsafeResult = service.runConcurrentScenario(
                    "Паралельне виконання без синхронізації",
                    new UnsafeSharedCounter(),
                    THREAD_COUNT,
                    OPERATIONS_PER_THREAD
            );

            System.out.println(service.buildTextReport(unsafeResult));

            CounterResult safeResult = service.runConcurrentScenario(
                    "Паралельне виконання з synchronized",
                    new SafeSharedCounter(),
                    THREAD_COUNT,
                    OPERATIONS_PER_THREAD
            );

            System.out.println(service.buildTextReport(safeResult));

        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
            System.out.println("Головний потік було перервано");
        }
    }
}