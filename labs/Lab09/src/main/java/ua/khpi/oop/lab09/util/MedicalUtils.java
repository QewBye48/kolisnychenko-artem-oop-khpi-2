package ua.khpi.oop.lab09.util;

import java.util.List;

public final class MedicalUtils {

    private MedicalUtils() {
    }

    public static <T extends Comparable<? super T>> T findMaximum(List<T> items) {
        if (items == null || items.isEmpty()) {
            return null;
        }

        T max = items.get(0);

        for (T item : items) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }

        return max;
    }
}