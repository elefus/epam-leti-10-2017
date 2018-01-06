package com.epam.jf.khvan.homework;

import com.epam.jf.common.homework.Task18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Task18Implement  extends Task18{

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,0,1,23,34,9,0,1,2,3,4,5,6,-999);
        List<Integer> test = new Task18Implement().getSublistOfMaximumIncreasingSequence(list);
        for (int i = 0; i < test.size() ; i++) {
            System.out.print(test.get(i) + " ");
        }
    }

    public <T extends Comparable<T>> List<T> getSublistOfMaximumIncreasingSequence(List<T> source) {
        int counter = 0;
        int counterPrevious = 0;
        int startPosition = 0;
        int tempPosition = 0;

        for (int i = 0; i < source.size() - 1 ; i++) {
            if ( source.get(i).compareTo(source.get(i + 1)) == - 1 ){
                counter++;
                if ( counter > counterPrevious)  {
                    counterPrevious = counter;
                    tempPosition = startPosition;
                }
            } else {
                startPosition = i + 1;
                counter = 0;
            }
        }
        return source.subList(tempPosition, tempPosition + counterPrevious + 1);
    }
}

