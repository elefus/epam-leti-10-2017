package com.epam.jf.savchenkov.homework;

public class Task19 extends com.epam.jf.common.homework.Task19 {

    @Override
    public int[][] rotateMatrixCounterclockwise(int[][] source) {
        int line = source.length;
        int column = source[0].length;
        int[][] result = new int[column][line];
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < column; j++) {
                result[j][i] = source[i][column - j - 1];
            }
        }
        return result;
    }
}
