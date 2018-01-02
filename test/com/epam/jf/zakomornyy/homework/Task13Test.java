package com.epam.jf.zakomornyy.homework;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task13Test {
    @Test
    void createSquareMatrix() {
        int[][] squareMatrix = new Task13().createSquareMatrix(3);
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                assertEquals(matrix[i][j], squareMatrix[i][j]);
            }
        }
    }

}