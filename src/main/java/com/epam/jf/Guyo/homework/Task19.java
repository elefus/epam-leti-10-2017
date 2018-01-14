package com.epam.jf.Guyo.homework;

public class Task19 extends com.epam.jf.common.homework.Task19 {

    /**
     * Поворачивает матрицу на 90 градусов против часовой стрелки.
     * @param source Исходная матрица.
     * @return Новая матрица, элементы которой получены путем поворота исходной.
     */
    public int[][] rotateMatrixCounterclockwise(int[][] source){
        int[][] outputMatrix = new int[source[0].length][source.length];
        int counter = 0;

        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source[i].length; j++) {
                outputMatrix[outputMatrix.length - 1 - counter][i] = source[i][j];
                counter++;
                if (counter == outputMatrix.length) {
                    counter = 0;
                }
            }
        }
        return outputMatrix;
    }
}


