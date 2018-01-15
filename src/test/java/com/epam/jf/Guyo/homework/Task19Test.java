package com.epam.jf.Guyo.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task19Test {

    Task19 task19 = new Task19();

    @Test
    void rotateMatrix2X4() {
        int[][] source = {{11, 12, 13, 14}, {21, 22, 23, 24}};
        int[][] output = {{14, 24}, {13, 23}, {12, 22}, {11, 21}};
        assertArrayEquals(task19.rotateMatrixCounterclockwise(source), output);
    }

    @Test
    void rotateMatrix1X1() {
        int[][] source = {{11, 12}, {21, 22}};
        int[][] output = {{12, 22}, {11, 21}};
        assertArrayEquals(task19.rotateMatrixCounterclockwise(source), output);
    }

    @Test
    void rotateMatrix3X3() {
        int[][] source = {{5, 0, 6}, {7, 8, 9}, {1, 0, 1}};
        int[][] output = {{6, 9, 1}, {0, 8, 0}, {5, 7, 1}};
        assertArrayEquals(task19.rotateMatrixCounterclockwise(source), output);
    }
}