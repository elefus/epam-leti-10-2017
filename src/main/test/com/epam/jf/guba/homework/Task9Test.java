package com.epam.jf.guba.homework;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class Task9Test {

    Task9 task9 = new Task9();

    @Test
    void testZeroValue() {
        assertFalse(task9.isPowerOfTwo(0));
    }

    @Test
    void testMaxLongValue() {
        assertFalse(task9.isPowerOfTwo(Long.MAX_VALUE));
    }


    @Test
    void testThrowsIllegelArgumentException() {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                task9.isPowerOfTwo(-1);
            }
        });
    }

    @Test
    void checkSeveralPowersOfTwo(){
        long candidat = 1;
        for(int i = 0; i < 20; i++){
            assertTrue(task9.isPowerOfTwo(candidat));
            candidat *= 2;
        }
    }


    @Test
    void checkSeveralNotPowersOfTwo(){
        long candidat = 3;
        for(int i = 0; i < 20; i++){
            assertFalse(task9.isPowerOfTwo(candidat));
            candidat *= 2;
        }
    }


}