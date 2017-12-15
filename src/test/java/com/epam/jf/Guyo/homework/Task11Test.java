package com.epam.jf.Guyo.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task11Test {
    @Test
    void testZeroNumber() {
        Task11 task11 = new Task11();
        assertEquals(0, task11.reverse(0));
    }

    @Test
    void testSomeNumber() {
        Task11 task11 = new Task11();
        assertEquals(123987, task11.reverse(789321));
    }

    @Test
    void testNumberWtihSameDigs() {
        Task11 task11 = new Task11();
        assertEquals(123, task11.reverse(321));
        assertEquals(213, task11.reverse(312));
        assertEquals(321, task11.reverse(123));
        assertEquals(132, task11.reverse(231));
        assertEquals(312, task11.reverse(213));
        assertEquals(231, task11.reverse(132));
    }
}