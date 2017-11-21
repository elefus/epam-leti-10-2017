package com.epam.jf.dementyev.homework;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.security.InvalidParameterException;
import org.junit.jupiter.api.Test;

class Task9Test {

    @Test
    void testAllPowersOfTwo() {
        Task9 obj = new Task9();
        long val = 1;
        for (int i = 0; i < 63; i++) {
            assertTrue(obj.isPowerOfTwo(val));
            val <<= 1;
        }
    }

    @Test
    void testMaxValue() {
        assertFalse(new Task9().isPowerOfTwo(Long.MAX_VALUE));
    }

    @Test
    void testMinValue() {
        assertThrows(InvalidParameterException.class, () -> new Task9().isPowerOfTwo(Long.MIN_VALUE));
    }

    @Test
    void testZeroValue() {
        assertFalse(new Task9().isPowerOfTwo(0));
    }

}