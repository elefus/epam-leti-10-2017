package com.epam.jf.Shabashov.homework;

class Task19 {
    /**
     * Поворачивает матрицу на 90 градусов против часовой стрелки.
     *
     * @param source Исходная матрица.
     * @return Новая матрица, элементы которой получены путем поворота исходной.
     */
    int[][] rotateMatrixCounterclockwise(int[][] source) {
        int[][] matr = new int[source[0].length][source.length];
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source[i].length; j++) {
                matr[j][i] = source[i][source[i].length - j - 1];
            }
        }
        return matr;
    }
}