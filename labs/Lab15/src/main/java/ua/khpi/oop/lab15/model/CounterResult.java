package ua.khpi.oop.lab15.model;

public class CounterResult {
    private final String scenarioName;
    private final int threadCount;
    private final int operationsPerThread;
    private final int expectedValue;
    private final int actualValue;
    private final long durationMillis;

    public CounterResult(
            String scenarioName,
            int threadCount,
            int operationsPerThread,
            int expectedValue,
            int actualValue,
            long durationMillis
    ) {
        this.scenarioName = scenarioName;
        this.threadCount = threadCount;
        this.operationsPerThread = operationsPerThread;
        this.expectedValue = expectedValue;
        this.actualValue = actualValue;
        this.durationMillis = durationMillis;
    }

    public String getScenarioName() {
        return scenarioName;
    }

    public int getThreadCount() {
        return threadCount;
    }

    public int getOperationsPerThread() {
        return operationsPerThread;
    }

    public int getExpectedValue() {
        return expectedValue;
    }

    public int getActualValue() {
        return actualValue;
    }

    public long getDurationMillis() {
        return durationMillis;
    }

    public int getLostUpdates() {
        return expectedValue - actualValue;
    }

    public boolean isCorrect() {
        return expectedValue == actualValue;
    }

    @Override
    public String toString() {
        return scenarioName + "\n" +
                "Потоків: " + threadCount + "\n" +
                "Операцій на потік: " + operationsPerThread + "\n" +
                "Очікуваний результат: " + expectedValue + "\n" +
                "Фактичний результат: " + actualValue + "\n" +
                "Втрачено оновлень: " + getLostUpdates() + "\n" +
                "Час виконання: " + durationMillis + " мс\n" +
                "Результат коректний: " + (isCorrect() ? "так" : "ні");
    }
}