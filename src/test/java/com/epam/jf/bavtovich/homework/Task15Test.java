package com.epam.jf.bavtovich.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Task15Test {
    @Test
    void verticalCyclicShift() {
        Task15 obj = new Task15();
        int[][] matr = {{1,2,5,4,9}, {8,6,1,5,9}, {5,6,4,3,8}, {8,5,6,4,1}};
        int[][] matr1 = {{5,6,4,3,8}, {8,5,6,4,1}, {1,2,5,4,9}, {8,6,1,5,9}};
        int[][] matr2 = {{8,6,1,5,9}, {5,6,4,3,8}, {8,5,6,4,1}, {1,2,5,4,9}};

        assertArrayEquals(obj.verticalCyclicShift(matr, -2), matr1);
        assertArrayEquals(obj.verticalCyclicShift(matr, 3), matr2);
        assertArrayEquals(obj.verticalCyclicShift(matr, 7), matr2);
    }

    @Test
    void horizontalCyclicShift() {
        Task15 obj = new Task15();
        int[][] matr = {{1,2,5,4,9}, {8,6,1,5,9}, {5,6,4,3,8}, {8,5,6,4,1}};
        int[][] matr1 = {{2,5,4,9,1}, {6,1,5,9,8},{6,4,3,8,5}, {5,6,4,1,8}};
        int[][] matr2 = {{5,4,9,1,2},{1,5,9,8,6}, {4,3,8,5,6}, {6,4,1,8,5}};

        assertArrayEquals(obj.horizontalCyclicShift(matr, 4), matr1);
        assertArrayEquals(obj.horizontalCyclicShift(matr, -2), matr2);
        assertArrayEquals(obj.horizontalCyclicShift(matr, -7), matr2);
    }

}