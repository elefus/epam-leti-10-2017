package com.epam.jf.guba.homework;

public class Task19 extends com.epam.jf.common.homework.Task19 {

    @Override
    public int[][] rotateMatrixCounterclockwise(int[][] source) {
        if(source.length == 0){
            return new int[0][];
        }
        int[][] newMatrix = new int[source[0].length][source.length];
        for(int i = 0; i < source.length; i++){
            for(int j = 0; j < source[i].length; j++ ){
                newMatrix[source[i].length-(j + 1)][i] = source[i][j];
            }
        }
        return newMatrix;
    }
}
