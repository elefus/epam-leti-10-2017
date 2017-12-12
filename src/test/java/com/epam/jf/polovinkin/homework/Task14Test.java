package com.epam.jf.polovinkin.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task14Test {

    @Test
    void sortMatrixByValuesInColumn() {
        int[][] matrix = {
                {7, 8, 9},
                {4, 5, 6},
                {1, 2, 3}};
        int[][] res1 = new Task14().sortMatrixByValuesInColumn(matrix, 0);
        int[][] res2 = new Task14().sortMatrixByValuesInColumn(matrix, 1);
        int[][] res3 = new Task14().sortMatrixByValuesInColumn(matrix, 2);
        int[][][] reses = {res1, res2, res3};
        for (int[][] result : reses) {
            assertArrayEquals(new int[]{1, 2, 3}, result[0]);
            assertArrayEquals(new int[]{4, 5, 6}, result[1]);
            assertArrayEquals(new int[]{7, 8, 9}, result[2]);
        }

    }
}