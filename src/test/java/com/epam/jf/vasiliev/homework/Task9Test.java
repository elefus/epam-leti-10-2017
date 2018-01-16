package com.epam.jf.vasiliev.homework;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class Task9Test {

    private Task9 ref = new Task9();

    @Test
    void testLongMaxValue() {
        assertFalse(ref.isPowerOfTwo(Long.MAX_VALUE));
    }

    @Test
    void testLongMinValue() {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                ref.isPowerOfTwo(Long.MIN_VALUE);
            }
        });
    }

    @Test
    void testZero() {
        assertFalse(ref.isPowerOfTwo(0));
    }

    @Test
    void testOne() {
        assertTrue(ref.isPowerOfTwo(1));
    }

    @Test
    void testFour() {
        assertTrue(ref.isPowerOfTwo(4));
    }

    @Test
    void testTen() {
        assertFalse(ref.isPowerOfTwo(10));
    }
}