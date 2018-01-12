package com.epam.jf.zakomornyy.homework;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task15Test {
    @Test
    void verticalCyclicShift() {
        int[][] matrix = {{2,8,4,7}, {4, 3, 6, 10}, {5 ,17, 8, 0}};
        int[][] ints = new Task15().verticalCyclicShift(matrix, -4);
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 4; j++) {
                assertEquals(matrix[i][j], ints[i][j]);
            }
        }
    }

    @Test
    void verticalCyclicShift2() {
        int[][] matrix = {{2,8,4,7}, {4, 3, 6, 10}, {5 ,17, 8, 0}};
        int[][] ints = new Task15().verticalCyclicShift(matrix, 2);
        matrix = new int[][]{{4, 7, 2, 8}, {6, 10, 4, 3}, {8, 0, 5, 17}};
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 4; j++) {
                assertEquals(matrix[i][j], ints[i][j]);
            }
        }
    }


    @Test
    void horisontalCyclicShift() {
        int[][] matrix = {{2,8,4,7}, {4, 3, 6, 10}, {5 ,17, 8, 0}};
        int[][] ints = new Task15().horizontalCyclicShift(matrix, -3);
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 4; j++) {
                assertEquals(matrix[i][j], ints[i][j]);
            }
        }
    }

    @Test
    void horisontalCyclicShift2() {
        int[][] matrix = {{2,8,4,7}, {4, 3, 6, 10}, {5 ,17, 8, 0}};
        int[][] ints = new Task15().horizontalCyclicShift(matrix, 2);
        matrix = new int[][]{{4, 3, 6, 10}, {5 ,17, 8, 0}, {2,8,4,7}};
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 4; j++) {
                assertEquals(matrix[i][j], ints[i][j]);
            }
        }
    }
}