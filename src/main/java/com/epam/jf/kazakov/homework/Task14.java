package com.epam.jf.kazakov.homework;

import com.epam.jf.common.homework.Task1;

import java.util.Arrays;

public class Task14 extends com.epam.jf.common.homework.Task14 {

    @Override
    public int[][] sortMatrixByValuesInColumn(int[][] matrix, int indexColumn) {
        int[][] sortedMatrix = matrix.clone();
        Arrays.sort(sortedMatrix, (arr1, arr2) -> {
            return (Integer.compare(arr1[indexColumn], arr2[indexColumn]));
        });
        return sortedMatrix;
    }
}
