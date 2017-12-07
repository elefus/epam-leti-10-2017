package com.epam.jf.bavtovich.homework;

public class Task15 {

    /**
     * Выполняет циклический сдвиг матрицы на указанное количество позиций по вертикали.
     * @param matrix Исходная матрица.
     * @param numberShifts Положительное значение соответствует циклическому сдвигу вниз, отрицательное - вверх.
     * @return Новая матрица, содержащая результат применения операции.
     */
    public int[][] verticalCyclicShift(int[][] matrix, int numberShifts) {
        numberShifts = numberShifts % matrix.length;
        if (numberShifts < 0) {
            numberShifts += matrix.length;
        }
        int[][] temp = new int[matrix.length][];
        System.arraycopy(matrix,matrix.length - numberShifts, temp, 0, numberShifts);
        System.arraycopy(matrix,0, temp, numberShifts, matrix.length - numberShifts);
        return temp;
    }

    /**
     * Выполняет циклический сдвиг матрицы на указанное количество позиций по горизонтали.
     * @param matrix Исходная матрица.
     * @param numberShifts Положительное значение соответствует циклическому сдвигу вправо, отрицательное - влево.
     * @return Новая матрица, содержащая результат применения операции.
     */
    public int[][] horizontalCyclicShift(int[][] matrix, int numberShifts) {
        numberShifts = numberShifts % matrix[0].length;
        if (numberShifts < 0) {
            numberShifts += matrix[0].length;
        }
        int[][] temp = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            int[] tmpRow = new int[matrix[i].length];
            System.arraycopy(matrix[i],matrix[i].length - numberShifts, tmpRow, 0, numberShifts);
            System.arraycopy(matrix[i],0, tmpRow, numberShifts, matrix[i].length - numberShifts);
            temp[i] = tmpRow;
        }
        return temp;
    }
}