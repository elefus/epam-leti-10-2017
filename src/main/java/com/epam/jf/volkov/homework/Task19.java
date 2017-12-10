package com.epam.jf.volkov.homework;

public class Task19 {

    /**
     * Поворачивает матрицу на 90 градусов против часовой стрелки.
     * @param source Исходная матрица.
     * @return Новая матрица, элементы которой получены путем поворота исходной.
     */
    public int[][] rotateMatrixCounterclockwise(int[][] source) {
        int[][] newMatrix = new int[source[0].length][source.length];
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source[0].length; j++) {
                newMatrix[source[0].length - j - 1][i] = source[i][j];
            }
        }
        return newMatrix;
    }
}

/*
1 2 3
4 5 6
7 8 9
_____

  |
  v
_____

3 6 9
2 5 8
1 4 7
 */