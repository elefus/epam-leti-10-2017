package com.epam.jf.Guyo.homework;

public class Task15 extends com.epam.jf.common.homework.Task15 {

    /**
     * Выполняет циклический сдвиг матрицы на указанное количество позиций по вертикали.
     * @param matrix Исходная матрица.
     * @param numberShifts Положительное значение соответствует циклическому сдвигу вниз, отрицательное - вверх.
     * @return Новая матрица, содержащая результат применения операции.
     */
    @Override
    public int[][] verticalCyclicShift(int[][] matrix, int numberShifts){
        int[][] outputMatrix = new int[matrix.length][matrix[0].length];

        if (numberShifts < 0) {
            numberShifts = matrix[0].length + numberShifts % matrix[0].length;
        }
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                outputMatrix[(i+numberShifts) % matrix.length][j] = matrix[i][j];
            }
        }
        return outputMatrix;
    }
    /**
     * Выполняет циклический сдвиг матрицы на указанное количество позиций по горизонтали.
     * @param matrix Исходная матрица.
     * @param numberShifts Положительное значение соответствует циклическому сдвигу вправо, отрицательное - влево.
     * @return Новая матрица, содержащая результат применения операции.
     */
    @Override
    public int[][] horizontalCyclicShift(int[][] matrix, int numberShifts){
        int[][] outputMatrix = new int[matrix.length][matrix[0].length];

        if (numberShifts < 0) {
            numberShifts = matrix[0].length + numberShifts % matrix[0].length;
        }
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                outputMatrix[i][(j+numberShifts) % matrix[0].length] = matrix[i][j];
            }
        }
        return outputMatrix;
    }
}
