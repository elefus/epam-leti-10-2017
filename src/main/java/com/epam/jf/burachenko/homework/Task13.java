package com.epam.jf.burachenko.homework;

public class Task13 extends com.epam.jf.common.homework.Task13 {

    private int[] incrementEveryElementFor(int[] array, int increment) {
        int[] incrementedArray = new int[array.length];
        for(int i = 0; i < incrementedArray.length; i++) {
            incrementedArray[i] = array[i] + increment;
        }
        return incrementedArray;
    }

    @Override
    public int[][] createSquareMatrix(int dimension) {
        if(dimension == 0) {
            return null;
        }

        int Matrix[][] = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            Matrix[0][i] = i+1;
        }
        for (int i = 1; i < dimension; i++) {
            Matrix[i] = incrementEveryElementFor(Matrix[i-1], dimension);
        }
        return Matrix;
    }
}
