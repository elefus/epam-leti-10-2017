package com.epam.jf.khvan.homework;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTask10 {
    @Test
    public void getSumDigitsTest() {
        Task10Impl testClass = new Task10Impl();
        assertEquals(1, testClass.getSumDigits(100));
        assertEquals(23, testClass.getSumDigits(10787));
        assertEquals(13, testClass.getSumDigits(3244));
        assertEquals(17, testClass.getSumDigits(800001134));
        assertEquals(0, testClass.getSumDigits(0));
    }
}
