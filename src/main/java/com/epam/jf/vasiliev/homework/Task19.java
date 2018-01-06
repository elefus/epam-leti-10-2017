package com.epam.jf.vasiliev.homework;

public class Task19 extends com.epam.jf.common.homework.Task19 {

    /**
     * Поворачивает матрицу на 90 градусов против часовой стрелки.
     * @param source Исходная матрица.
     * @return Новая матрица, элементы которой получены путем поворота исходной.
     */
    @Override
    public int[][] rotateMatrixCounterclockwise(int[][] source) {
        int columns = source.length;
        int rows = columns != 0 ? source[0].length : 0;
        int[][] res = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                res[i][j] = source[j][rows-(i+1)];
            }
        }
        return res;
    }
}
