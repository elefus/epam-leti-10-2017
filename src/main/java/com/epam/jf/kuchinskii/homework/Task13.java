package com.epam.jf.kuchinskii.homework;

public class Task13 extends com.epam.jf.common.homework.Task13 {

    @Override
    public int[][] createSquareMatrix(int dimension) {
        //46340 = sqrt(Integer.MAX_VALUE)
        if (dimension > 46340 || dimension < 0) {
            throw new IllegalArgumentException("Argument too big or negative.");
        }

        int[][] result = new int[dimension][dimension];
        int count = 1;

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                result[i][j] = count++;
            }
        }
        return result;
    }
}
