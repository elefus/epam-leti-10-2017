package com.epam.jf.kozlov.homework;

public class Task15 extends com.epam.jf.common.homework.Task15 {

    /**
     * Выполняет циклический сдвиг матрицы на указанное количество позиций по вертикали.
     * @param matrix Исходная матрица.
     * @param numberShifts Положительное значение соответствует циклическому сдвигу вниз, отрицательное - вверх.
     * @return Новая матрица, содержащая результат применения операции.
     */
    @Override
    public int[][] verticalCyclicShift(int[][] matrix, int numberShifts) {
        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            int row = (i + numberShifts);
            row = row < 0 ? (matrix.length + (row % matrix.length)) % matrix.length : row % matrix.length;
            System.arraycopy(matrix[i], 0, newMatrix[row], 0, matrix[i].length);
        }
        return newMatrix;
    }

    /**
     * Выполняет циклический сдвиг матрицы на указанное количество позиций по горизонтали.
     * @param matrix Исходная матрица.
     * @param numberShifts Положительное значение соответствует циклическому сдвигу вправо, отрицательное - влево.
     * @return Новая матрица, содержащая результат применения операции.
     */
    @Override
    public int[][] horizontalCyclicShift(int[][] matrix, int numberShifts) {
        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int column = (j + numberShifts);
                column = column < 0 ? (matrix[i].length + (column % matrix[i].length)) % matrix[i].length : column % matrix[i].length;
                newMatrix[i][column] = matrix[i][j];
            }
        }
        return newMatrix;
    }
}
