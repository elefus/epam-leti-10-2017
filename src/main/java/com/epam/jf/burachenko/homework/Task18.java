package com.epam.jf.burachenko.homework;

import java.util.List;

public class Task18 extends com.epam.jf.common.homework.Task18 {
    @Override
    public <T extends Comparable<T>> List<T> getSublistOfMaximumIncreasingSequence(List<T> source) {
        if(source.size() == 0) {
            return null;
        }

        int resultFrom = 0;
        int resultTo = 0;
        int from = 0;
        int to = 0;

        for (int i = 1; i < source.size(); i++) {
            if (source.get(i).compareTo(source.get(i - 1)) > 0) {
                to = i;
            } else {
                if (to - from > resultTo - resultFrom) {
                    resultFrom = from;
                    resultTo = to;
                }
                from = i;
            }
        }

        if(to - from > resultTo - resultFrom) {
            resultFrom = from;
            resultTo = to;
        }
        return source.subList(resultFrom, resultTo + 1);
    }
}
