package com.epam.jf.kuchinskii.homework;

public class Task19 extends com.epam.jf.common.homework.Task19 {

    @Override
    public int[][] rotateMatrixCounterclockwise(int[][] source) {
        if (source.length == 0 || source[0].length == 0) {
            throw new IllegalArgumentException("Invalid matrix");
        }
        int[][] result = new int[source[0].length][source.length];

        for (int j = 0; j < source[0].length; j++) {
            for (int i = 0; i < source.length; i++) {
                result[j][i] = source[i][source[0].length - j - 1];
            }
        }
        return result;
    }
}
