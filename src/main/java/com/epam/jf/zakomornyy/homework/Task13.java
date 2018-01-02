package com.epam.jf.zakomornyy.homework;

public class Task13 extends com.epam.jf.common.homework.Task13 {

    @Override
    public int[][] createSquareMatrix(int dimension) {
        int[][] ints = new int[dimension][dimension];
        int counter = 1;
        for(int i = 0; i < dimension; i++) {
            for(int j = 0; j < dimension; j++) {
                ints[i][j] = counter++;
            }
        }
        return ints;
    }
}
