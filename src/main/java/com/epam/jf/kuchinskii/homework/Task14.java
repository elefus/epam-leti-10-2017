package com.epam.jf.kuchinskii.homework;

import java.util.Arrays;
import java.util.Comparator;

public class Task14 extends com.epam.jf.common.homework.Task14 {

    @Override
    public int[][] sortMatrixByValuesInColumn(int[][] matrix, int indexColumn) {
        if (indexColumn < 0 || indexColumn >= matrix[0].length) {
            throw new IllegalArgumentException("Invalid index: " + indexColumn);
        }

        int[][] result = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            result[i] = Arrays.copyOf(matrix[i], matrix.length);
        }

        Arrays.sort(result, Comparator.comparingInt(o -> o[indexColumn]));
        return result;
    }
}
