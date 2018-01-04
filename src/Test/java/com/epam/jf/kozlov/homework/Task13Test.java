package com.epam.jf.kozlov.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task13Test {

    @Test
    void zeroTest() {
        Task13 task = new Task13();
        assertNull(task.createSquareMatrix(0));
    }

    @Test
    void oneTest() {
        Task13 task = new Task13();
        assertArrayEquals(new int[][]{{1}}, task.createSquareMatrix(1));
    }

    @Test
    void twoTest() {
        Task13 task = new Task13();
        assertArrayEquals(new int[][]{{1, 2}, {3, 4}}, task.createSquareMatrix(2));
    }

    @Test
    void threeTest() {
        Task13 task = new Task13();
        assertArrayEquals(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, task.createSquareMatrix(3));
    }


}