package com.epam.jf.kruglik.homework;

public class Task15 {

    /**
     * Выполняет циклический сдвиг матрицы на указанное количество позиций по вертикали.
     *
     * @param matrix       Исходная матрица.
     * @param numberShifts Положительное значение соответствует циклическому сдвигу вниз, отрицательное - вверх.
     * @return Новая матрица, содержащая результат применения операции.
     */
    public static int[][] verticalCyclicShift(int[][] matrix, int numberShifts) {
        numberShifts = numberShifts % matrix.length;
        int[][] resultMatrix = new int[matrix.length][matrix[0].length];

        if (numberShifts < 0) {
            numberShifts = Math.abs(numberShifts);
            for (int i = numberShifts; i < (matrix.length + numberShifts); ++i) {
                System.arraycopy(matrix[i % matrix.length], 0, resultMatrix[i - numberShifts], 0, matrix[0].length);
            }
        } else {
            for (int i = numberShifts; i < (matrix.length + numberShifts); ++i) {
                System.arraycopy(matrix[i - numberShifts], 0, resultMatrix[i % matrix.length], 0, matrix[0].length);
            }
        }

        return resultMatrix;
    }

    /**
     * Выполняет циклический сдвиг матрицы на указанное количество позиций по горизонтали.
     *
     * @param matrix       Исходная матрица.
     * @param numberShifts Положительное значение соответствует циклическому сдвигу вправо, отрицательное - влево.
     * @return Новая матрица, содержащая результат применения операции.
     */
    public static int[][] horizontalCyclicShift(int[][] matrix, int numberShifts) {
        numberShifts = numberShifts % matrix[0].length;
        int[][] resultMatrix = new int[matrix.length][matrix[0].length];

        if (numberShifts<0) {
            numberShifts = Math.abs(numberShifts);
            for (int i = 0; i < matrix.length; ++i) {
                for (int j = numberShifts; j < matrix[0].length + numberShifts; ++j) {
                    resultMatrix[i][j - numberShifts] = matrix[i][j % matrix[0].length];
                }
            }
        } else {
            for (int i = 0; i < matrix.length; ++i) {
                for (int j = numberShifts; j < matrix[0].length + numberShifts; ++j) {
                    resultMatrix[i][j % matrix[0].length] = matrix[i][j - numberShifts];
                }
            }
        }

        return resultMatrix;

    }
}