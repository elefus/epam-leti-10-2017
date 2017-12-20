package com.epam.jf.kozlov.homework;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task9Test {
    @Test
    void testZero() {
        Task9 solver = new Task9();

        boolean result = solver.isPowerOfTwo(0);

        assertFalse(result);
    }

    @Test
    void testOne() {
        Task9 solver = new Task9();

        boolean result = solver.isPowerOfTwo(1);

        assertTrue(result);
    }

    @Test
    void testFour() {
        Task9 solver = new Task9();

        boolean result = solver.isPowerOfTwo(4);

        assertTrue(result);
    }

    @Test
    void testSeven() {
        Task9 solver = new Task9();

        boolean result = solver.isPowerOfTwo(7);

        assertFalse(result);
    }

    @Test
    void testNumberWhichIsDefinitelyNotPowerOfTwo() {
        Task9 solver = new Task9();

        boolean result = solver.isPowerOfTwo(872193984);

        assertFalse(result);
    }

    @Test
    void testNegativeTwo() {
        Task9 solver = new Task9();

        boolean result = solver.isPowerOfTwo(-2);

        assertFalse(result);
    }

    @Test
    void testNegativeOne() {
        Task9 solver = new Task9();

        boolean result = solver.isPowerOfTwo(-1);

        assertFalse(result);
    }

    @Test
    void testNegativeNumber() {
        Task9 solver = new Task9();

        boolean result = solver.isPowerOfTwo(-872193984);

        assertFalse(result);
    }
}