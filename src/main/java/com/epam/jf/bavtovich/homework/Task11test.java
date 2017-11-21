package com.epam.jf.bavtovich.homework;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Task11test {
    Task11 task11 = new Task11();

    @Test
    void testReverse() {
        assertEquals(1, task11.reverse(1));
        assertEquals(12, task11.reverse(21));
        assertEquals(156, task11.reverse(651));
        assertEquals(27654, task11.reverse(45672));
        assertEquals(4548687, task11.reverse(7868454));
        assertEquals(917864837, task11.reverse(738468719));
    }
}
