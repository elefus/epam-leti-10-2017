package com.epam.jf.Shabashov.homework;

public class Task15 {
    /**
     * Выполняет циклический сдвиг матрицы на указанное количество позиций по вертикали.
     * @param matrix Исходная матрица.
     * @param numberShifts Положительное значение соответствует циклическому сдвигу вниз, отрицательное - вверх.
     * @return Новая матрица, содержащая результат применения операции.
     */
    public int[][] verticalCyclicShift(int[][] matrix, int numberShifts){
        int[][] matr = new int[matrix.length][matrix[0].length];
        int n;
        numberShifts%=matrix.length;
        for (int i = 0; i < matrix.length; i++) {
            n = i+numberShifts;
            if (n<0) n=matrix.length+n;
            matr[n%matrix.length]=matrix[i];
        }
        return matr;
    }

    /**
     * Выполняет циклический сдвиг матрицы на указанное количество позиций по горизонтали.
     * @param matrix Исходная матрица.
     * @param numberShifts Положительное значение соответствует циклическому сдвигу вправо, отрицательное - влево.
     * @return Новая матрица, содержащая результат применения операции.
     */
    public int[][] horizontalCyclicShift(int[][] matrix, int numberShifts){
        int[][] matr = new int[matrix.length][matrix[0].length];
        int n;
        numberShifts%=matrix.length;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                n = j+numberShifts;
                if (n<0) n=matrix.length+n;
                matr[i][n%matrix[i].length] =matrix[i][j];
            }
        }
        return matr;
    }
}
