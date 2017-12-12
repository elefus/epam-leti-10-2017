package com.epam.jf.kuchinskii.homework;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Task10Test {

    @Test
    void testZero(){
        long result = new Task10().getSumDigits(0);
        assertTrue(result == 0);
    }

    @Test
    void testLongMaxValue(){
        long result = new Task10().getSumDigits(Long.MAX_VALUE);
        assertTrue(result == 88);
    }

    @Test
    void testLongMinValue(){
        long result = new Task10().getSumDigits(Long.MIN_VALUE);
        assertTrue(result == 89);
    }

    @Test
    void testValue(){
        long result = new Task10().getSumDigits(1234567890);
        assertTrue(result == 45);
    }

    @Test
    void testMaxOutputValue(){
        long result = new Task10().getSumDigits(8999999999999999999L);
        assertTrue(result == 170);
    }
}
