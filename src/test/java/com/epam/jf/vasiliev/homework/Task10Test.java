package com.epam.jf.vasiliev.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task10Test {
    private Task10 ref = new Task10();

    @Test
    void testZero() {
        assertEquals(0,ref.getSumDigits(0));
    }

    @Test
    void test15() {
        assertEquals(6,ref.getSumDigits(6));
    }

    @Test
    void test1() {
        assertEquals(1,ref.getSumDigits(1));
    }

    @Test
    void testMinus10() {
        assertEquals(1,ref.getSumDigits(-10));
    }

    @Test
    void testMaxLong() {
        assertEquals(88,ref.getSumDigits(Long.MAX_VALUE));
    }

    @Test
    void testMinLong() {
        assertEquals(89,ref.getSumDigits(Long.MIN_VALUE));
    }

    @Test
    void test123456789() {
        assertEquals(45,ref.getSumDigits(123456789));
    }

    @Test
    void testMinus123456789() {
        assertEquals(45,ref.getSumDigits(-123456789));
    }

    @Test
    void testMinus5() {
        assertEquals(5,ref.getSumDigits(-5));
    }
}