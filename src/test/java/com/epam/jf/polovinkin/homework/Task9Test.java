package com.epam.jf.polovinkin.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task9Test {

    @Test
    void isZeroPowerOfTwo() {
        assertFalse(new Task9().isPowerOfTwo(0));
    }

    @Test
    void isOnePowerOfTwo() {
        assertTrue(new Task9().isPowerOfTwo(1));
    }

    @Test
    void isPowerOfTwo() {
        assertTrue(new Task9().isPowerOfTwo(256));
    }
}