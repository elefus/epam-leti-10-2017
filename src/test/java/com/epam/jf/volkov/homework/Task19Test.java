package com.epam.jf.volkov.homework;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Task19Test {

    Task19 obj = new Task19();

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
        assertArrayEquals(expected, obj.rotateMatrixCounterclockwise(matrix));
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
        assertArrayEquals(expected, obj.rotateMatrixCounterclockwise(matrix));
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
        assertArrayEquals(expected, obj.rotateMatrixCounterclockwise(matrix));
    }

    @Test
    void test4() {
        int[][] matrix = {
            {1}
        };
        assertArrayEquals(matrix, obj.rotateMatrixCounterclockwise(matrix));
    }
}