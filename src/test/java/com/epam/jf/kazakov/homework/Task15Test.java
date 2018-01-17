package com.epam.jf.kazakov.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task15Test {
    @Test
    void verticalCyclicShift() {
        Task15 test = new Task15();
        int[][] testMatrixOne = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        assertEquals(test.verticalCyclicShift(testMatrixOne, 2)[0][2], 6);
    }

    @Test
    void horizontalCyclicShift() {
        Task15 test = new Task15();
        int[][] testMatrixOne = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        assertEquals(test.horizontalCyclicShift(testMatrixOne, 2)[0][2], 1);
    }

}