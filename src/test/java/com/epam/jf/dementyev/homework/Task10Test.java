package com.epam.jf.dementyev.homework;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.security.InvalidParameterException;
import org.junit.jupiter.api.Test;

class Task10Test {

    @Test
    void testZeroValue() {
        assertTrue(new Task10().getSumDigits(0) == 0);
    }

    @Test
    void testMaxValue() {
        assertTrue(new Task10().getSumDigits(Long.MAX_VALUE) == 88);
        assertTrue(new Task10().getSumDigits(8999999999999999999L) == 18 * 9 + 8);
    }

    @Test
    void testMinValue() {
        assertThrows(InvalidParameterException.class, () -> new Task10().getSumDigits(Long.MIN_VALUE));
    }

    @Test
    void testArbitraryValue() {
        assertTrue(new Task10().getSumDigits(1234567890123456789L) == 90);
    }
}