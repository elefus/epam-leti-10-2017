package com.epam.jf.yessenbayev.homework;

public class Task13 extends com.epam.jf.common.homework.Task13 {
    /**
     *
     * @param dimension Размерность матрицы.
     * @return matrix матрица размерности dimension, элементы, начиная с 0 до dimension^2
     */
   @Override
    public int[][] createSquareMatrix(int dimension) {
       if (dimension < 1) {
           throw new IllegalArgumentException("dimension < 1");
       }
        int[][] matrix = new int[dimension][dimension];
        int matrixDigit = 1;
        for(int i = 0; i < dimension; i++) {
            for(int j = 0; j < dimension; j++) {
                matrix[i][j] = matrixDigit++;
            }
        }
        return matrix;
    }
}
