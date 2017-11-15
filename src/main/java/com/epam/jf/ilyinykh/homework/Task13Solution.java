package com.epam.jf.ilyinykh.homework;

import com.epam.jf.common.homework.Task13;

public class Task13Solution extends Task13{
    /**
     * Формирует квадратную матрицу размером {@code dimension}.
     * Матрица должна быть заполнена элементами от 1 до {@code dimension}^2, начиная с верхнего левого угла.
     * <p>
     * dimension = 3:
     * 1 2 3
     * 4 5 6
     * 7 8 9
     *
     * @param dimension Размерность матрицы.
     * @return Созданная матрица.
     */
    @Override
    public int[][] createSquareMatrix(int dimension) {
        int[][] result = new int[dimension][dimension];
        for (int i = 0; i < dimension * dimension; i++) {
            result[i / dimension][i % dimension] = i + 1;
        }
        return result;
    }
}
