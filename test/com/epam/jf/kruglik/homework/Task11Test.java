package com.epam.jf.kruglik.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task11Test {
    @Test
    void oneNumberOrderResultNumberItself() {
        assertTrue(Task11.reverse(9) == 9);
    }

    @Test
    void fiveNumberOrder() {
        assertTrue(Task11.reverse(12345) == 54321);
    }

    @Test
    void negativeFiveNumberOrder() {
        assertTrue(Task11.reverse(-12345) == -54321);
    }

    @Test
    void negativeOneNumberOrderResultNegativeNumberItself() {
        assertTrue(Task11.reverse(-9) == -9);
    }

    @Test
    void zeroBorderResultZero() {
        assertTrue(Task11.reverse(0) == 0);
    }
}