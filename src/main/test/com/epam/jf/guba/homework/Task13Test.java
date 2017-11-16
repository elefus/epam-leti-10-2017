package com.epam.jf.guba.homework;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class Task13Test {

    @Test
    public void testExceptionThrows() {
        Task13 task13 = new Task13();
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                task13.createSquareMatrix(-1);
            }
        });
    }

    @Test
    void testSingleDimension() {
        Task13 task13 = new Task13();
        assertEquals(1, task13.createSquareMatrix(1).length);
    }


    @Test
    void testSomeDimension() {
        Task13 task13 = new Task13();
        assertEquals(9, task13.createSquareMatrix(3)[2][2]);
    }

    @Test
    void testtSomeDimensionSize(){
        Task13 task13 = new Task13();
        assertEquals(9, task13.createSquareMatrix(9)[8].length);
    }


}