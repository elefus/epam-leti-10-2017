package com.epam.jf.dementyev.homework;

import java.util.Arrays;

public class Task14 extends com.epam.jf.common.homework.Task14 {

    @Override
    public int[][] sortMatrixByValuesInColumn(int[][] matrix, int indexColumn) {
        if (indexColumn < 0 || matrix == null) {
            throw new IllegalArgumentException();
        }

        int[][] newMatrix = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            newMatrix[i] = new int[matrix[i].length];
            System.arraycopy(matrix[i], 0, newMatrix[i], 0, newMatrix[i].length);
        }

        Arrays.sort(newMatrix, (o1, o2) -> {
            if (o1.length > indexColumn && o2.length > indexColumn) {
                return Integer.compare(o1[indexColumn], o2[indexColumn]);
            } else if (o1.length <= indexColumn && o2.length <= indexColumn) {
                return 0;
            } else if (o1.length <= indexColumn) {
                return -1;
            } else {
                return 1;
            }
        });

        return newMatrix;
    }
}
