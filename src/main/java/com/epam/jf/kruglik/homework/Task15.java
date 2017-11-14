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
        numberShifts = numberShifts % matrix[0].length;
        int[] temp = new int[matrix.length];

        for (int k = 0; k < numberShifts; ++k){
            for (int p = 0; p < matrix.length; ++p){
                temp[p] = matrix[p][matrix[0].length - 1];
            }
                for (int i = matrix[0].length - 2; i >= 0; --i){
                    for (int p = 0; p < matrix.length; ++p){
                        matrix[p][i+1] = matrix[p][i];
                }
            }
            for (int p = 0; p < matrix.length; ++p){
                matrix[p][0] = temp[p];
            }
        }

        return matrix;
    }

    /**
     * Выполняет циклический сдвиг матрицы на указанное количество позиций по горизонтали.
     *
     * @param matrix       Исходная матрица.
     * @param numberShifts Положительное значение соответствует циклическому сдвигу вправо, отрицательное - влево.
     * @return Новая матрица, содержащая результат применения операции.
     */
    public static int[][] horizontalCyclicShift(int[][] matrix, int numberShifts) {
        numberShifts = numberShifts % matrix.length;

        for (int k = 0; k < numberShifts; ++k){
            int temp[] = matrix[matrix.length - 1];
            System.arraycopy(matrix, 0, matrix, 1, matrix.length - 2 + 1);
            matrix[0] = temp;
        }

        return matrix;
    }

}