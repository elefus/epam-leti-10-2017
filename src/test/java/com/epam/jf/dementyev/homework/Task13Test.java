package com.epam.jf.dementyev.homework;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        int[][] matrix = new Task13().createSquareMatrix(2);
        assertEquals(2, matrix.length);
        assertEquals(2, matrix[0].length);
        assertEquals(2, matrix[1].length);
        assertEquals(1, matrix[0][0]);
        assertEquals(2, matrix[0][1]);
        assertEquals(3, matrix[1][0]);
        assertEquals(4, matrix[1][1]);
    }

}