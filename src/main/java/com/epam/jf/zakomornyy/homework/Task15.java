package com.epam.jf.zakomornyy.homework;

public class Task15 extends com.epam.jf.common.homework.Task15 {

    @Override
    public int[][] verticalCyclicShift(int[][] matrix, int numberShifts) {
        return cyclicShift(matrix, numberShifts, true);
    }

    @Override
    public int[][] horizontalCyclicShift(int[][] matrix, int numberShifts) {
        return cyclicShift(matrix, numberShifts, false);
    }

    private int[][] cyclicShift(int[][] matrix, int numberShifts, boolean isVertShift) {
        int[][] resultMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; ++i){
            System.arraycopy(matrix[i], 0, resultMatrix[i], 0, matrix[0].length);
        }
        boolean[] isChanged;
        int numOfChanged = 0;
        int[] temp1;
        if(isVertShift) {
            isChanged = new boolean[resultMatrix[0].length];
            temp1 = new int[resultMatrix.length];
            for(int i = 0; i < temp1.length; i++) {
                temp1[i] = resultMatrix[i][0];
            }
        } else {
            isChanged = new boolean[resultMatrix.length];
            temp1 = resultMatrix[0];
        }
        for (int i = 0; numOfChanged < isChanged.length;) {
            if(!isChanged[i]) {
                isChanged[i] = true;
                numOfChanged++;
                int nextIndex = (i + numberShifts) % isChanged.length;
                if(nextIndex < 0) {
                    nextIndex = isChanged.length + nextIndex;
                }
                int[] temp2;
                if(isVertShift) {
                    temp2 = new int[resultMatrix.length];
                    for(int j = 0; j < temp1.length; j++) {
                        temp2[j] = resultMatrix[j][nextIndex];
                    }
                    for (int j = 0; j < temp2.length; j++){
                        resultMatrix[j][nextIndex] = temp1[j];
                    }
                }else {
                    temp2 = resultMatrix[nextIndex];
                    resultMatrix[nextIndex] = temp1;
                }
                temp1 = temp2;
                i = nextIndex;
            } else {
                i = (i + 1) % isChanged.length;
                if(i < 0) {
                    i = isChanged.length + i;
                }
                if(isVertShift) {
                    for(int j = 0; j < temp1.length; j++) {
                        temp1[j] = resultMatrix[j][i];
                    }
                } else {
                    temp1 = resultMatrix[i];
                }
            }
        }
        return resultMatrix;
    }
}
