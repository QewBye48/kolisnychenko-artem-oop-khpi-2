package ua.khpi.oop.lab10.container;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class InventoryContainer<T> implements Iterable<T> {
    private static final int DEFAULT_CAPACITY = 5;
    private static final int GROW_FACTOR = 2;

    private Object[] items;
    private int size;

    public InventoryContainer() {
        this.items = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public InventoryContainer(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Місткість контейнера має бути додатною");
        }

        this.items = new Object[capacity];
        this.size = 0;
    }

    public void add(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Елемент не може бути null");
        }

        if (size == items.length) {
            grow();
        }

        items[size] = item;
        size++;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        checkIndex(index);
        return (T) items[index];
    }

    @SuppressWarnings("unchecked")
    public T remove(int index) {
        checkIndex(index);

        T removed = (T) items[index];

        for (int i = index; i < size - 1; i++) {
            items[i] = items[i + 1];
        }

        items[size - 1] = null;
        size--;

        return removed;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return items.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            items[i] = null;
        }

        size = 0;
    }

    private void grow() {
        Object[] newItems = new Object[items.length * GROW_FACTOR];

        for (int i = 0; i < items.length; i++) {
            newItems[i] = items[i];
        }

        items = newItems;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Неправильний індекс: " + index);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new InventoryIterator();
    }

    private class InventoryIterator implements Iterator<T> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        @SuppressWarnings("unchecked")
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Більше немає елементів");
            }

            T item = (T) items[currentIndex];
            currentIndex++;

            return item;
        }
    }
}