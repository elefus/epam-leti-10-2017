package com.epam.jf.common.homework;

public abstract class Task13 {

    /**
     * Формирует квадратную матрицу размером {@code dimension}.
     * Матрица должна быть заполнена элементами от 1 до {@code dimension}^2, начиная с верхнего левого угла.
     *
     * dimension = 3:
     * 1 2 3
     * 4 5 6
     * 7 8 9
     *
     * @param dimension Размерность матрицы.
     * @return Созданная матрица.
     */
    public abstract int[][] createSquareMatrix(int dimension);
}
