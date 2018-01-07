package com.epam.jf.khvan.homework;

import com.epam.jf.common.homework.Task15;

public class Task15Impl extends Task15 {

    public static void main(String[] args) {
        int [][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        int [][] shiftedMatrix = new Task15Impl().verticalCyclicShift(matrix,1);

        for (int i = 0; i < shiftedMatrix[0].length; i++) {
            for (int j = 0; j < shiftedMatrix[0].length; j++) {
                System.out.print(shiftedMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    @Override
    public int[][] verticalCyclicShift(int[][] matrix, int numberShifts) {
        verticalDownShift(matrix, numberShifts);
        verticalUpShift(matrix, numberShifts);
        return matrix;
    }

    private void verticalUpShift(int[][] matrix, int numberShifts) {
        if ( numberShifts < 0 ){
            int actualShift = Math.abs(numberShifts % matrix.length);
            for ( int i = 0; i < actualShift ; i ++){
                int [] matrixTemp = matrix[0];
                for ( int j = 0; j < matrix.length -1; j++){
                     matrix[j] = matrix[j + 1];
                }
                matrix[matrix.length - 1] = matrixTemp;
            }
        }
    }

    private void verticalDownShift(int[][] matrix, int numberShifts) {
        if ( numberShifts > 0) {
            int actualShift = Math.abs(numberShifts % matrix.length);
          for ( int i = 0; i < actualShift ; i ++){
              int [] matrixTemp = matrix[matrix.length - 1];
              for ( int j = matrix.length - 1; j > 0; j--){
                  matrix[j] = matrix[j - 1];
              }
              matrix[0] = matrixTemp;
          }
        }
    }

    @Override
    public int[][] horizontalCyclicShift(int[][] matrix, int numberShifts) {
        int [][] newMatrix = new int[matrix.length][matrix[0].length];
        horizontalPositiveShift(matrix, numberShifts, newMatrix);
        horizontalNegativeShift(matrix, numberShifts, newMatrix);
        return newMatrix;
    }

    private void horizontalPositiveShift(int[][] matrix, int numberShifts, int[][] newMatrix) {
        if ( numberShifts > 0){
            int actualShift = numberShifts % matrix[0].length;
            for ( int j = 0; j < matrix.length; j++){
                for (int i = 0; i < matrix[j].length  ; i++) {
                    int position = (i + actualShift) % matrix[0].length;
                    newMatrix[j][position] = matrix[j][i];
                }
            }
        }
    }

    private void horizontalNegativeShift(int[][] matrix, int numberShifts, int[][] newMatrix) {
        if ( numberShifts < 0){
            int actualShift =Math.abs(numberShifts % matrix[0].length);
            for ( int j = 0; j < matrix.length; j++){
                for (int i = matrix[j].length - 1; i >= 0   ; i--) {
                    if ( i == matrix.length - 1){}
                    int position =  ( i + actualShift * (matrix[j].length - 1)) % matrix[0].length;
                    newMatrix[j][position] = matrix[j][i];
                }
            }
        }
    }
}

