package com.epam.jf.dementyev.homework;

import java.util.List;

public class Task18 extends com.epam.jf.common.homework.Task18 {

    @Override
    public <T extends Comparable<T>> List<T> getSublistOfMaximumIncreasingSequence(List<T> source) {
        if (source.size() == 0) {
            return null;
        }
        int maxSeqIndexStart = 0;
        int maxSeqIndexEnd = 0;
        int currentSeqIndexStart = 0;
        int currentSeqIndexEnd = 0;
        int index = 0;
        T prewElem = null;
        for (T currentElem : source) {
            if (index > 0) {
                if (prewElem.compareTo(currentElem) < 0) {
                    currentSeqIndexEnd++;
                } else {
                    if (currentSeqIndexEnd - currentSeqIndexStart > maxSeqIndexEnd - maxSeqIndexStart) {
                        maxSeqIndexStart = currentSeqIndexStart;
                        maxSeqIndexEnd = currentSeqIndexEnd;
                    }
                    currentSeqIndexStart = index;
                    currentSeqIndexEnd = index;
                }
            }
            prewElem = currentElem;
            index++;
        }
        if (currentSeqIndexEnd - currentSeqIndexStart > maxSeqIndexEnd - maxSeqIndexStart) {
            maxSeqIndexStart = currentSeqIndexStart;
            maxSeqIndexEnd = currentSeqIndexEnd;
        }
        return source.subList(maxSeqIndexStart, maxSeqIndexEnd + 1);
    }
}
