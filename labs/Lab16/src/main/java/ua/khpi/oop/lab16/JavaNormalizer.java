package ua.khpi.oop.lab16;

public class JavaNormalizer {

    public double[] normalize(double[] values) {
        validate(values);

        double min = values[0];
        double max = values[0];

        for (double value : values) {
            if (value < min) {
                min = value;
            }
            if (value > max) {
                max = value;
            }
        }

        double[] result = new double[values.length];

        if (max == min) {
            return result;
        }

        for (int i = 0; i < values.length; i++) {
            result[i] = (values[i] - min) / (max - min);
        }

        return result;
    }

    private void validate(double[] values) {
        if (values == null) {
            throw new IllegalArgumentException("Масив не може бути null");
        }
        if (values.length == 0) {
            throw new IllegalArgumentException("Масив не може бути порожнім");
        }
    }
}