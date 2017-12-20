package com.epam.jf.kozlov.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task10Test {
    @Test
    void testZero() {
        Task10 solver = new Task10();

        long result = solver.getSumDigits(0);

        assertEquals(0, result);
    }

    @Test
    void testTen() {
        Task10 solver = new Task10();

        long result = solver.getSumDigits(10);

        assertEquals(1, result);
    }

    @Test
    void testBigNumber() {
        Task10 solver = new Task10();

        long result = solver.getSumDigits(1234567890);

        assertEquals(45, result);
    }

    @Test
    void testNegativeBigNumber() {
        Task10 solver = new Task10();

        long result = solver.getSumDigits(-1234567890);

        assertEquals(45, result);
    }

    @Test
    void testNegativeOne() {
        Task10 solver = new Task10();

        long result = solver.getSumDigits(-1);

        assertEquals(1, result);
    }

    @Test
    void testMemeNumber() {
        Task10 solver = new Task10();

        long result = solver.getSumDigits(42);

        assertEquals(6, result);
    }
}