package com.epam.jf.polovinkin.homework;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Task19Test {

    @Test
    void rotateMatrixCounterclockwise3x3() {
        int[][] matrix = {{1, 2, 3},
                          {4, 5, 6},
                          {7, 8, 9}};
        int[][] arr = new Task19().rotateMatrixCounterclockwise(matrix);

        assertArrayEquals(new int[]{3, 6, 9}, arr[0]);
        assertArrayEquals(new int[]{2, 5, 8}, arr[1]);
        assertArrayEquals(new int[]{1, 4, 7}, arr[2]);
    }

    @Test
    void rotateMatrixCounterclockwise2x2() {
        int[][] matrix = {{5, 6},
                          {8, 9}};
        int[][] arr = new Task19().rotateMatrixCounterclockwise(matrix);

        assertArrayEquals(new int[]{6, 9}, arr[0]);
        assertArrayEquals(new int[]{5, 8}, arr[1]);
    }

    @Test
    void rotateMatrixCounterclockwise1x1() {
        int[][] matrix = {{9}};
        int[][] arr = new Task19().rotateMatrixCounterclockwise(matrix);

        assertArrayEquals(new int[]{9}, arr[0]);
    }
}