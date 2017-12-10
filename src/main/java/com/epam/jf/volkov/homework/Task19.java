package com.epam.jf.volkov.homework;

public class Task19 {

    /**
     * Поворачивает матрицу на 90 градусов против часовой стрелки.
     * @param source Исходная матрица.
     * @return Новая матрица, элементы которой получены путем поворота исходной.
     */
    public int[][] rotateMatrixCounterclockwise(int[][] source) {
        int[][] newMatrix = new int[source[0].length][source.length];
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source[0].length; j++) {
                newMatrix[j][i] = source[i][j];
            }
        }
        return newMatrix;
    }
}
