package com.epam.jf.burachenko.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task14Test {
    @Test
    void testSortMatrixByValuesInColumnOfSingleLineMatrix() {
        int[][] matrix = {{2, 4, 7, 5, 7}};
        Task14 T = new Task14();
        int[][] newMatrix = T.sortMatrixByValuesInColumn(matrix, 3);
        assertArrayEquals(matrix, newMatrix);
    }

    @Test
    void testSortMatrixByValuesInColumnOfMultiplyLineMatrix() {
        int[][] matrix = {
                {2, 4, 7, 5, 7},
                {2, 3, 8, 4, 1},
                {3, 3, 7, 4, 8},
                {1, 4, 5, 8, 10},
                {3, 4, 8, 5, 10}};
        Task14 T = new Task14();

        assertArrayEquals(new int[][]{
                        {1, 4, 5, 8, 10},
                        {2, 4, 7, 5, 7},
                        {2, 3, 8, 4, 1},
                        {3, 3, 7, 4, 8},
                        {3, 4, 8, 5, 10}},
                T.sortMatrixByValuesInColumn(matrix, 0));

        assertArrayEquals(new int[][]{
                        {1, 4, 5, 8, 10},
                        {2, 4, 7, 5, 7},
                        {3, 3, 7, 4, 8},
                        {2, 3, 8, 4, 1},
                        {3, 4, 8, 5, 10}},
                        T.sortMatrixByValuesInColumn(matrix, 2));

        assertArrayEquals(new int[][]{
                        {2, 3, 8, 4, 1},
                        {3, 3, 7, 4, 8},
                        {2, 4, 7, 5, 7},
                        {3, 4, 8, 5, 10},
                        {1, 4, 5, 8, 10}},
                        T.sortMatrixByValuesInColumn(matrix, 3));
    }
}
