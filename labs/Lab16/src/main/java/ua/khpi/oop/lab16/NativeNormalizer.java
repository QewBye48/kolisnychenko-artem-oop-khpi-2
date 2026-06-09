package ua.khpi.oop.lab16;

import java.nio.file.Files;
import java.nio.file.Path;

public class NativeNormalizer {

    static {
        loadNativeLibrary();
    }

    private static void loadNativeLibrary() {
        String libraryName = "nativenormalizer";
        String libraryFileName = System.mapLibraryName(libraryName);

        Path targetPath = Path.of("target", "native", libraryFileName).toAbsolutePath();

        if (Files.exists(targetPath)) {
            System.load(targetPath.toString());
            return;
        }

        Path buildPath = Path.of("build", "native", libraryFileName).toAbsolutePath();

        if (Files.exists(buildPath)) {
            System.load(buildPath.toString());
            return;
        }

        System.loadLibrary(libraryName);
    }

    public native double[] normalize(double[] values);
}