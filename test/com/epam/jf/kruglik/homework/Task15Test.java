package com.epam.jf.kruglik.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task15Test {
    @Test
    void squareMatrixThreeOnThreeSizeHorizontalShiftOnOneStep() {
        int[][] matrix = {{1,2,3},
                          {4,5,6},
                          {7,8,9}};
        int[][] resultMatrix = {{3,1,2},
                                {6,4,5},
                                {9,7,8}};
        matrix = Task15.horizontalCyclicShift(matrix,1);
        assertArrayEquals(matrix,resultMatrix);
    }

    @Test
    void squareMatrixThreeOnThreeSizeVerticalShiftOnOneStep() {
        int[][] matrix = {{1,2,3},
                          {4,5,6},
                          {7,8,9}};
        int[][] resultMatrix = {{7,8,9},
                                {1,2,3},
                                {4,5,6}};
        matrix = Task15.verticalCyclicShift(matrix,1);
        assertArrayEquals(matrix,resultMatrix);
    }

    @Test
    void squareMatrixThreeOnThreeSizeHorizontalShiftOnFiveStep() {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] resultMatrix = {{2,3,1},{5,6,4},{8,9,7}};
        matrix = Task15.horizontalCyclicShift(matrix,5);
        assertArrayEquals(matrix,resultMatrix);
    }

    @Test
    void squareMatrixThreeOnThreeSizeVerticalShiftOnFiveStep() {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] resultMatrix = {{4,5,6},{7,8,9},{1,2,3}};
        matrix = Task15.verticalCyclicShift(matrix,5);
        assertArrayEquals(matrix,resultMatrix);
    }

    @Test
    void nonSquareMatrixThreeOnFourSizeHorizontalShiftOnSixStep() {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[][] resultMatrix = {{3,4,1,2},{7,8,5,6},{11,12,9,10}};
        matrix = Task15.horizontalCyclicShift(matrix,6);
        assertArrayEquals(matrix,resultMatrix);
    }

    @Test
    void nonSquareMatrixThreeOnFoutSizeHVerticalShiftOnFiveStep() {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[][] resultMatrix = {{5,6,7,8},{9,10,11,12},{1,2,3,4}};
        matrix = Task15.verticalCyclicShift(matrix,5);
        assertArrayEquals(matrix,resultMatrix);
    }


}