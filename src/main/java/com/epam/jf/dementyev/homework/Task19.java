package com.epam.jf.dementyev.homework;

public class Task19 extends com.epam.jf.common.homework.Task19 {

    @Override
    public int[][] rotateMatrixCounterclockwise(int[][] source) {
        if (source == null) {
            throw new IllegalArgumentException("source is null");
        }
        if (source.length == 0) {
            return new int[0][];
        }
        int width = source[0].length;
        int height = source.length;
        for (int[] x : source) {
            if (x.length != width) {
                throw new IllegalArgumentException("The array must be rectangular");
            }
        }
        int[][] matrix = new int[width][height];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrix[width - j - 1][i] = source[i][j];
            }
        }
        return matrix;
    }
}
