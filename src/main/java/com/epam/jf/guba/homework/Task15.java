package com.epam.jf.guba.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Task15 extends com.epam.jf.common.homework.Task15 {


    @Override
    public int[][] verticalCyclicShift(int[][] matrix, int numberShifts) {
        if(matrix == null || matrix.length == 0){
            throw new IllegalArgumentException("Problem with input matrix");
        }
        ArrayList<int[]> ints = new ArrayList<>();
        ints.addAll(Arrays.asList(matrix));
        Collections.rotate(ints, numberShifts);
        int[][] newMatrix = new int[matrix.length][matrix.length];
        for (int i = 0; i < ints.size(); i++){
            newMatrix[i] = ints.get(i);
        }

        return newMatrix;
    }

    @Override
    public int[][] horizontalCyclicShift(int[][] matrix, int numberShifts) {
        if(matrix == null || matrix.length == 0){
            throw new IllegalArgumentException("Problem with input matrix");
        }
        ArrayList<int[]> ints = new ArrayList<>();

        int[][] buffMatrix = new int[matrix.length][matrix.length];

        for(int i = 0; i < buffMatrix.length; i++){
            for (int j = 0; j< buffMatrix[i].length; j++){
                buffMatrix[i][j] = matrix[j][i];
            }
        }

        ints.addAll(Arrays.asList(buffMatrix));

        Collections.rotate(ints, numberShifts);


        for (int i = 0; i < ints.size(); i++){
            buffMatrix[i] = ints.get(i);
        }

        int[][] newMatrix = new int[matrix.length][matrix.length];

        for(int i = 0; i < newMatrix.length; i++){
            for (int j = 0; j< newMatrix[i].length; j++){
                newMatrix[i][j] = buffMatrix[j][i];
            }
        }

        return newMatrix;
    }

}
