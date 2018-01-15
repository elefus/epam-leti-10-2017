package com.epam.jf.yessenbayev.homework;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class Task13Test {
    @Test
    void testIllegalArg() {
        Task13 obj = new Task13();
        assertThrows(IllegalArgumentException.class, () -> obj.createSquareMatrix(-1));
        assertThrows(IllegalArgumentException.class, () -> obj.createSquareMatrix(0));
    }

    @Test
    void testResult() {
        int[][] matrix = new Task13().createSquareMatrix(5);

        int[][] expected = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        assertArrayEquals(expected, matrix);
    }
}