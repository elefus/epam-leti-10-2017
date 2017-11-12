package com.epam.jf.common.homework;

import com.epam.jf.common.homework.Task9;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class Task9Test {

    @Test
    void testLongMaxValue() {
        Task9 solver = null;

        boolean result = solver.isPowerOfTwo(Long.MAX_VALUE);

        assertFalse(result);
    }

    @Test
    void testLongMinValue() {
        Task9 solver = null;

        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                solver.isPowerOfTwo(Long.MIN_VALUE);
            }
        });
    }

    @Test
    void testZero() {
        Task9 solver = null;

        boolean result = solver.isPowerOfTwo(0);

        assertFalse(result);
    }

    @Test
    void testOne() {
        Task9 solver = null;

        boolean result = solver.isPowerOfTwo(1);

        assertTrue(result);
    }

    @Test
    void testFour() {
        Task9 solver = null;

        boolean result = solver.isPowerOfTwo(4);

        assertTrue(result);
    }
}