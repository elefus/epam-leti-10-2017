package com.epam.jf.burachenko.homework;

public class Task19 extends com.epam.jf.common.homework.Task19 {
    @Override
    public int[][] rotateMatrixCounterclockwise(int[][] source) {
        int n = source.length;
        int m = source[0].length;
        int[][] newMatrix = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                newMatrix[m-j-1][i] = source[i][j];
            }
        }
        return newMatrix;
    }
}
