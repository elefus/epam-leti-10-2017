package com.epam.jf.bavtovich.homework;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Task10test {
    Task10 task10 = new Task10();

    @Test
    void sumZero() {
        assertEquals(0,task10.getSumDigits(0));
    }

    @Test
    void sumMax() {
        assertEquals(88, task10.getSumDigits(Long.MAX_VALUE));
    }

    @Test
    void sumAnother() {
        assertEquals(16, task10.getSumDigits(79));
        assertEquals(20, task10.getSumDigits(758));
        assertEquals(26, task10.getSumDigits(7838));
        assertEquals(22, task10.getSumDigits(15646));
        assertEquals(29, task10.getSumDigits(861581));
    }
}
