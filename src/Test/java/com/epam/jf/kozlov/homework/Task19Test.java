package com.epam.jf.kozlov.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task19Test {

    @Test
    void oneRowMatrixTest() {
        Task19 task = new Task19();
        int[][] matrix = task.rotateMatrixCounterclockwise(new int[][]{{1, 3, 4}});
        assertArrayEquals(new int[][]{{4}, {3}, {1}}, matrix);
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
        int[][] matrix = task.rotateMatrixCounterclockwise(new int[][]{{1}, {2}, {3}});
        assertArrayEquals(new int[][]{{1, 2, 3}}, matrix);
    }

    @Test
    void rectangularMatrixTest() {
        Task19 task = new Task19();
        int[][] matrix = task.rotateMatrixCounterclockwise(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}});
        assertArrayEquals(new int[][]{{4, 8, 12}, {3, 7, 11}, {2, 6, 10}, {1, 5, 9}}, matrix);
    }

    @Test
    void rectangularMatrixTest2() {
        Task19 task = new Task19();
        int[][] matrix = task.rotateMatrixCounterclockwise(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}});
        assertArrayEquals(new int[][]{{3, 6, 9, 12}, {2, 5, 8, 11}, {1, 4, 7, 10}}, matrix);
    }

    @Test
    void emptyMatrixTest() {
        Task19 task = new Task19();
        int[][] matrix = task.rotateMatrixCounterclockwise(new int[][]{});
        assertArrayEquals(new int[][]{}, matrix);
    }
}