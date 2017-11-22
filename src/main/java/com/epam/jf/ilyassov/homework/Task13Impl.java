package com.epam.jf.ilyassov.homework;


import com.epam.jf.common.homework.Task13;

public class Task13Impl extends Task13 {
    @Override
    public int[][] createSquareMatrix(int dimension) {
        int[][] ints = new int[dimension][dimension];
        for (int i = 0; i < dimension*dimension; i++) {
            ints[i/dimension][i%dimension]=i+1;
        }
        return ints;
    }

    public static void main(String[] args) {
        Task13Impl task13 = new Task13Impl();
        int[][] ints=task13.createSquareMatrix(3);
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints.length; j++) {
                System.out.print(ints[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
