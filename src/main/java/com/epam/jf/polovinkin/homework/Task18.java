package com.epam.jf.polovinkin.homework;

import java.util.List;

public class Task18 extends com.epam.jf.common.homework.Task18 {
    @Override
    public <T extends Comparable<T>> List<T> getSublistOfMaximumIncreasingSequence(List<T> source) {
        T prev = source.get(0);
        List<T> sublist = source.subList(1, source.size());
        int i = 0;
        int length = 0;
        for (T item : sublist) {
            if (prev.compareTo(item) >= 0) {
                i++;
                length = 0;
            } else {
                length++;
            }
            prev = item;
        }
        return source.subList(i, i + length + 1);
    }
}
