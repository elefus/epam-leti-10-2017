package com.epam.jf.ilyinykh.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task15SolutionTest {
    @Test
    void verticalCyclicShift() {
        int[][] matr = {{1, 2}, {2, 1}};
        matr = new Task15Solution().verticalCyclicShift(matr, 1);
        assertTrue(matr[0][0] == 2);
    }

    @Test
    void horizontalCyclicShift() {
        int[][] matr = {{1, 2, 3}, {2, 1, 3}};
        matr = new Task15Solution().horizontalCyclicShift(matr, 1);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matr[i][j] + " ");
            }
            System.out.println();
        }
        assertTrue(matr[0][0] == 3);
    }
}