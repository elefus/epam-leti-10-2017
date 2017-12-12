package com.epam.jf.savchenkov.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task10Test {

    Task10 task10 = new Task10();

    @Test
    void testZeroValue() {
        assertEquals(0, task10.getSumDigits(0));
    }

    @Test
    void testOneValue() {
        assertEquals(1, task10.getSumDigits(10000));
    }

    @Test
    void testMaxLongValue() {
        assertEquals(88, task10.getSumDigits(Long.MAX_VALUE));
    }

    @Test
    void testSameSumValue() {
        assertEquals(task10.getSumDigits(15423), task10.getSumDigits(34251));
    }
}