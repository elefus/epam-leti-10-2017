package com.epam.jf.kozlov.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task15Test {

    @Test
    void verticalZeroTest() {
        Task15 task = new Task15();
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] newMatrix = task.verticalCyclicShift(matrix, 0);
        assertArrayEquals(matrix, newMatrix);
    }

    @Test
    void horizontalZeroTest() {
        Task15 task = new Task15();
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] newMatrix = task.horizontalCyclicShift(matrix, 0);
        assertArrayEquals(matrix, newMatrix);
    }

    @Test
    void verticalThreeTest() {
        Task15 task = new Task15();
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] newMatrix = task.verticalCyclicShift(matrix, 3);
        assertArrayEquals(matrix, newMatrix);
    }

    @Test
    void horizontalThreeTest() {
        Task15 task = new Task15();
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] newMatrix = task.horizontalCyclicShift(matrix, 3);
        assertArrayEquals(matrix, newMatrix);
    }

    @Test
    void verticalMinusThreeTest() {
        Task15 task = new Task15();
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] newMatrix = task.verticalCyclicShift(matrix, -3);
        assertArrayEquals(matrix, newMatrix);
    }

    @Test
    void horizontalMinusThreeTest() {
        Task15 task = new Task15();
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] newMatrix = task.horizontalCyclicShift(matrix, -3);
        assertArrayEquals(matrix, newMatrix);
    }

    @Test
    void verticalTest() {
        Task15 task = new Task15();
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] newMatrix = task.verticalCyclicShift(matrix, 1);
        assertArrayEquals(new int[][]{{7, 8, 9}, {1, 2, 3}, {4, 5, 6}}, newMatrix);
    }

    @Test
    void horizontalTest() {
        Task15 task = new Task15();
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] newMatrix = task.horizontalCyclicShift(matrix, 1);
        assertArrayEquals(new int[][]{{3, 1, 2}, {6, 4, 5}, {9, 7, 8}}, newMatrix);
    }

    @Test
    void verticalMinusTest() {
        Task15 task = new Task15();
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] newMatrix = task.verticalCyclicShift(matrix, -1);
        assertArrayEquals(new int[][]{{4, 5, 6}, {7, 8, 9}, {1, 2, 3}}, newMatrix);
    }

    @Test
    void horizontalMinusTest() {
        Task15 task = new Task15();
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] newMatrix = task.horizontalCyclicShift(matrix, -1);
        assertArrayEquals(new int[][]{{2, 3, 1}, {5, 6, 4}, {8, 9, 7}}, newMatrix);
    }

    @Test
    void verticalFiveTest() {
        Task15 task = new Task15();
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] newMatrix = task.verticalCyclicShift(matrix, 5);
        assertArrayEquals(new int[][]{{4, 5, 6}, {7, 8, 9}, {1, 2, 3}}, newMatrix);
    }

    @Test
    void horizontalFiveTest() {
        Task15 task = new Task15();
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] newMatrix = task.horizontalCyclicShift(matrix, 5);
        assertArrayEquals(new int[][]{{2, 3, 1}, {5, 6, 4}, {8, 9, 7}}, newMatrix);
    }

    @Test
    void verticalMinusFiveTest() {
        Task15 task = new Task15();
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] newMatrix = task.verticalCyclicShift(matrix, -5);
        assertArrayEquals(new int[][]{{7, 8, 9}, {1, 2, 3}, {4, 5, 6}}, newMatrix);
    }

    @Test
    void horizontalMinusFiveTest() {
        Task15 task = new Task15();
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] newMatrix = task.horizontalCyclicShift(matrix, -5);
        assertArrayEquals(new int[][]{{3, 1, 2}, {6, 4, 5}, {9, 7, 8}}, newMatrix);
    }
}