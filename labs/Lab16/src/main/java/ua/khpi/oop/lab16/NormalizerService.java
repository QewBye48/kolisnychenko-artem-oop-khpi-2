package ua.khpi.oop.lab16;

import java.util.Arrays;

public class NormalizerService {
    private final JavaNormalizer javaNormalizer;
    private final NativeNormalizer nativeNormalizer;

    public NormalizerService() {
        this.javaNormalizer = new JavaNormalizer();
        this.nativeNormalizer = new NativeNormalizer();
    }

    public double[] normalizeWithJava(double[] values) {
        return javaNormalizer.normalize(values);
    }

    public double[] normalizeWithNative(double[] values) {
        return nativeNormalizer.normalize(values);
    }

    public String buildReport(double[] source, double[] javaResult, double[] nativeResult) {
        StringBuilder builder = new StringBuilder();

        builder.append("Лабораторна робота №16\n");
        builder.append("Варіант 5 — нормалізація значень\n\n");

        builder.append("Початковий масив: ")
                .append(Arrays.toString(source))
                .append('\n');

        builder.append("Java-результат: ")
                .append(Arrays.toString(javaResult))
                .append('\n');

        builder.append("Native-результат: ")
                .append(Arrays.toString(nativeResult))
                .append('\n');

        builder.append("Результати однакові: ")
                .append(Arrays.equals(javaResult, nativeResult) ? "так" : "ні")
                .append('\n');

        return builder.toString();
    }
}