package com.epam.jf.burachenko.homework;

public class Task19 extends com.epam.jf.common.homework.Task19 {
    @Override
    public int[][] rotateMatrixCounterclockwise(int[][] source) {
        int[][] newMatrix = new int[source[0].length][source.length];
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source[0].length; j++) {
                newMatrix[source[0].length-j-1][i] = source[i][j];
            }
        }
        return newMatrix;
    }
}
