package com.epam.jf.savchenkov.homework;

import java.util.Arrays;
import java.util.Comparator;

public class Task14 extends com.epam.jf.common.homework.Task14 {
    @Override
    public int[][] sortMatrixByValuesInColumn(int[][] matrix, int indexColumn) {

        if (indexColumn < 0 || indexColumn >= matrix.length) {
            throw new IllegalArgumentException("indexColumn is out of bound");
        }

        int[][] answer = matrix.clone();
        Arrays.sort(answer, Comparator.comparingInt(o -> o[indexColumn]));

        return answer;
    }
}
