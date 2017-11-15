package com.epam.jf.khvan.homework;

import com.epam.jf.common.homework.Task14;

public class Task14Implement extends Task14 {
    public static void main(String[] args) {
        int[][] matrixExample = { {1,2,3,4,11},{4,3,0,4,2},{5,3,2,1,2},{9,6,0,8,2},{9,6,0,8,3}};
        for (int i = 0; i < matrixExample[0].length; i++) {
            for (int j = 0; j < matrixExample[0].length; j++) {
                System.out.print(matrixExample[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        int [][] sortedMatrix = new Task14Implement().sortMatrixByValuesInColumn(matrixExample,4);

        for (int i = 0; i < sortedMatrix[0].length; i++) {
            for (int j = 0; j < sortedMatrix[0].length; j++) {
                System.out.print(sortedMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    @Override
    public int[][] sortMatrixByValuesInColumn(int[][] matrix, int indexColumn) {
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = matrix.length - 1; j > i ; j--) {
                if ( matrix[j][indexColumn] < matrix[ j - 1][indexColumn]){
                    int [] temp = matrix[j];
                    matrix[j] = matrix[ j -1];
                    matrix[ j - 1] = temp;
                }
            }
        }
        return matrix;
    }
}

