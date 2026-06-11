package ua.khpi.oop.lab15.model;

public class EventSource {
    private final String name;
    private final int eventCount;

    public EventSource(String name, int eventCount) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Назва джерела подій не може бути порожньою");
        }
        if (eventCount < 0) {
            throw new IllegalArgumentException("Кількість подій не може бути від'ємною");
        }

        this.name = name;
        this.eventCount = eventCount;
    }

    public String getName() {
        return name;
    }

    public int getEventCount() {
        return eventCount;
    }

    @Override
    public String toString() {
        return "Джерело подій: " + name + ", кількість подій: " + eventCount;
    }
}