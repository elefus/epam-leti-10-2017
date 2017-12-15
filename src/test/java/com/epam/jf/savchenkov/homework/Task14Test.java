package com.epam.jf.savchenkov.homework;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class Task14Test {

    Task14 task = new Task14();
    private static int matrix[][] = {
            {7, 9, 9},
            {-1, 4, 48},
            {-55, 88, 8}
    };

    @Test
    void testException() {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                task.sortMatrixByValuesInColumn(new int[3][3], -1);
            }
        });
    }

    @Test
    void testWithNegative() {
        assertEquals(-1, task.sortMatrixByValuesInColumn(matrix, 0)[1][0]);
    }

    @Test
    void testWithoutNegative() {
        assertEquals(9, task.sortMatrixByValuesInColumn(matrix, 1)[1][1]);
    }
}