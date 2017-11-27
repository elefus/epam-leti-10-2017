package com.epam.jf.vasiliev.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task11Test {

    private Task11 ref = new Task11();

    @Test
    void testZero() {
        assertEquals(0,ref.reverse(0));
    }

    @Test
    void test100() {
        assertEquals(1,ref.reverse(100));
    }

    @Test
    void testMinus10() {
        assertEquals(-1,ref.reverse(-10));
    }

    @Test
    void testMaxInt() {
//        assertEquals(7463847412, ref.reverse(Integer.MAX_VALUE));
    }

    @Test
    void testMinInt() {
//        assertEquals(1,ref.reverse(Integer.MIN_VALUE));
    }

}