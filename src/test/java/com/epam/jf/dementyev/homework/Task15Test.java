package com.epam.jf.dementyev.homework;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class Task15Test {

    @Test
    void testVerticalCyclicShift1() {
        int[][] matrix = {
            {1},
            {2},
            {3},
            {4},
            {5}
        };
        int[][] expected = {
            {4},
            {5},
            {1},
            {2},
            {3}
        };

        int[][] newMatrix = new Task15().verticalCyclicShift(matrix, 7);
        assertArrayEquals(expected, newMatrix);
    }

    @Test
    void testVerticalCyclicShift2() {
        int[][] matrix = {
            {1},
            {2},
            {3},
            {4},
            {5}
        };
        int[][] expected = {
            {3},
            {4},
            {5},
            {1},
            {2}
        };

        int[][] newMatrix = new Task15().verticalCyclicShift(matrix, -7);
        assertArrayEquals(expected, newMatrix);
    }

    @Test
    void testVerticalCyclicShift3() {
        Task15 obj = new Task15();
        int[][] matrix = {
            {1},
            {2},
            {3},
            {4},
            {5}
        };

        int[][] newMatrix = obj.verticalCyclicShift(matrix, 9999995);
        assertArrayEquals(matrix, newMatrix);
        newMatrix = obj.verticalCyclicShift(matrix, -644213575);
        assertArrayEquals(matrix, newMatrix);
    }

    @Test
    void testHorizontalCyclicShift1() {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6}
        };
        int[][] expected = {
            {2, 3, 1},
            {5, 6, 4}
        };

        int[][] newMatrix = new Task15().horizontalCyclicShift(matrix, 5);
        assertArrayEquals(expected, newMatrix);
    }

    @Test
    void testHorizontalCyclicShift2() {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6}
        };
        int[][] expected = {
            {3, 1, 2},
            {6, 4, 5}
        };

        int[][] newMatrix = new Task15().horizontalCyclicShift(matrix, -5);
        assertArrayEquals(expected, newMatrix);
    }

    @Test
    void testHorizontalCyclicShift3() {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6}
        };

        int[][] newMatrix = new Task15().horizontalCyclicShift(matrix, 513428151);
        assertArrayEquals(matrix, newMatrix);
        newMatrix = new Task15().horizontalCyclicShift(matrix, -93245499);
        assertArrayEquals(matrix, newMatrix);
    }

}