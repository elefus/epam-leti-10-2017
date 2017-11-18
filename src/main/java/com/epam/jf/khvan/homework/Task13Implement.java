package com.epam.jf.khvan.homework;

import com.epam.jf.common.homework.Task13;

public class Task13Implement extends Task13 {

    public static void main(String[] args) {
        int [][] massive = new Task13Implement().createSquareMatrix(7);
        for (int i = 0; i < massive[0].length; i++) {
            for (int j = 0; j < massive[0].length; j++) {
                System.out.print(massive[i][j] + " ");
            }
            System.out.println();
        }
    }
    @Override
    public int[][] createSquareMatrix(int dimension) {
        int diff = 1;
        int [][] matrix = new int[dimension ][dimension ];

        for ( int i = 0; i < dimension  ; i++){ // strings
            if ( i >= 1 ) { diff = matrix [ i - 1 ][dimension - 1 ] + 1;}
            for (int j = 0; j < dimension ; j++) {
                matrix [i][j] = j + diff ;
            }
        }
        return matrix;
    }
}

