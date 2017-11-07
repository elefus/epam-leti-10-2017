package com.epam.jf.dementyev.homework;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class Task11Test {

    @Test
    void testZeroValue() {
        assertTrue(new Task11().reverse(0) == 0);
    }

    @Test
    void testPositiveValue() {
        assertTrue(new Task11().reverse(1230078900) == 98700321);
    }

    @Test
    void testNegativeValue() {
        assertTrue(new Task11().reverse(-987654321) == -123456789);
    }
}