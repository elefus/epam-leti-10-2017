package com.epam.jf.yessenbayev.homework;

import java.util.List;

public class Task18 extends com.epam.jf.common.homework.Task18 {
    @Override
    public <T extends Comparable<T>> List<T> getSublistOfMaximumIncreasingSequence(List<T> source) {
     if (source.size() > 0) {
         int begin = 0;
         int ElementsCounter = 0;
         int max = 0;
         for(int i = 1; i < source.size(); i++) {
            if(source.get(i).compareTo(source.get(i - 1)) > 0) {
                ElementsCounter++;
            } else {
                ElementsCounter = 0;
            }
            if (ElementsCounter > max) {
                max = ElementsCounter;
                begin = i - ElementsCounter;
            }
         }
         return source.subList(begin, begin + max + 1);
     } else {
         return null;
     }
    }
}
