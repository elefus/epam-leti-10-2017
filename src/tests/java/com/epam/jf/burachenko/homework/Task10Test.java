package com.epam.jf.burachenko.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task10Test {
    Task10 testingClass = new Task10();

    @Test
    void testMinValue() {
        assertEquals(0L, testingClass.getSumDigits(0L));
    }

    @Test
    void testMaxValue() {
        assertEquals(88, testingClass.getSumDigits(Long.MAX_VALUE));
    }

    @Test
    void testSomeValue() {
        assertEquals(59L, testingClass.getSumDigits(5_475_156_489_005L));
    }
}