package com.epam.jf.khvan.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Task15ImplementTest  {
    @Test
    void verticalShiftTest() {
        int[][] matrix = {{1,2,6},
                          {4,5,3},
                          {7,8,9}};
        int[][] resultMatrix = {{4,5,3},
                                {7,8,9},
                                {1,2,6}};

        int [][] matrixTest = new Task15Implement().verticalCyclicShift(matrix,2);
        assertArrayEquals(matrixTest,resultMatrix);
    }

    @Test
    void verticalNegativeShiftTest() {
        int[][] matrix =     {{1,2,6},
                              {4,5,3},
                              {7,8,9}};
        int[][] resultMatrix =         {{4,5,3},
                                        {7,8,9},
                                        {1,2,6}};

        int [][] matrixTest = new Task15Implement().verticalCyclicShift(matrix,-1);
        assertArrayEquals(matrixTest,resultMatrix);
    }
    @Test
    void horizontalShiftTest() {
        int[][] matrix = {{1,8,6},
                          {4,5,3},
                          {7,2,9}};
        int[][] resultMatrix = {{6,1,8},
                                {3,4,5},
                                {9,7,2}};
        int [][] matrixTest =new Task15Implement().horizontalCyclicShift(matrix,1);
        assertArrayEquals(matrixTest,resultMatrix);

    }

    @Test
    void horizontalNegativeShiftTest() {
        int[][] matrix = {{1,8,6},
                          {4,5,3},
                          {7,2,9}};
        int[][] resultMatrix = {{6,1,8},
                                {3,4,5},
                                {9,7,2}};
        int [][] matrixTest =new Task15Implement().horizontalCyclicShift(matrix,-2);
        assertArrayEquals(matrixTest,resultMatrix);

    }
}
