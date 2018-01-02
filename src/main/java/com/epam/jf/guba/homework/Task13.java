package com.epam.jf.guba.homework;

public class Task13 extends com.epam.jf.common.homework.Task13 {

    @Override
    public int[][] createSquareMatrix(int dimension) {
        if(dimension <= 0) {
            throw new IllegalArgumentException("Expected > 0. Actual: " + dimension);
        }
        int[][] matrix = new int[dimension][dimension];
        int startNum = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = startNum++;
            }
        }
        return matrix;
    }
}
