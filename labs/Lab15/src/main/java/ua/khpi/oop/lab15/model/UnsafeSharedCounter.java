package ua.khpi.oop.lab15.model;

public class UnsafeSharedCounter implements SharedCounter {
    private int value;

    @Override
    public void increment() {
        int current = value;

        if ((current & 7) == 0) {
            Thread.yield();
        }

        value = current + 1;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void reset() {
        value = 0;
    }

    @Override
    public String getCounterName() {
        return "UnsafeSharedCounter";
    }
}