package com.epam.jf.ilyinykh.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task13SolutionTest {
    @Test
    void createSquareMatrix() {
        Task13Solution task = new Task13Solution();
        int[][] squareMatrix = task.createSquareMatrix(2);
        int[][] ints = {{1, 2},{3, 4}};
        int[][] squareMatrix1 = task.createSquareMatrix(3);
        int[][] ints1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] squareMatrix2 = task.createSquareMatrix(4);
        int[][] ints2 = {{1, 2, 3, 4},{5, 6, 7, 8},{9, 10, 11, 12},{13, 14, 15, 16}};
        int[][] squareMatrix3 = task.createSquareMatrix(1);
        int[][] ints3 = {{1}};

        int[][] sqrM = squareMatrix;
        int[][] is = ints;
        for (int i = 0; i < is.length; i++) {
            for (int j = 0; j < is.length; j++) {
                System.out.print("[" + is[i][j] + " " + sqrM[i][j] + "]");
                assertTrue(is[i][j] == sqrM[i][j]);
            }
            System.out.println();
        }
        int[][] sqrM1 = squareMatrix1;
        int[][] is1 = ints1;
        for (int i = 0; i < is.length; i++) {
            for (int j = 0; j < is.length; j++) {
                System.out.print("[" + is[i][j] + " " + sqrM[i][j] + "]");
                assertTrue(is[i][j] == sqrM[i][j]);
            }
            System.out.println();
        }
        int[][] sqrM2 = squareMatrix2;
        int[][] is2 = ints2;
        for (int i = 0; i < is.length; i++) {
            for (int j = 0; j < is.length; j++) {
                System.out.print("[" + is[i][j] + " " + sqrM[i][j] + "]");
                assertTrue(is[i][j] == sqrM[i][j]);
            }
            System.out.println();
        }
        int[][] sqrM3 = squareMatrix3;
        int[][] is3 = ints3;
        for (int i = 0; i < is.length; i++) {
            for (int j = 0; j < is.length; j++) {
                System.out.print("[" + is[i][j] + " " + sqrM[i][j] + "]");
                assertTrue(is[i][j] == sqrM[i][j]);
            }
            System.out.println();
        }
    }

}