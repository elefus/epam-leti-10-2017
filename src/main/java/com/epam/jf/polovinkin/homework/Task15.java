package com.epam.jf.polovinkin.homework;

public class Task15 extends com.epam.jf.common.homework.Task15 {
    @Override
    public int[][] verticalCyclicShift(int[][] matrix, int numberShifts) {
        int[][] temp = new int[matrix.length][];
        int j = 0;
        for (int i = (-numberShifts) % matrix.length; i < matrix.length; i++) {
            temp[j] = matrix[i];
            j++;
        }
        for (int i = numberShifts % matrix.length; i < (-numberShifts) % matrix.length; i++) {
            temp[j] = matrix[i];
            j++;
        }
        return temp;
    }

    @Override
    public int[][] horizontalCyclicShift(int[][] matrix, int numberShifts) {
        int[][] temp = new int[matrix.length][matrix[0].length];
        int j = 0;
        for (int i = (-numberShifts) % matrix.length; i < matrix.length; i++) {
            for (int z = 0; z < matrix.length; z++) temp[z][j] = matrix[z][i];
            j++;
        }
        for (int i = numberShifts % matrix.length; i < (-numberShifts) % matrix.length; i++) {
            for (int z = 0; z < matrix.length; z++) temp[z][j] = matrix[z][i];
            j++;
        }
        return temp;
    }
}
