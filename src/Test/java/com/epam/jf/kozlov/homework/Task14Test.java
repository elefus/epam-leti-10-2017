package com.epam.jf.kozlov.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task14Test {

    @Test
    void nonRectangularMatrixTest() {
        Task14 task = new Task14();
        int[][] matrix = task.sortMatrixByValuesInColumn(new int[][]{{1, 2, 3, 4}, {4, 5, 6}, {1, 2}}, 1);
        assertArrayEquals(new int[][]{{1, 2, 3, 4}, {1, 2}, {4, 5, 6}}, matrix);
    }

    @Test
    void oneRowMatrixTest() {
        Task14 task = new Task14();
        int[][] matrix = task.sortMatrixByValuesInColumn(new int[][]{{1, 3, 4}}, 0);
        assertArrayEquals(new int[][]{{1, 3, 4}}, matrix);
    }

    @Test
    void squareMatrixTest() {
        Task14 task = new Task14();
        int[][] matrix = task.sortMatrixByValuesInColumn(new int[][]{{9, 8, 7}, {6, 5, 4}, {3, 2, 1}}, 2);
        assertArrayEquals(new int[][]{{3, 2, 1}, {6, 5, 4}, {9, 8, 7}}, matrix);
    }

    @Test
    void arrayIndexOutOfBoundsTestMatrixTest() {
        Task14 task = new Task14();
        assertThrows(ArrayIndexOutOfBoundsException.class,() -> task.sortMatrixByValuesInColumn(new int[][]{{1, 2, 3, 4}, {4, 5, 6}, {1, 2}}, 2));
    }

}