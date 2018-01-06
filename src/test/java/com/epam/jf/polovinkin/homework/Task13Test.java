package com.epam.jf.polovinkin.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task13Test {

    @Test
    void createSquareMatrix1x1() {
        int[][] matrix = new Task13().createSquareMatrix(1);
        assertArrayEquals(new int[]{1}, matrix[0]);
    }

    @Test
    void createSquareMatrix2x2() {
        int[][] matrix = new Task13().createSquareMatrix(2);
        assertArrayEquals(new int[]{1, 2}, matrix[0]);
        assertArrayEquals(new int[]{3, 4}, matrix[1]);
    }

    @Test
    void createSquareMatrix3x3() {
        int[][] matrix = new Task13().createSquareMatrix(3);
        assertArrayEquals(new int[]{1, 2, 3}, matrix[0]);
        assertArrayEquals(new int[]{4, 5, 6}, matrix[1]);
        assertArrayEquals(new int[]{7, 8, 9}, matrix[2]);
    }

    @Test
    void createSquareMatrix4x4() {
        int[][] matrix = new Task13().createSquareMatrix(4);
        assertArrayEquals(new int[]{1, 2, 3, 4}, matrix[0]);
        assertArrayEquals(new int[]{5, 6, 7, 8}, matrix[1]);
        assertArrayEquals(new int[]{9, 10, 11, 12}, matrix[2]);
        assertArrayEquals(new int[]{13, 14, 15, 16}, matrix[3]);

    }
}