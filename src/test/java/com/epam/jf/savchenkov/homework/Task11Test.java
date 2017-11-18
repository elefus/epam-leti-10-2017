package com.epam.jf.savchenkov.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task11Test {

    Task11 task11 = new Task11();

    @Test
    void testZero() {
        assertEquals(0, task11.reverse(0));
    }

    @Test
    void testOne() {
        assertEquals(1, task11.reverse(1));
    }

    @Test
    void testNumberWithZeros() {
        assertEquals(9090909, task11.reverse(90909090));
    }

    @Test
    void testNumberWithZeroesAtTheEnd() {
        assertEquals(1, task11.reverse(10000000));
    }

    @Test
    void testCommon() {
        assertEquals(1021, task11.reverse(1201));
        assertEquals(321321, task11.reverse(123123));
        assertEquals(987654321, task11.reverse(1234567890));
    }

}