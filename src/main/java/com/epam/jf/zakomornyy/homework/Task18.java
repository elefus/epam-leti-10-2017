package com.epam.jf.zakomornyy.homework;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Task18 extends com.epam.jf.common.homework.Task18 {
    @Override
    public <T extends Comparable<T>> List<T> getSublistOfMaximumIncreasingSequence(List<T> source) {
        if(source.size() < 2) {
            return Collections.emptyList();
        }
        Iterator<T> iter = source.iterator();
        int fromIndex = 0;
        int toIndex = 0;
        int maxLen = 0;
        int maxFromIndex = 0;
        int maxToIndex = 0;
        T e1 = iter.next();
        T e2;
        for (int i = 0; iter.hasNext();) {
            e2 = iter.next();
            if(e1.compareTo(e2) < 0) {
                toIndex = ++i;

            } else {
                fromIndex = ++i;
                toIndex = i;

            }
            if(toIndex - fromIndex + 1 > maxLen) {
                maxFromIndex = fromIndex;
                maxToIndex = toIndex;
                maxLen = toIndex - fromIndex + 1;
            }
            e1 = e2;

        }
        return source.subList(maxFromIndex, maxToIndex + 1);
    }
}
