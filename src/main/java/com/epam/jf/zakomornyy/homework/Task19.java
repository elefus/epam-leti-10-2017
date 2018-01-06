package com.epam.jf.zakomornyy.homework;

public class Task19 extends com.epam.jf.common.homework.Task19 {
    @Override
    public int[][] rotateMatrixCounterclockwise(int[][] source) {
        int[][] resultMatrix = new int[source[0].length][source.length];
        for(int i = 0; i < resultMatrix.length; i++) {
            for (int j = 0; j < resultMatrix[i].length; j++) {
                resultMatrix[i][j] = source[j][source[0].length - 1 - i];
            }
        }
        return resultMatrix;
    }
}
