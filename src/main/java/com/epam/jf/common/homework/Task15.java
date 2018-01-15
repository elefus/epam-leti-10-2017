package com.epam.jf.common.homework;

public abstract class Task15 {

    /**
     * Выполняет циклический сдвиг матрицы на указанное количество позиций по вертикали.
     * @param matrix Исходная матрица.
     * @param numberShifts Положительное значение соответствует циклическому сдвигу вниз, отрицательное - вверх.
     * @return Новая матрица, содержащая результат применения операции.
     */
    public abstract int[][] verticalCyclicShift(int[][] matrix, int numberShifts);

    /**
     * Выполняет циклический сдвиг матрицы на указанное количество позиций по горизонтали.
     * @param matrix Исходная матрица.
     * @param numberShifts Положительное значение соответствует циклическому сдвигу вправо, отрицательное - влево.
     * @return Новая матрица, содержащая результат применения операции.
     */
    public abstract int[][] horizontalCyclicShift(int[][] matrix, int numberShifts);
}
