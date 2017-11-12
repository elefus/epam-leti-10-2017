package com.epam.jf.khvan.homework;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTask11 {
    @Test
    public void getSumDigitsTest() {
        Task11Implement testClass = new Task11Implement();
        assertEquals(100001, testClass.reverse(100001));
        assertEquals(78701, testClass.reverse(10787));
        assertEquals(4423, testClass.reverse(3244));
        assertEquals(431100008, testClass.reverse(800001134));
        assertEquals(1, testClass.reverse(10000));
    }
}

