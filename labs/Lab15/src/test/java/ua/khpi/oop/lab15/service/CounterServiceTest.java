package ua.khpi.oop.lab15.service;

import org.junit.jupiter.api.Test;
import ua.khpi.oop.lab15.model.CounterResult;
import ua.khpi.oop.lab15.model.SafeSharedCounter;
import ua.khpi.oop.lab15.model.UnsafeSharedCounter;

import static org.junit.jupiter.api.Assertions.*;

class CounterServiceTest {

    @Test
    void sequentialScenarioShouldReturnExpectedValue() {
        CounterService service = new CounterService();

        CounterResult result = service.runSequentialScenario(
                "Послідовний тест",
                new SafeSharedCounter(),
                1000
        );

        assertEquals(1, result.getThreadCount());
        assertEquals(1000, result.getOperationsPerThread());
        assertEquals(1000, result.getExpectedValue());
        assertEquals(1000, result.getActualValue());
        assertEquals(0, result.getLostUpdates());
        assertTrue(result.isCorrect());
    }

    @Test
    void synchronizedConcurrentScenarioShouldReturnExpectedValue() throws InterruptedException {
        CounterService service = new CounterService();

        CounterResult result = service.runConcurrentScenario(
                "Синхронізований тест",
                new SafeSharedCounter(),
                4,
                10_000
        );

        assertEquals(4, result.getThreadCount());
        assertEquals(10_000, result.getOperationsPerThread());
        assertEquals(40_000, result.getExpectedValue());
        assertEquals(40_000, result.getActualValue());
        assertEquals(0, result.getLostUpdates());
        assertTrue(result.isCorrect());
    }

    @Test
    void unsafeConcurrentScenarioShouldNotBeUsedAsStrictFailureTest() throws InterruptedException {
        CounterService service = new CounterService();

        CounterResult result = service.runConcurrentScenario(
                "Небезпечний тест",
                new UnsafeSharedCounter(),
                4,
                1000
        );

        assertEquals(4, result.getThreadCount());
        assertEquals(1000, result.getOperationsPerThread());
        assertEquals(4000, result.getExpectedValue());

        assertTrue(result.getActualValue() > 0);
        assertTrue(result.getActualValue() <= result.getExpectedValue());
    }

    @Test
    void buildTextReportShouldContainMainValues() {
        CounterService service = new CounterService();

        CounterResult result = new CounterResult(
                "Тестовий звіт",
                4,
                100,
                400,
                400,
                5
        );

        String report = service.buildTextReport(result);

        assertTrue(report.contains("Тестовий звіт"));
        assertTrue(report.contains("Потоків: 4"));
        assertTrue(report.contains("Операцій на потік: 100"));
        assertTrue(report.contains("Очікуваний результат: 400"));
        assertTrue(report.contains("Фактичний результат: 400"));
        assertTrue(report.contains("Результат коректний: так"));
    }

    @Test
    void serviceShouldRejectInvalidParameters() {
        CounterService service = new CounterService();

        assertThrows(
                IllegalArgumentException.class,
                () -> service.runSequentialScenario(
                        "Помилковий послідовний тест",
                        new SafeSharedCounter(),
                        -1
                )
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> service.runConcurrentScenario(
                        "Помилковий паралельний тест",
                        new SafeSharedCounter(),
                        0,
                        100
                )
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> service.runConcurrentScenario(
                        "Помилковий паралельний тест",
                        new SafeSharedCounter(),
                        4,
                        -1
                )
        );
    }
}