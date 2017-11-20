package com.epam.jf.bavtovich.homework;

import java.util.Arrays;
import java.util.Comparator;

public class Task15 {

    /**
     * Выполняет циклический сдвиг матрицы на указанное количество позиций по вертикали.
     * @param matrix Исходная матрица.
     * @param numberShifts Положительное значение соответствует циклическому сдвигу вниз, отрицательное - вверх.
     * @return Новая матрица, содержащая результат применения операции.
     */
    public int[][] verticalCyclicShift(int[][] matrix, int numberShifts) {
        numberShifts = numberShifts % matrix.length;       
        int[][] temp = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            int newIndex = getShiftIndex(i, numberShifts, matrix.length);
            temp[newIndex] = matrix[i];            
        }
        return temp;
    }

    private int getShiftIndex(int indexRow, int numberShifts, int matrixSize) {
        return (numberShifts >= 0) ? indexRow - numberShifts < 0 ? matrixSize + indexRow - numberShifts
                                                                 : indexRow - numberShifts
                                   : indexRow - numberShifts >= matrixSize ? indexRow - numberShifts - matrixSize
                                                                           : indexRow - numberShifts;
    }

    /**
     * Выполняет циклический сдвиг матрицы на указанное количество позиций по горизонтали.
     * @param matrix Исходная матрица.
     * @param numberShifts Положительное значение соответствует циклическому сдвигу вправо, отрицательное - влево.
     * @return Новая матрица, содержащая результат применения операции.
     */
    public int[][] horizontalCyclicShift(int[][] matrix, int numberShifts) {
        int[][] temp = new int[matrix.length][matrix[0].length];
        numberShifts = -numberShifts % matrix[0].length;
        for (int k = 0; k < matrix.length; k++) {
            for (int i = 0; i < matrix[k].length; i++) {
                int newIndex = getShiftIndex(i, numberShifts, matrix[k].length);
                temp[k][newIndex] = matrix[k][i];
            }
        }
        return temp;
    }
}