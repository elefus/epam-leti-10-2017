package com.epam.jf.Guyo.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task14Test {

    @Test
    void sortMatrixByValuesInColumn() {
        Task14 task14 = new Task14();
        int[][] matrix = {{5, 7, 3, 10}, {2, 8, 6, 0}, {9, 0, 1, 10}};
        int[][] matrixSortedByFirstColumn = {{2, 8, 6, 0}, {5, 7, 3, 10}, {9, 0, 1, 10}};
        int[][] matrixSortedBySecondColumn = {{9, 0, 1, 10}, {5, 7, 3, 10}, {2, 8, 6, 0}};
        int[][] matrixSortedByThirdColumn = {{9, 0, 1, 10}, {5, 7, 3, 10}, {2, 8, 6, 0}};
        int[][] matrixSortedByFourthColumn = {{2, 8, 6, 0}, {5, 7, 3, 10}, {9, 0, 1, 10}};

        assertArrayEquals(matrixSortedByFirstColumn, task14.sortMatrixByValuesInColumn(matrix, 0));
        assertArrayEquals(matrixSortedBySecondColumn, task14.sortMatrixByValuesInColumn(matrix, 1));
        assertArrayEquals(matrixSortedByThirdColumn, task14.sortMatrixByValuesInColumn(matrix, 2));
        assertArrayEquals(matrixSortedByFourthColumn, task14.sortMatrixByValuesInColumn(matrix, 3));
    }
}