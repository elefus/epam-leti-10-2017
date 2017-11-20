package com.epam.jf.bavtovich.homework;

public class Task13 {

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
    public int[][] createSquareMatrix(int dimension) {
        if (dimension > 0) {
            int[][] matrix = new int[dimension][dimension];
            for (int i = 0; i < dimension; i++) {
                for (int j = 0; j < dimension; j++) {
                    matrix[i][j] = (j + 1) + dimension * i;
                }
            }
            return matrix;
        } else {
            return null;
        }
    }
}

