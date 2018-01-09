package com.epam.jf.kozlov.homework;

public class Task19 extends com.epam.jf.common.homework.Task19 {
    /**
     * Поворачивает матрицу на 90 градусов против часовой стрелки.
     * @param source Исходная матрица.
     * @return Новая матрица, элементы которой получены путем поворота исходной.
     */
    public int[][] rotateMatrixCounterclockwise(int[][] source) {
        if (source.length == 0) {
            return new int[][]{};
        }
        int[][] newMatrix = new int[source[0].length][source.length];
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source[i].length; j++) {
                newMatrix[(source[i].length - 1) - j][i] = source[i][j];
            }
        }
        return newMatrix;
    }
}
