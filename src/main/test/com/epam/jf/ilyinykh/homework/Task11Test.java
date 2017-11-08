package com.epam.jf.ilyinykh.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task11Test {
    @Test
    public void reverseTest() {
        Task11Impl task = new Task11Impl();
        assertEquals(11, task.reverse(11));
        assertEquals(321, task.reverse(123));
        assertEquals(1001, task.reverse(1001));
        assertEquals(9876, task.reverse(6789));
        assertEquals(1, task.reverse(1));
        assertEquals(1, task.reverse(1000));
    }
}
