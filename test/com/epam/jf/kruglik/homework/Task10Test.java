package com.epam.jf.kruglik.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task10Test {
    @Test
    void oneNumberOrderResultNumberItself() {
        assertTrue(Task10.getSumDigits(1) == 1);
    }

    @Test
    void fiveNumberOrderResultSumOfNumeral() {
        assertTrue(Task10.getSumDigits(12345) == 15);
    }

    @Test
    void maximumBoundaryResultSumOfNumeral() {
        assertTrue(Task10.getSumDigits(Long.MAX_VALUE) == 88);
    }

}