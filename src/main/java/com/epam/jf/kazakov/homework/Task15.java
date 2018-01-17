package com.epam.jf.kazakov.homework;

public class Task15 extends com.epam.jf.common.homework.Task15 {

    @Override
    public int[][] verticalCyclicShift(int[][] matrix, int numberShifts) {
        numberShifts %= matrix.length;
        if(numberShifts < 0) {
            numberShifts += matrix.length;
        }
        int[][] shiftedMatrix = new int[matrix.length][];
        System.arraycopy(matrix, 0, shiftedMatrix, numberShifts, matrix.length - numberShifts);
        System.arraycopy(matrix, matrix.length - numberShifts, shiftedMatrix, 0, numberShifts);
        return shiftedMatrix;
    }

    @Override
    public int[][] horizontalCyclicShift(int[][] matrix, int numberShifts) {
        numberShifts %= matrix.length;
        if(numberShifts < 0) {
            numberShifts += matrix.length;
        }
        int[][] shiftedMatrix = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            int[] row = new int[matrix[i].length];
            System.arraycopy(matrix[i], 0, row, numberShifts, matrix[i].length - numberShifts);
            System.arraycopy(matrix[i], matrix[i].length - numberShifts, row, 0, numberShifts);
            shiftedMatrix[i] = row;
        }
        return shiftedMatrix;
    }
}
