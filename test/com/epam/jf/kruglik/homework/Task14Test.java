package com.epam.jf.kruglik.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task14Test {
    @Test
    void threeOrderMatrixSecondColumn() {
        int[][] matrix = {{1,2,6},
                          {4,5,3},
                          {7,8,9}};
        int[][] resultMatrix = {{4,5,3},
                                {1,2,6},
                                {7,8,9}};

        matrix = Task14.sortMatrixByValuesInColumn(matrix,2);
        assertArrayEquals(matrix,resultMatrix);
    }

    @Test
    void threeOrderMatrixFirstColumn() {
        int[][] matrix = {{1,8,6},
                          {4,5,3},
                          {7,2,9}};
        int[][] resultMatrix = {{7,2,9},
                                {4,5,3},
                                {1,8,6}};

        matrix = Task14.sortMatrixByValuesInColumn(matrix,1);
        assertArrayEquals(matrix,resultMatrix);
    }

}