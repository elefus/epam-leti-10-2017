package com.epam.jf.yessenbayev.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task9Test {
    Task9 test = new Task9();

    @Test
    void TestLongMaxValue(){
        assertFalse(test.isPowerOfTwo(Long.MAX_VALUE));
    }

    @Test
    void TestLongMinValue(){
        assertFalse(test.isPowerOfTwo(Long.MIN_VALUE));
    }

    @Test
    void TestZero() {
        assertFalse(test.isPowerOfTwo(0));
    }

    @Test
    void TestOne() {
        assertTrue(test.isPowerOfTwo(1));
    }

    @Test
    void TestFour() {
        assertTrue(test.isPowerOfTwo(4));
    }

}