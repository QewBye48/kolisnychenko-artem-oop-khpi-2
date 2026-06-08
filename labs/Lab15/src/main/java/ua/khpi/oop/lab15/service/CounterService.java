package ua.khpi.oop.lab15.service;

import ua.khpi.oop.lab15.model.CounterResult;
import ua.khpi.oop.lab15.model.EventSource;
import ua.khpi.oop.lab15.model.SharedCounter;
import ua.khpi.oop.lab15.threads.CounterTask;

public class CounterService {

    public CounterResult runConcurrentScenario(
            String scenarioName,
            SharedCounter counter,
            int threadCount,
            int operationsPerThread
    ) throws InterruptedException {
        validateParameters(counter, threadCount, operationsPerThread);

        counter.reset();

        Thread[] threads = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            EventSource source = new EventSource("EventSource-" + (i + 1), operationsPerThread);
            CounterTask task = new CounterTask(source, counter);
            threads[i] = new Thread(task, "CounterThread-" + (i + 1));
        }

        long startTime = System.nanoTime();

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        long durationMillis = (System.nanoTime() - startTime) / 1_000_000;

        int expectedValue = threadCount * operationsPerThread;

        return new CounterResult(
                scenarioName,
                threadCount,
                operationsPerThread,
                expectedValue,
                counter.getValue(),
                durationMillis
        );
    }

    public CounterResult runSequentialScenario(
            String scenarioName,
            SharedCounter counter,
            int totalOperations
    ) {
        if (counter == null) {
            throw new IllegalArgumentException("Лічильник не може бути null");
        }
        if (totalOperations < 0) {
            throw new IllegalArgumentException("Кількість операцій не може бути від'ємною");
        }

        counter.reset();

        long startTime = System.nanoTime();

        for (int i = 0; i < totalOperations; i++) {
            counter.increment();
        }

        long durationMillis = (System.nanoTime() - startTime) / 1_000_000;

        return new CounterResult(
                scenarioName,
                1,
                totalOperations,
                totalOperations,
                counter.getValue(),
                durationMillis
        );
    }

    public String buildTextReport(CounterResult result) {
        StringBuilder builder = new StringBuilder();

        builder.append(result.getScenarioName()).append('\n');
        builder.append("Потоків: ").append(result.getThreadCount()).append('\n');
        builder.append("Операцій на потік: ").append(result.getOperationsPerThread()).append('\n');
        builder.append("Очікуваний результат: ").append(result.getExpectedValue()).append('\n');
        builder.append("Фактичний результат: ").append(result.getActualValue()).append('\n');
        builder.append("Втрачено оновлень: ").append(result.getLostUpdates()).append('\n');
        builder.append("Час виконання: ").append(result.getDurationMillis()).append(" мс").append('\n');
        builder.append("Результат коректний: ").append(result.isCorrect() ? "так" : "ні").append('\n');

        return builder.toString();
    }

    private void validateParameters(
            SharedCounter counter,
            int threadCount,
            int operationsPerThread
    ) {
        if (counter == null) {
            throw new IllegalArgumentException("Лічильник не може бути null");
        }
        if (threadCount <= 0) {
            throw new IllegalArgumentException("Кількість потоків має бути додатною");
        }
        if (operationsPerThread < 0) {
            throw new IllegalArgumentException("Кількість операцій не може бути від'ємною");
        }
    }
}