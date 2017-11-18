package com.epam.jf.khvan.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Task13ImplementTest {
    @Test
    void createSquareMatrixTest() {
        int[][] resultMatrix = {{1,2,3},
                                {4,5,6},
                                {7,8,9}};

        int [][] matrixTest = new Task13Implement().createSquareMatrix(3);
        assertArrayEquals(matrixTest,resultMatrix);
    }
    @Test
    void createSquareMatrixFourTest() {
        int[][] resultMatrix = {{1,2,3,4},
                                {5,6,7,8},
                                {9,10,11,12},
                                {13,14,15,16}};

        int [][] matrixTest = new Task13Implement().createSquareMatrix(4);
        assertArrayEquals(matrixTest,resultMatrix);
    }

}
