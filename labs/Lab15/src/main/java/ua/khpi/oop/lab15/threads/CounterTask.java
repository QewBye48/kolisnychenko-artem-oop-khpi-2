package ua.khpi.oop.lab15.threads;

import ua.khpi.oop.lab15.model.EventSource;
import ua.khpi.oop.lab15.model.SharedCounter;

public class CounterTask implements Runnable {
    private final EventSource eventSource;
    private final SharedCounter counter;

    public CounterTask(EventSource eventSource, SharedCounter counter) {
        if (eventSource == null) {
            throw new IllegalArgumentException("Джерело подій не може бути null");
        }
        if (counter == null) {
            throw new IllegalArgumentException("Лічильник не може бути null");
        }

        this.eventSource = eventSource;
        this.counter = counter;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();

        System.out.println(threadName + ": початок обробки " + eventSource.getName());

        for (int i = 0; i < eventSource.getEventCount(); i++) {
            counter.increment();
        }

        System.out.println(threadName + ": завершено, подій: " + eventSource.getEventCount());
    }
}