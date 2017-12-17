package com.epam.jf.guba.homework;

import java.util.List;

public class Task18 extends com.epam.jf.common.homework.Task18 {

    @Override
    public <T extends Comparable<T>> List<T> getSublistOfMaximumIncreasingSequence(List<T> source) {
        if(source.size() < 2){
            throw new IllegalArgumentException("You need more then " + source.size() + " elements.");
        }
        int secStart = 0;
        int secStop = 0;
        for (int i = 0; i < source.size()-1; i++){
            int secLength = 0;
            while (i < source.size()-1 &&  source.get(i).compareTo(source.get(i+1)) == 1){
                secLength++;
            }
        }
        return null;
    }
}
