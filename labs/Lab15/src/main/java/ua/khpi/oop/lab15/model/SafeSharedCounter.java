package ua.khpi.oop.lab15.model;

public class SafeSharedCounter implements SharedCounter {
    private int value;

    @Override
    public synchronized void increment() {
        value++;
    }

    @Override
    public synchronized int getValue() {
        return value;
    }

    @Override
    public synchronized void reset() {
        value = 0;
    }

    @Override
    public String getCounterName() {
        return "SafeSharedCounter";
    }
}