package ua.khpi.oop.lab16;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NormalizerTest {
    private static final double EPS = 0.000001;

    @Test
    void javaNormalizerShouldNormalizeValues() {
        JavaNormalizer normalizer = new JavaNormalizer();

        double[] result = normalizer.normalize(new double[]{10.0, 20.0, 30.0});

        assertArrayEquals(new double[]{0.0, 0.5, 1.0}, result, EPS);
    }

    @Test
    void javaNormalizerShouldReturnZerosForEqualValues() {
        JavaNormalizer normalizer = new JavaNormalizer();

        double[] result = normalizer.normalize(new double[]{5.0, 5.0, 5.0});

        assertArrayEquals(new double[]{0.0, 0.0, 0.0}, result, EPS);
    }

    @Test
    void javaNormalizerShouldRejectInvalidArrays() {
        JavaNormalizer normalizer = new JavaNormalizer();

        assertThrows(
                IllegalArgumentException.class,
                () -> normalizer.normalize(null)
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> normalizer.normalize(new double[]{})
        );
    }

    @Test
    void nativeNormalizerShouldNormalizeValues() {
        NativeNormalizer normalizer = new NativeNormalizer();

        double[] result = normalizer.normalize(new double[]{10.0, 20.0, 30.0});

        assertArrayEquals(new double[]{0.0, 0.5, 1.0}, result, EPS);
    }

    @Test
    void javaAndNativeResultsShouldBeEqual() {
        JavaNormalizer javaNormalizer = new JavaNormalizer();
        NativeNormalizer nativeNormalizer = new NativeNormalizer();

        double[][] cases = {
                {10.0, 20.0, 30.0},
                {-10.0, 0.0, 10.0},
                {5.0, 5.0, 5.0},
                {1.0, 2.0, 4.0, 8.0}
        };

        for (double[] testCase : cases) {
            double[] javaResult = javaNormalizer.normalize(testCase);
            double[] nativeResult = nativeNormalizer.normalize(testCase);

            assertArrayEquals(javaResult, nativeResult, EPS);
        }
    }
}