package com.epam.jf.kozlov.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task14Test {

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
        assertThrows(ArrayIndexOutOfBoundsException.class,() -> task.sortMatrixByValuesInColumn(new int[][]{{3, 2, 1}, {6, 5, 4}, {9, 8, 7}}, 3));
    }

}