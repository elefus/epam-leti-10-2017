package com.epam.jf.burachenko.homework;

public class Task13 extends com.epam.jf.common.homework.Task13 {

    @Override
    public int[][] createSquareMatrix(int dimension) {
        if(dimension == 0) {
            return null;
        }

        int count = 1;
        int Matrix[][] = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                Matrix[i][j] = count++;
            }
        }
        return Matrix;
    }
}
