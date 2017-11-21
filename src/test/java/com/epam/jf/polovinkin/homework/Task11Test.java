package com.epam.jf.polovinkin.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task11Test {

    @Test
    void reverse() {
        assertEquals(87654321, new Task11().reverse(12345678));
    }

    @Test
    void reverseOneDigit() {
        assertEquals(5, new Task11().reverse(5));
    }

    @Test
    void reverseZero() {
        assertEquals(0, new Task11().reverse(0));
    }
}