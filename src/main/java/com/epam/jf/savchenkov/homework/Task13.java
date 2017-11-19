package com.epam.jf.savchenkov.homework;

public class Task13 extends com.epam.jf.common.homework.Task13 {

    @Override
    public int[][] createSquareMatrix(int dimension) {
        int[][] matrix = new int[dimension][dimension];

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                matrix[i][j] = dimension * i + j + 1;
            }
        }

        return matrix;
    }
}