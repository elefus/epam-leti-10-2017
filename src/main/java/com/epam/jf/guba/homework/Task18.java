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
        int left =0;
        int right = 0;
        int maxLength = 0;
        for (int i = 0; i < source.size()-1; i++){
            int secLength = 0;
            secStart = i;
            while (i < source.size()-1 && source.get(i).compareTo(source.get(i + 1)) < 0){
                secLength++;
                i++;
            }
            secStop = i;
            if(secLength > maxLength){
                left = secStart;
                right = secStop;
                maxLength = secLength;
            }
        }
        return source.subList(left, right+1);
    }
}
