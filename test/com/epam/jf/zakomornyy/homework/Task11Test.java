package com.epam.jf.zakomornyy.homework;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class Task11Test {
    @Test
    void reverseTest1(){
        assertThrows(IllegalArgumentException.class,
                () -> new Task11().reverse(Integer.MAX_VALUE));
    }
    @Test
    void reverseTest2(){
        assertThrows(IllegalArgumentException.class,
                () -> new Task11().reverse(Integer.MIN_VALUE));
    }
    @Test
    void reverseTest3(){
        assertEquals(new Task11().reverse(1000), 1);
    }
    @Test
    void reverseTest4(){
        assertEquals(new Task11().reverse(10100), 101);
    }
    @Test
    void reverseTest5(){
        assertEquals(new Task11().reverse(-123), -321);
    }
    @Test
    void reverseTest6(){
        assertEquals(new Task11().reverse(0), 0);
    }
    @Test
    void reverseTest7(){
        assertEquals(new Task11().reverse(-5), -5);
    }
    @Test
    void reverseTest8(){
        assertEquals(new Task11().reverse(8), 8);
    }
}