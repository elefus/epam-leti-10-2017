package com.epam.jf.kozlov.homework;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class Task11Test {

    @Test
    void testZero() {
        assertEquals(0, new Task11().reverse(0));
    }

    @Test
    void testBigNumber() {
        assertEquals(987654321, new Task11().reverse(1234567890));
    }

    @Test
    void testLittleNumber() {
        assertEquals(5, new Task11().reverse(5));
    }

    @Test
    void testNumberWithoutZeroes() {
        assertEquals(987654321, new Task11().reverse(123456789));
    }

    @Test
    void testNumberWithLotOfZeroes() {
        assertEquals(3010301, new Task11().reverse(10301030));
    }

    @Test
    void testMemeNumber() {
        assertEquals(24, new Task11().reverse(42));
    }

    @Test
    void testOne() {
        assertEquals(1, new Task11().reverse(1));
    }

    @Test
    void testNumberWithLotOfRowZeroes() {
        assertEquals(1, new Task11().reverse(100000000));
    }

}