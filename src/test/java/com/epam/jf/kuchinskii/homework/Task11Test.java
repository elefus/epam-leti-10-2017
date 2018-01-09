package com.epam.jf.kuchinskii.homework;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class Task11Test {

    @Test
    void testZero(){
        Task11 tester = new Task11();
        int result = tester.reverse(0);
        assertEquals(result, 0);
    }

    @Test
    void testValue(){
        Task11 tester = new Task11();
        int result = tester.reverse(123456789);
        assertEquals(result, 987654321);
    }

    @Test
    void testZeroesValue(){
        Task11 tester = new Task11();
        int result = tester.reverse(12345000);
        assertEquals(result, 54321);
    }

    @Test
    void testMaxIntValue(){
        Task11 tester = new Task11();
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                tester.reverse(Integer.MAX_VALUE);
            }
        });
    }

    @Test
    void testMinIntValue(){
        Task11 tester = new Task11();
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                tester.reverse(Integer.MIN_VALUE);
            }
        });
    }
}
