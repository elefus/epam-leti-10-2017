package com.epam.jf.savchenkov.homework;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class Task9Test {

    @Test
    void testPowerOfTwoValueResultTrue() {
        Assertions.assertTrue(Task9.isPowerOfTwo(512));
    }

    @Test
    void testNotPowerOfTwoValueResultFalse() {
        Assertions.assertFalse(Task9.isPowerOfTwo(3));
    }

    @Test
    void testZeroResultFalse(){
        Assertions.assertFalse(Task9.isPowerOfTwo(0));
    }

    @Test
    void testMaximumResultFalse(){
        Assertions.assertFalse(Task9.isPowerOfTwo(Long.MAX_VALUE));
    }

    @Test
    void testNegativeResultFalse() {
        Assertions.assertFalse(Task9.isPowerOfTwo(-2));
    }
}