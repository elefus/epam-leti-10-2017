package com.epam.jf.polovinkin.homework;

public class Task15 extends com.epam.jf.common.homework.Task15 {
    @Override
    public int[][] verticalCyclicShift(int[][] matrix, int numberShifts) {
        int[][] temp = new int[matrix.length][];
        int j = 0;
        int start = (numberShifts % matrix.length + matrix.length) % matrix.length;

        for (int i = start; i < matrix.length; i++) {
            temp[i] = matrix[j];
            j++;
        }
        for (int i = 0; i < start || j < matrix.length; i++) {
            temp[i] = matrix[j];
            j++;
        }
        return temp.clone();
    }

    @Override
    public int[][] horizontalCyclicShift(int[][] matrix, int numberShifts) {
        int[][] temp = new int[matrix.length][matrix[0].length];
        int j = 0;
        int start = (numberShifts % matrix[0].length + matrix[0].length) % matrix[0].length;

        for (int i = start; i < matrix[0].length; i++) {
            for (int z = 0; z < matrix.length; z++) temp[z][i] = matrix[z][j];
            j++;
        }
        for (int i = 0; i < start || j < matrix[0].length; i++) {
            for (int z = 0; z < matrix.length; z++) temp[z][i] = matrix[z][j];
            j++;
        }
        return temp.clone();
    }
}
