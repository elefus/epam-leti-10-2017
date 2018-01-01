package com.epam.jf.kruglik.homework;

public class Task19 {
    /**
     * Поворачивает матрицу на 90 градусов против часовой стрелки.
     * @param source Исходная матрица.
     * @return Новая матрица, элементы которой получены путем поворота исходной.
     */
    public int[][] rotateMatrixCounterclockwise(int[][] source){
        int[][] transpMatrix = new int[source[0].length][source.length];

        for (int i = 0; i< source.length; ++i){
            for (int j = 0; j < source[0].length; ++j){
                transpMatrix[j][i] = source[i][(source[0].length - 1) - j];
            }
        }

        return transpMatrix;
    }
}
