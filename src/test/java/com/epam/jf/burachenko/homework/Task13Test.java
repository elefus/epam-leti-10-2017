package com.epam.jf.burachenko.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task13Test {

    @Test
    void zeroDimensionTest() {
        Task13 T = new Task13();
        assertNull(T.createSquareMatrix(0));
    }

    @Test
    void firstDimensionTest() {
        Task13 T = new Task13();
        assertArrayEquals(new int[][]{{1}}, T.createSquareMatrix(1));
    }

    @Test
    void secondDimensionTest() {
        Task13 T = new Task13();
        assertArrayEquals(new int[][]{{1, 2}, {3, 4}}, T.createSquareMatrix(2));
    }

    @Test
    void thirdDimensionTest() {
        Task13 T = new Task13();
        assertArrayEquals(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, T.createSquareMatrix(3));
    }
}