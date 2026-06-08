package ua.khpi.oop.lab15.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SharedCounterTest {

    @Test
    void safeCounterShouldIncrementCorrectly() {
        SafeSharedCounter counter = new SafeSharedCounter();

        counter.increment();
        counter.increment();
        counter.increment();

        assertEquals(3, counter.getValue());
        assertEquals("SafeSharedCounter", counter.getCounterName());
    }

    @Test
    void safeCounterShouldResetValue() {
        SafeSharedCounter counter = new SafeSharedCounter();

        counter.increment();
        counter.increment();
        counter.reset();

        assertEquals(0, counter.getValue());
    }

    @Test
    void unsafeCounterShouldIncrementInSingleThread() {
        UnsafeSharedCounter counter = new UnsafeSharedCounter();

        counter.increment();
        counter.increment();

        assertEquals(2, counter.getValue());
        assertEquals("UnsafeSharedCounter", counter.getCounterName());
    }

    @Test
    void eventSourceShouldStoreData() {
        EventSource source = new EventSource("EventSource-1", 100);

        assertEquals("EventSource-1", source.getName());
        assertEquals(100, source.getEventCount());
        assertTrue(source.toString().contains("EventSource-1"));
    }

    @Test
    void eventSourceShouldRejectInvalidData() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new EventSource("", 100)
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> new EventSource("EventSource-1", -1)
        );
    }

    @Test
    void counterResultShouldCalculateLostUpdates() {
        CounterResult result = new CounterResult(
                "Тестовий сценарій",
                4,
                100,
                400,
                350,
                10
        );

        assertEquals("Тестовий сценарій", result.getScenarioName());
        assertEquals(4, result.getThreadCount());
        assertEquals(100, result.getOperationsPerThread());
        assertEquals(400, result.getExpectedValue());
        assertEquals(350, result.getActualValue());
        assertEquals(50, result.getLostUpdates());
        assertFalse(result.isCorrect());
    }
}