package com.epam.jf.polovinkin.homework;

public class Task19 extends com.epam.jf.common.homework.Task19 {
    @Override
    public int[][] rotateMatrixCounterclockwise(int[][] source) {
        int counter = 0;
        int[][] temp = new int[source[0].length][source.length];
        for (int i = 0; i < source[0].length; i++) {
            for (int j = source.length; j >= 0 ; j--) {
                temp[i][j] = source[counter / source[0].length][counter % source[0].length];
                counter++;
            }
        }
        return temp;
    }
}
