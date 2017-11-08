package com.epam.jf.ilyinykh.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task10Test {
    @Test
    public void getSumDigitsTest() {
        Task10Impl task = new Task10Impl();

        assertEquals(1, task.getSumDigits(100));
        assertEquals(3, task.getSumDigits(111));
        assertEquals(7, task.getSumDigits(133));
        assertEquals(10, task.getSumDigits(901));
    }
}
