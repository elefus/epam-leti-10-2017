package com.epam.jf.kazakov.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task11Test {

    Task11 test = new Task11();

    @Test
    void testZero() {
        assertEquals(test.reverse(0), 0);
    }

    @Test
    void testOne() {
        assertEquals(test.reverse(1), 1);
    }

    @Test
    void testSomeRandomNumbers() {
        assertEquals(test.reverse(123), 321);
        assertEquals(test.reverse(321), 123);
        assertEquals(test.reverse(101), 101);
        assertEquals(test.reverse(1000), 1);
        assertEquals(test.reverse(-123), -321);
    }
}