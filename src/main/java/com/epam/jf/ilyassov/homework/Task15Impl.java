package com.epam.jf.ilyassov.homework;

import com.epam.jf.common.homework.Task15;

public class Task15Impl extends Task15 {
    public Task15Impl() {
        super();
    }

    @Override
    public int[][] verticalCyclicShift(int[][] matrix, int numberShifts) {
        numberShifts%=matrix.length;
        int arr[][]=new int [matrix.length][matrix.length];
        if(numberShifts==0)
            return matrix;
        if(numberShifts>0){
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    if(i>matrix.length-numberShifts-1){
                        arr[matrix.length-1-i][j]=matrix[i][j];
                    }else{
                        arr[i+numberShifts][j]=matrix[i][j];
                    }
                }
            }
        } else{
            numberShifts=-numberShifts;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    if(i<numberShifts){
                        arr[i+matrix.length-numberShifts][j]=matrix[i][j];
                    }else{
                        arr[i-numberShifts][j]=matrix[i][j];
                    }
                }
            }
        }

        return arr;
    }

    @Override
    public int[][] horizontalCyclicShift(int[][] matrix, int numberShifts) {

        int arr[][]=new int [matrix.length][matrix.length];
        if(numberShifts==0)
            return matrix;
        if(numberShifts>0){
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    if(j>matrix.length-numberShifts-1){
                        arr[i][j-matrix.length+numberShifts]=matrix[i][j];
                    }else{
                        arr[i][j+numberShifts]=matrix[i][j];
                    }
                }
            }
        } else{
            numberShifts=-numberShifts;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    if(j<numberShifts){
                        arr[i][matrix.length-numberShifts+j]=matrix[i][j];
                    }else{
                        arr[i][j-numberShifts]=matrix[i][j];
                    }
                }
            }
        }

        return arr;
    }
}
