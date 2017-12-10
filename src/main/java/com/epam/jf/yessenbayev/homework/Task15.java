package com.epam.jf.yessenbayev.homework;

import java.util.Arrays;

public class Task15 extends com.epam.jf.common.homework.Task15 {
    @Override
    public int[][] verticalCyclicShift(int[][] matrix, int numberShifts) {
        numberShifts = numberShifts % matrix.length;
        if (numberShifts < 0) {
            numberShifts += matrix.length;
        }
        int [][] tempoMatrix = new int[matrix.length][];
        System.arraycopy(matrix,matrix.length - numberShifts, tempoMatrix, 0, numberShifts);
        System.arraycopy(matrix,0, tempoMatrix, numberShifts, matrix.length - numberShifts);
        return tempoMatrix;
    }

    @Override
    public int[][] horizontalCyclicShift(int[][] matrix, int numberShifts) {
        numberShifts = numberShifts % matrix[0].length;
        if (numberShifts < 0) {
            numberShifts += matrix[0].length;
        }
        int[][] tempoMatrix = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            int[] tempoRow = new int[matrix[i].length];
            System.arraycopy(matrix[i],matrix[i].length - numberShifts, tempoRow, 0, numberShifts);
            System.arraycopy(matrix[i],0, tempoRow, numberShifts, matrix[i].length - numberShifts);
            tempoMatrix[i] = tempoRow;
        }
        return tempoMatrix;
    }
}
