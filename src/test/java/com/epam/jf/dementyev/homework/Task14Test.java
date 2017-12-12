package com.epam.jf.dementyev.homework;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class Task14Test {

    @Test
    void testIllegalArgs() {
        Task14 obj = new Task14();
        assertThrows(IllegalArgumentException.class, () -> obj.sortMatrixByValuesInColumn(null, 0));
        assertThrows(IllegalArgumentException.class, () -> obj.sortMatrixByValuesInColumn(new int[1][1], -1));
    }

    @Test
    void test1() {
        Task14 obj = new Task14();
        int[][] matrix = {
            {4, 5, 6},
            {2, 3},
            {1}
        };
        int[][] expected = {
            {1},
            {2, 3},
            {4, 5, 6}
        };

        int[][] newMatrix = obj.sortMatrixByValuesInColumn(matrix, 1);
        assertArrayEquals(expected, newMatrix);
    }

    @Test
    void test2() {
        Task14 obj = new Task14();
        int[][] matrix = {
            {80, 2},
            {80, 0},
            {40, 25}
        };
        int[][] expected = {
            {40, 25},
            {80, 2},
            {80, 0}
        };

        int[][] newMatrix = obj.sortMatrixByValuesInColumn(matrix, 0);
        assertArrayEquals(expected, newMatrix);
    }

}