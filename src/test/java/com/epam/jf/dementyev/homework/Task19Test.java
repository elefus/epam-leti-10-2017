package com.epam.jf.dementyev.homework;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class Task19Test {

    @Test
    void test1() {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8}
        };

        int[][] expected = {
            {4, 8},
            {3, 7},
            {2, 6},
            {1, 5}
        };

        assertArrayEquals(expected, new Task19().rotateMatrixCounterclockwise(matrix));
    }

    @Test
    void test2() {
        int[][] matrix = {
            {1, 2, 3, 4}
        };

        int[][] expected = {
            {4},
            {3},
            {2},
            {1}
        };

        assertArrayEquals(expected, new Task19().rotateMatrixCounterclockwise(matrix));
    }

    @Test
    void test3() {
        int[][] matrix = {
            {1},
            {2},
            {3},
            {4}
        };

        int[][] expected = {
            {1, 2, 3, 4}
        };

        assertArrayEquals(expected, new Task19().rotateMatrixCounterclockwise(matrix));
    }

    @Test
    void test4() {
        int[][] matrix = {
            {1}
        };

        assertArrayEquals(matrix, new Task19().rotateMatrixCounterclockwise(matrix));
    }

    @Test
    void test5() {
        int[][] matrix = {
            {2, 3},
            {4}
        };
        assertThrows(IllegalArgumentException.class, () -> new Task19().rotateMatrixCounterclockwise(matrix));
    }

}