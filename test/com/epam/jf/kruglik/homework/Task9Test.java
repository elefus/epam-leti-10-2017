package com.epam.jf.kruglik.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task9Test {
    @Test
    void powerOfTwoValueTestResultTrue() {
        Assertions.assertTrue(Task9.isPowerOfTwo(1024));
    }

    @Test
    void notPowerOfTwoValueTestResultFalse() {
        Assertions.assertFalse(Task9.isPowerOfTwo(1025));
    }

    @Test
    void maximumBoundaryСheckResultFalse(){
        Assertions.assertFalse(Task9.isPowerOfTwo(Long.MAX_VALUE));
    }

    @Test
    void zeroBoundaryСheckResultTrue(){
        Assertions.assertTrue(Task9.isPowerOfTwo(0));
    }
}