package com.epam.jf.bavtovich.homework;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Task9test {
    Task9 task9 = new Task9();

    @Test
    void testMinValue() {
        assertFalse(task9.isPowerOfTwo(1));
    }

    @Test
    void testMaxValue() {
        assertFalse(task9.isPowerOfTwo(Long.MAX_VALUE));
    }

    @Test
    void checkPowTwoValues() {
        long num = 2;
        for (int i = 0; i < 50; i++) {
            assertTrue(task9.isPowerOfTwo(num));
            num *= 2;
        }
    }

    @Test
    void checkAnotherValues() {
        long num = 3;
        for (int i = 0; i < 50; i++) {
            assertFalse(task9.isPowerOfTwo(num));
            num *= 2;
        }
    }

}
