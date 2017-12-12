package com.epam.jf.volkov.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Task10Test {

    Task10 solution = new Task10();

    @Test
    void test1() {
        assertEquals(6, solution.getSumDigits(123L));
    }

    @Test
    void test3() {
        assertEquals(1, solution.getSumDigits(100_000_000_000_000L));
    }
}