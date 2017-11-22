package com.epam.jf.yessenbayev.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task11Test {
    Task11 test = new Task11();

    @Test
    void test2() {
        assertEquals(12, test.reverse(21));
    }

    @Test
    void test3() {
        assertEquals(12345, test.reverse(54321));
    }

    @Test
    void test4() {
        assertEquals(987654321, test.reverse(123456789));
    }

    @Test
    void test5() {
        assertEquals(0, test.reverse(0));
    }

    @Test
    void test6() {
        assertEquals(-231, test.reverse(-132));
    }

}