package com.epam.jf.savchenkov.homework;

public class Task15 extends com.epam.jf.common.homework.Task15 {
    @Override
    public int[][] verticalCyclicShift(int[][] matrix, int numberShifts) {
        numberShifts %= matrix.length;
        if (numberShifts < 0) {
            numberShifts += matrix.length;
        }
        int [][] temp = new int[matrix.length][];
        System.arraycopy(matrix,matrix.length - numberShifts, temp, 0, numberShifts);
        System.arraycopy(matrix,0, temp, numberShifts, matrix.length - numberShifts);
        return temp;
    }

    @Override
    public int[][] horizontalCyclicShift(int[][] matrix, int numberShifts) {
        numberShifts %= matrix[0].length;
        if (numberShifts < 0) {
            numberShifts += matrix[0].length;
        }
        int[][] temp = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            int[] tempoRow = new int[matrix[i].length];
            System.arraycopy(matrix[i],matrix[i].length - numberShifts, tempoRow, 0, numberShifts);
            System.arraycopy(matrix[i],0, tempoRow, numberShifts, matrix[i].length - numberShifts);
            temp[i] = tempoRow;
        }
        return temp;
    }
}
