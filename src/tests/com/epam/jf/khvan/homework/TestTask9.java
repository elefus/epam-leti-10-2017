package com.epam.jf.khvan.homework;

import com.epam.jf.khvan.homework.Task9Implement;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTask9 {

    @Test
    void testMinValue() {
        Task9Implement testingClass = new Task9Implement();
        assertFalse(testingClass.isPowerOfTwo(0));
    }

    @Test
    void testMaxValue() {
        Task9Implement testingClass = new Task9Implement();
        assertFalse(testingClass.isPowerOfTwo(Integer.MAX_VALUE));
    }

    @Test
    void testRandomPowerOfTwo() {
        Task9Implement testingClass = new Task9Implement();
        assertTrue(testingClass.isPowerOfTwo( 1 << new Random().nextInt(64)));
    }

}
