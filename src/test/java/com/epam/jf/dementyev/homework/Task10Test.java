package com.epam.jf.dementyev.homework;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.security.InvalidParameterException;
import org.junit.jupiter.api.Test;

class Task10Test {

    @Test
    void testZeroValue() {
        assertEquals(0, new Task10().getSumDigits(0));
    }

    @Test
    void testMaxValue() {
        assertEquals(88, new Task10().getSumDigits(Long.MAX_VALUE));
        assertEquals(18 * 9 + 8, new Task10().getSumDigits(8999999999999999999L));
    }

    @Test
    void testMinValue() {
        assertThrows(InvalidParameterException.class, () -> new Task10().getSumDigits(Long.MIN_VALUE));
    }

    @Test
    void testArbitraryValue() {
        assertEquals(90, new Task10().getSumDigits(1234567890123456789L));
    }
}