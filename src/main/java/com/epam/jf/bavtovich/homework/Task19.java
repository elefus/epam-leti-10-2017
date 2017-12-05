package com.epam.jf.bavtovich.homework;

import java.util.Arrays;

public class Task19 extends com.epam.jf.common.homework.Task19 {

    /**
     * Поворачивает матрицу на 90 градусов против часовой стрелки.
     * @param source Исходная матрица.
     * @return Новая матрица, элементы которой получены путем поворота исходной.
     */
    @Override
    public int[][] rotateMatrixCounterclockwise(int[][] source) {
        int m = source.length - 1;
        int n = source[0].length - 1;
        int[][] temp = new int[n + 1][m + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                temp[n - j][i] = source[i][j];
            }
        }
        for (int i = 0; i < n + 1; i++) {
            System.out.println(Arrays.toString(temp[i]));
        }
        return temp;
    }
}
