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
            System.arraycopy(matrix[i],0,matr[n%matrix.length],0,matrix[i].length);
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
        if (matrix.length==0) return new int[0][0];
        int[][] matr = new int[matrix.length][matrix[0].length];
        int n;
        numberShifts%=matrix[0].length;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                n = j+numberShifts;
                if (n<0) n=matrix[i].length+n;
                matr[i][n%matrix[i].length] =matrix[i][j];
            }
        }
        return matr;
    }
}
