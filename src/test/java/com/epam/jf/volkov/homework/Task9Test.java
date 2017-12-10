package com.epam.jf.volkov.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class Task9Test {
    Task9 testing = new Task9();

    @Test
    void isPowerOfTwo1() {
        assertTrue(testing.isPowerOfTwo(1024L));
    }

    @Test
    void isPowerOfTwo2() {
        assertTrue(testing.isPowerOfTwo(2L));
    }

    @Test
    void isPowerOfTwo3() {
        assertTrue(testing.isPowerOfTwo(4L));
    }

    @Test
    void isPowerOfTwo4() {
        assertTrue(testing.isPowerOfTwo(1_152_921_504_606_846_976L));
    }

    @Test
    void isPowerOfTwo5() {
        assertTrue(testing.isPowerOfTwo(1L));
    }

    @Test
    void isPowerOfTwo6() {
        assertTrue(testing.isPowerOfTwo(32L));
    }

    @Test
    void isPowerOfTwo7() {
        assertFalse(testing.isPowerOfTwo(0L));
    }

    @Test
    void isPowerOfTwo8() {
        assertFalse(testing.isPowerOfTwo(35L));
    }

    @Test
    void isPowerOfTwo9() {
        assertFalse(testing.isPowerOfTwo(3L));
    }

    @Test
    void isPowerOfTwo0() {
        assertFalse(testing.isPowerOfTwo(Long.MAX_VALUE));
    }
}