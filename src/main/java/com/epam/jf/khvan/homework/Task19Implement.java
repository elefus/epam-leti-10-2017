package com.epam.jf.khvan.homework;

import com.epam.jf.common.homework.Task19;

public class Task19Implement extends Task19 {
    public static void main(String[] args) {

        int [][] matrix = {{1,2,3},{4,5,6}};

        for (int i = 0; i < matrix.length; i++) {    // stroki
            for (int j = 0; j < matrix[0].length; j++) { //
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        int [][] rotatedMatrix = new Task19Implement().rotateMatrixCounterclockwise(matrix);

        for (int i = 0; i < rotatedMatrix.length; i++) {
            for (int j = 0; j < rotatedMatrix[0].length; j++) {
                System.out.print(rotatedMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

    }

    public int[][] rotateMatrixCounterclockwise(int[][] source) {

        int rowsInSource = source.length;
        int columnsInSource = source[0].length;


        int [][] rotatedMatrix = new int[columnsInSource][rowsInSource];
        for (int i = 0; i < rowsInSource  ; i++) {
            for (int j = 0; j < columnsInSource ; j++) {
                rotatedMatrix[j][i] = source[i][columnsInSource - j - 1];
            }
        }
        return rotatedMatrix;
    }
}

