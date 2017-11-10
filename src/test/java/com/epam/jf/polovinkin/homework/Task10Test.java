package com.epam.jf.polovinkin.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task10Test {

    @Test
    void getSumDigits() {
        assertEquals(45, new Task10().getSumDigits(123456789));
    }
    @Test
    void getSumDigitsOfZero() {
        assertEquals(0, new Task10().getSumDigits(0));
    }
}