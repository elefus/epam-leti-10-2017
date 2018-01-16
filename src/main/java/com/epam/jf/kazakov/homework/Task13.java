package com.epam.jf.kazakov.homework;

public class Task13 extends com.epam.jf.common.homework.Task13 {

    @Override
    public int[][] createSquareMatrix(int dimension) {
        int[][] squareMatrix = new int[dimension][dimension];

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                squareMatrix[i][j] = i * dimension + j + 1;
            }
        }

        return squareMatrix;
    }
}