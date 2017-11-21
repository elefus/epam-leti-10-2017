package com.epam.jf.ilyinykh.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task9ImplTest {
    @Test
    public void testIsPowerOfTwo() {
        Task9Impl task = new Task9Impl();
        for (int i = 0; i < 129; i++) {
            if (i == 1 || i == 2 || i == 4 || i == 8 || i == 16 || i == 32 || i == 64 || i == 128) {
                assertTrue(task.isPowerOfTwo(i));
            } else {
                assertFalse(task.isPowerOfTwo(i));
            }
        }
    }
}
