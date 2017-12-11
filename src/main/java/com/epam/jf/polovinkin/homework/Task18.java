package com.epam.jf.polovinkin.homework;

import java.util.Collections;
import java.util.List;

public class Task18 extends com.epam.jf.common.homework.Task18 {
    @Override
    public <T extends Comparable<T>> List<T> getSublistOfMaximumIncreasingSequence(List<T> source) {
        if (source.size() < 2) return Collections.emptyList();
        T prev = source.get(0);
        List<T> sublist = source.subList(1, source.size());
        int maxI = 0;
        int maxLength = 1;

        int i = 0;
        int length = 1;
        for (T item : sublist) {
            if (prev.compareTo(item) >= 0) {
                if (length > maxLength) {
                    maxI = i;
                    maxLength = length;
                }
                i++;
                length = 1;
            } else {
                length++;
            }
            prev = item;
        }
        if (maxLength == 1) return Collections.emptyList();
        return source.subList(maxI, maxI + maxLength);
    }
}
