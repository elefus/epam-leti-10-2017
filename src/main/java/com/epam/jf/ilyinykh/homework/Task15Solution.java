package com.epam.jf.ilyinykh.homework;

import com.epam.jf.common.homework.Task15;

import java.util.Arrays;
import java.util.Collections;

public class Task15Solution extends Task15 {
    private static <T> void swap(T left, T right) {

    }

    /**
     * Выполняет циклический сдвиг матрицы на указанное количество позиций по вертикали.
     *
     * @param matrix       Исходная матрица.
     * @param shift Положительное значение соответствует циклическому сдвигу вниз, отрицательное - вверх.
     * @return Новая матрица, содержащая результат применения операции.
     */
    @Override
    public int[][] verticalCyclicShift(int[][] matrix, int shift) {
        if (shift < 0) {
            shift += matrix.length;
        }
        shift %= matrix.length;
        int[][] b = new int[matrix.length][];
        System.arraycopy(matrix, 0, b, shift, matrix.length - shift);
        System.arraycopy(matrix, matrix.length - shift, b, 0, shift);
        matrix = b;
        return matrix;
    }

    /**
     * Выполняет циклический сдвиг матрицы на указанное количество позиций по горизонтали.
     *
     * @param matrix       Исходная матрица.
     * @param shift Положительное значение соответствует циклическому сдвигу вправо, отрицательное - влево.
     * @return Новая матрица, содержащая результат применения операции.
     */
    @Override
    public int[][] horizontalCyclicShift(int[][] matrix, int shift) {
        if (shift < 0) {
            shift += matrix.length;
        }
        for (int i = 0; i < matrix.length; i++) {
            int shiftInner = shift % matrix[i].length;
            int[] dest = new int[matrix[i].length];
            System.arraycopy(matrix[i], 0, dest, shiftInner, matrix[i].length - shiftInner);
            System.arraycopy(matrix[i], matrix[i].length - shiftInner, dest, 0, shiftInner);
            matrix[i] = dest;
        }
        return matrix;
    }
}
