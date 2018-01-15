package com.epam.jf.yessenbayev.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task15Test {
    Task15 tester = new Task15();

    @Test
    void Test0() {
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {0, 0, 0}

        };
        assertArrayEquals(array, tester.verticalCyclicShift(array, 0));
        assertArrayEquals(array, tester.verticalCyclicShift(array, 4));
        assertArrayEquals(array, tester.verticalCyclicShift(array, 8));
        assertArrayEquals(array, tester.verticalCyclicShift(array, -4));
        assertArrayEquals(array, tester.verticalCyclicShift(array, -8));

    }

    @Test
    void Test1() {
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {0, 0, 0}

        };
        int[][] changedArray = {
                {0, 0, 0},
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},

        };
        assertArrayEquals(array, tester.verticalCyclicShift(changedArray, 3));
        assertArrayEquals(array, tester.verticalCyclicShift(changedArray, 7));
        assertArrayEquals(array, tester.verticalCyclicShift(changedArray, -1));
        assertArrayEquals(array, tester.verticalCyclicShift(changedArray, -5));

    }
}