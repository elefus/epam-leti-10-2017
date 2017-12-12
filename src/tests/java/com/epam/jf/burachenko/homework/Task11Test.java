package com.epam.jf.burachenko.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task11Test {
    Task11 testingClass = new Task11();

    @Test
    void testMinValue() {
        assertEquals(0, testingClass.reverse(0));
    }

    @Test
    void testLittleValue() {
        assertEquals(57, testingClass.reverse(75));
    }

    @Test
    void testSomeValue() {
        assertEquals(4_751, testingClass.reverse(1_574));
    }

    @Test
    void testOneMoreValue() {
        assertEquals(2_004_751, testingClass.reverse(1_574_002));
    }
}