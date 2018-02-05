package com.epam.jf.volkov.homework;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task11Test {

    Task11 task = new Task11();

    @Test
    void reverseTest1() {
        assertEquals(123, task.reverse(321));
    }

    @Test
    void reverseTest2() {
        assertEquals(5_000_005, task.reverse(5_000_005));
    }

    @Test
    void reverseTest3() {
        assertEquals(0, task.reverse(0));
    }

    @Test
    void reverseTest4() {
        assertEquals(1, task.reverse(1));
    }

    @Test
    void reverseTest5() {
        assertEquals(12, task.reverse(21));
    }

    @Test
    void reverseTest6() {
        assertEquals(12, task.reverse(2100));
    }

}