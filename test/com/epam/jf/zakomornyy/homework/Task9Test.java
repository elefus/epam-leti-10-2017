package com.epam.jf.zakomornyy.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class Task9Test {
    @Test
    public void isPowerOfTwoTest1() {
        Task9 task9 = new Task9();
        assertTrue(task9.isPowerOfTwo(8));
    }
    @Test
    public void isPowerOfTwoTest2() {
        Task9 task9 = new Task9();
        assertFalse(task9.isPowerOfTwo(-8));
    }
    @Test
    public void isPowerOfTwoTest3() {
        Task9 task9 = new Task9();
        assertFalse(task9.isPowerOfTwo(Long.MAX_VALUE));
    }
    @Test
    public void isPowerOfTwoTest4() {
        Task9 task9 = new Task9();
        assertFalse(task9.isPowerOfTwo(Long.MIN_VALUE));
    }
    @Test
    public void isPowerOfTwoTest5() {
        Task9 task9 = new Task9();
        assertFalse(task9.isPowerOfTwo(0));
    }
    @Test
    public void isPowerOfTwoTest6() {
        Task9 task9 = new Task9();
        assertTrue(task9.isPowerOfTwo(1));
    }
    @Test
    public void isPowerOfTwoTest7() {
        Task9 task9 = new Task9();
        assertFalse(task9.isPowerOfTwo(155));
    }
    @Test
    public void isPowerOfTwoTest8() {
        Task9 task9 = new Task9();
        assertTrue(task9.isPowerOfTwo(1024));
    }
}