package com.epam.jf.khvan.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Task14ImplementTest {

    @Test
    void sortByColumnTest1() {
        int[][] resultMatrix = {{1,2,3},
                                {4,5,6},
                                {7,8,9}};
        int[][] exampleMatrix = {{4,5,6},
                                 {1,2,3},
                                 {7,8,9}};

        int [][] matrixTest = new Task14Implement().sortMatrixByValuesInColumn(exampleMatrix,2);
        assertArrayEquals(matrixTest,resultMatrix);
    }
    @Test
    void sortByColumnTest2() {
        int[][] resultMatrix = {{1,2,3},
                                {4,5,6},
                                {7,8,9},
                                {4,1,9}};
        int[][] exampleMatrix = {{7,8,9},
                                 {1,2,3},
                                 {4,5,6},
                                 {4,1,9},};

        int [][] matrixTest = new Task14Implement().sortMatrixByValuesInColumn(exampleMatrix,2);
        assertArrayEquals(matrixTest,resultMatrix);
    }

}

