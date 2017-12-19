package com.epam.jf.Guyo.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task13Test {
    @Test
    void testInputMatrix() {
        Task13 task13 = new Task13();
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        assertArrayEquals(matrix, task13.createSquareMatrix(3));
    }

}