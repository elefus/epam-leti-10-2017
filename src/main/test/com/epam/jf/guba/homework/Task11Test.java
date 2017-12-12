package com.epam.jf.guba.homework;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Task11Test {

    Task11 task11 = new Task11();

    @Test
    void reverse() {
        assertEquals(87654321, task11.reverse(12345678));
    }

    @Test
    void reverseOneDigit() {
        assertEquals(5, task11.reverse(5));
    }

    @Test
    void reverseZero() {
        assertEquals(0, task11.reverse(0));
    }

    @Test
    void testReverseLessZero(){
        assertEquals(-12345, task11.reverse(-54321));
    }



}
