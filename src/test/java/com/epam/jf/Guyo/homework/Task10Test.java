package com.epam.jf.Guyo.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task10Test {

    Task10 task10 = new Task10();

    @Test
    void zeroNumberTest() {
        assertEquals(0, task10.getSumDigits(0));
    }

    @Test
    void oneNumberTest() {
        assertEquals(1, task10.getSumDigits(1));
    }

    @Test
    void maxLongNumberTest() {
        assertEquals(88, task10.getSumDigits(Long.MAX_VALUE));
    }

    @Test
    void someNumberTest() {
        assertEquals(6, task10.getSumDigits(123));
        assertEquals(6, task10.getSumDigits(132));
        assertEquals(6, task10.getSumDigits(213));
        assertEquals(6, task10.getSumDigits(231));
        assertEquals(6, task10.getSumDigits(312));
        assertEquals(6, task10.getSumDigits(321));
    }
}