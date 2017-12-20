package com.epam.jf.kozlov.homework;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task9Test {
    @Test
    void testZero() {
        assertFalse(new Task9().isPowerOfTwo(0));
    }

    @Test
    void testOne() {
        assertTrue(new Task9().isPowerOfTwo(1));
    }

    @Test
    void testFour() {
        assertTrue(new Task9().isPowerOfTwo(4));
    }

    @Test
    void testSeven() {
        assertFalse(new Task9().isPowerOfTwo(7));
    }

    @Test
    void testNumberWhichIsDefinitelyNotPowerOfTwo() {
        assertFalse(new Task9().isPowerOfTwo(872193984));
    }

    @Test
    void testNegativeTwo() {
        assertFalse(new Task9().isPowerOfTwo(-2));
    }

    @Test
    void testNegativeOne() {
        assertFalse(new Task9().isPowerOfTwo(-1));
    }

    @Test
    void testNegativeNumber() {
        assertFalse(new Task9().isPowerOfTwo(-872193984));
    }
}