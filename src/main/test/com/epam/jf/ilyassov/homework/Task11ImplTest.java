package com.epam.jf.ilyassov.homework;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task11ImplTest {

    @Test
    void reverseTest() {
        Task11Impl task11 = new Task11Impl();
        assertEquals(111,task11.reverse(111));
        assertEquals(10987,task11.reverse(78901));
        assertEquals(1,task11.reverse(1000));
        assertEquals(980001,task11.reverse(100089));

    }
}