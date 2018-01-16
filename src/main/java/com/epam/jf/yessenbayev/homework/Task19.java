package com.epam.jf.yessenbayev.homework;

import java.util.Arrays;

public class Task19 extends com.epam.jf.common.homework.Task19 {
    @Override
    public int[][] rotateMatrixCounterclockwise(int[][] source) {
        int[][] invertedMatrix = new int[source[0].length][source.length];
        for(int i = 0; i < source.length; ++i) {
            for(int j = 0; j < source[0].length; ++j) {
                invertedMatrix[j][i] = source[i][(source[0].length - 1 ) - j];
            }
        }

        for (int i = 0; i < source[0].length; i++) {
            System.out.println(Arrays.toString(invertedMatrix[i]));
        }

        return invertedMatrix;
    }

}
