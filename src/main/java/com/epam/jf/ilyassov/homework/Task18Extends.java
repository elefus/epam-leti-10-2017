package com.epam.jf.ilyassov.homework;

import com.epam.jf.common.homework.Task18;

import java.util.List;

/**
 * Created by Sasuk on 16.01.2018.
 */
public class Task18Extends extends Task18 {
    @Override
    public <T extends Comparable<T>> List<T> getSublistOfMaximumIncreasingSequence(List<T> source) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < source.size(); i++) {
            int j = i + 1;
            while (j < source.size() && source.get(j).compareTo(source.get(j - 1)) > 0) {
                j++;
            }
            if (end - start < j - i) {
                start = i;
                end = j;
            }
        }
        return source.subList(start, end);
    }
}
