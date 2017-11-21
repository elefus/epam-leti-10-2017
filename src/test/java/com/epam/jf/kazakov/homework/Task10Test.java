package com.epam.jf.kazakov.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class Task10Test {

    @Test
    void testZeroValue() {
        Task10 solver = new Task10();

        long result = solver.getSumDigits(0);

        assertEquals(result, 0);
    }

    @Test
    void testSingleNumberValue() {
        Task10 solver = new Task10();

        long result = solver.getSumDigits(1);

        assertEquals(result, 1);
    }

    @Test
    void testLongMaxValue() {
        Task10 solver = new Task10();

        long result = solver.getSumDigits(Long.MAX_VALUE);

        assertEquals(result, 88);
    }

    @Test
    void testValuesWithSameNumbers() {
        Task10 solver = new Task10();

        long result1 = solver.getSumDigits(123L);
        long result2 = solver.getSumDigits(321L);

        assertEquals(result1, result2);
    }

}