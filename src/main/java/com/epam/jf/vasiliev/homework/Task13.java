package com.epam.jf.vasiliev.homework;

public class Task13 extends com.epam.jf.common.homework.Task13 {

    @Override
    public int[][] createSquareMatrix(int dimension) {
        int[][] matrix = new int[dimension][dimension];

        for (int j = 0; j < dimension; j++) {
            int newElem = j+1;
            for (int i = 0; i < dimension; i++, newElem += dimension) {
                matrix[i][j] = newElem;
            }
        }
        return matrix;
    }
}
