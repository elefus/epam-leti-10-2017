package com.epam.jf.Guyo.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task9Test {
    @Test
    void someNumberTest() {
        Task9 task9 = new Task9();
        assertFalse(task9.isPowerOfTwo(55L));
    }

    @Test
    void negativeNumberTest(){
        Task9 task9 = new Task9();
        assertFalse(task9.isPowerOfTwo(-1L));
    }

    @Test
    void maxLongtest(){
        Task9 task9 = new Task9();
        assertFalse(task9.isPowerOfTwo(Long.MAX_VALUE));
    }
    @Test
    void testPowerOfTwo(){
        Task9 task9 = new Task9();
        assertTrue(task9.isPowerOfTwo(256));
    }
}