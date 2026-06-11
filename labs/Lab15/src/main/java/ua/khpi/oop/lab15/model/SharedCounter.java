package ua.khpi.oop.lab15.model;

public interface SharedCounter {
    void increment();

    int getValue();

    void reset();

    String getCounterName();
}