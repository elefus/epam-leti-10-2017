package com.epam.jf.ilyinykh.homework;

import com.epam.jf.common.homework.Task19;

public class Task19Sol extends Task19 {
    /**
     * Поворачивает матрицу на 90 градусов против часовой стрелки.
     *
     * @param source Исходная матрица.
     * @return Новая матрица, элементы которой получены путем поворота исходной.
     */
    @Override
    public int[][] rotateMatrixCounterclockwise(int[][] source) {
        int[][] copy = new int[source.length][];
        for (int i = 0; i < copy.length; i++) {
            copy[i] = new int[source[i].length];
        }

        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[i].length; j++) {
                copy[copy.length - 1 - j][i] = source[i][j];
            }
        }

        return copy;
    }
}
