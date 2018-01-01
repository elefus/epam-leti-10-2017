package com.epam.jf.savchenkov.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Task15Test {
    @Test
    void verticalCyclicShift() {
        Task15 obj = new Task15();
        int[][] matrix = {{1,2,5,4,9}, {8,6,1,5,9}, {5,6,4,3,8}, {8,5,6,4,1}};
        int[][] matrix1 = {{5,6,4,3,8}, {8,5,6,4,1}, {1,2,5,4,9}, {8,6,1,5,9}};
        int[][] matrix2 = {{8,6,1,5,9}, {5,6,4,3,8}, {8,5,6,4,1}, {1,2,5,4,9}};

        assertArrayEquals(obj.verticalCyclicShift(matrix, -2), matrix1);
        assertArrayEquals(obj.verticalCyclicShift(matrix, 3), matrix2);
        assertArrayEquals(obj.verticalCyclicShift(matrix, 7), matrix2);
    }

    @Test
    void horizontalCyclicShift() {
        Task15 obj = new Task15();
        int[][] matrix = {{1,2,5,4,9}, {8,6,1,5,9}, {5,6,4,3,8}, {8,5,6,4,1}};
        int[][] matrix1 = {{2,5,4,9,1}, {6,1,5,9,8},{6,4,3,8,5}, {5,6,4,1,8}};
        int[][] matrix2 = {{5,4,9,1,2},{1,5,9,8,6}, {4,3,8,5,6}, {6,4,1,8,5}};

        assertArrayEquals(obj.horizontalCyclicShift(matrix, 4), matrix1);
        assertArrayEquals(obj.horizontalCyclicShift(matrix, -2), matrix2);
        assertArrayEquals(obj.horizontalCyclicShift(matrix, -7), matrix2);
    }
}