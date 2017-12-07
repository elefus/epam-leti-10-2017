package com.epam.jf.ilyinykh.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task19SolTest {
    @Test
    void rotateMatrixCounterclockwise() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8 ,9}};
        matrix = new Task19Sol().rotateMatrixCounterclockwise(matrix);
        assertEquals(matrix[0][0], 3);
        assertEquals(matrix[2][2], 7);
    }

}