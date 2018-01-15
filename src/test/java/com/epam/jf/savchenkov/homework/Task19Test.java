package com.epam.jf.savchenkov.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task19Test {

    @Test
    void commonTest() {
        Task19 task = new Task19();
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        printMatrix(matrix);
        printMatrix(task.rotateMatrixCounterclockwise(matrix));
    }

    @Test
    void oneLineMatrixTest() {
        Task19 task = new Task19();
        int[][] matrix = task.rotateMatrixCounterclockwise(new int[][]{{1, 3, 5}});
        assertArrayEquals(new int[][]{{5}, {3}, {1}}, matrix);
    }

    @Test
    void squareMatrixTest() {
        Task19 task = new Task19();
        int[][] matrix = task.rotateMatrixCounterclockwise(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        assertArrayEquals(new int[][]{{3, 6, 9}, {2, 5, 8}, {1, 4, 7}}, matrix);
    }

    @Test
    void oneColumnMatrixTest() {
        Task19 task = new Task19();
        int[][] matrix = task.rotateMatrixCounterclockwise(new int[][]{{1}, {3}, {5}});
        assertArrayEquals(new int[][]{{1, 3, 5}}, matrix);
    }

    @Test
    void rotateMatrixTest() {
        Task19 task = new Task19();
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
                {10,11,12},
                {13,14,15}
        };
        int[][] answer = {
                {3, 6, 9, 12, 15},
                {2, 5, 8, 11, 14},
                {1, 4, 7, 10, 13}
        };
        assertArrayEquals(answer, task.rotateMatrixCounterclockwise(matrix));
    }

    void printMatrix(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}