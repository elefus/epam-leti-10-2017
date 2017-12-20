package com.epam.jf.kozlov.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task10Test {
    @Test
    void testZero() {
        assertEquals(0, new Task10().getSumDigits(0));
    }

    @Test
    void testTen() {
        assertEquals(1, new Task10().getSumDigits(10));
    }

    @Test
    void testBigNumber() {
        assertEquals(45, new Task10().getSumDigits(1234567890));
    }

    @Test
    void testNegativeBigNumber() {
        assertEquals(45, new Task10().getSumDigits(-1234567890));
    }

    @Test
    void testNegativeOne() {
        assertEquals(1, new Task10().getSumDigits(-1));
    }

    @Test
    void testMemeNumber() {
        assertEquals(6, new Task10().getSumDigits(42));
    }
}