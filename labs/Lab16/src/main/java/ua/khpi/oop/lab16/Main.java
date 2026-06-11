package ua.khpi.oop.lab16;

public class Main {
    public static void main(String[] args) {
        double[] values = {10.0, 20.0, 30.0, 40.0, 50.0};

        NormalizerService service = new NormalizerService();

        double[] javaResult = service.normalizeWithJava(values);
        double[] nativeResult = service.normalizeWithNative(values);

        System.out.println(service.buildReport(values, javaResult, nativeResult));
    }
}