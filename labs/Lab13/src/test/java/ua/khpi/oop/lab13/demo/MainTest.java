package ua.khpi.oop.lab13.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class MainTest {

    @Test
    void mainShouldRunWithoutErrors() {
        assertDoesNotThrow(() -> Main.main(new String[0]));
    }
}