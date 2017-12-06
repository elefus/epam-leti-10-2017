package com.epam.jf.ilyassov.homework;


import com.epam.jf.common.homework.Task19;

public class Task19Imp extends Task19 {

    @Override
    public int[][] rotateMatrixCounterclockwise(int[][] source) {
        int temp[][]=new int[source.length][source.length];
        for (int i = 0; i < source.length; i++) {
            for (int j = 0, k=source.length-1; j < source.length; j++,--k) {
                temp[k][i]=source[i][j];
            }
        }
        return temp;
    }
}
