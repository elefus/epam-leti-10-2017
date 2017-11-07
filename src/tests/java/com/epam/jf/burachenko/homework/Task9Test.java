package com.epam.jf.burachenko.homework;

import org.junit.jupiter.api.Test;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

class Task9Test {

    @Test
    void testMaxValue() {
        Task9 testingClass = new Task9();

        assertFalse(testingClass.isPowerOfTwo(Long.MAX_VALUE));

        assertFalse(testingClass.isPowerOfTwo(0));

        assertTrue(testingClass.isPowerOfTwo(1 << new Random().nextInt(64)));
    }

    @Test
    void testMinValue() {
        Task9 testingClass = new Task9();

        assertFalse(testingClass.isPowerOfTwo(0));
    }

    @Test
    void testIsPowerOfTwoValue() {
        Task9 testingClass = new Task9();

        assertTrue(testingClass.isPowerOfTwo(1 << new Random().nextInt(64)));
    }
}
