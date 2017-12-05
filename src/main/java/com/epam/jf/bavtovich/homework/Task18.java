package com.epam.jf.bavtovich.homework;

import java.util.ArrayList;
import java.util.List;

public class Task18 extends com.epam.jf.common.homework.Task18 {
    /**
     * Осуществляет поиск максимальной по длине подпоследовательности строго возрастающих элементов, идущих подряд.
     * Оператор отношения можно определить на множестве, включающем более одного элемента.
     * @param source Анализируемый список.
     * @return Подсписок, выделенный из исходного, содержащий найденную подпоследовательность {@link List#subList(int, int)}.
     */
    @Override
    public <T extends Comparable<T>> List<T> getSublistOfMaximumIncreasingSequence(List<T> source) {
        int[] maxElemOfIncreasingSeq = new int[source.size()];
        int maxIndex = 0;
        maxElemOfIncreasingSeq[0] = 1;
        int maxLength = 1;

        for (int i = 1; i < source.size(); i++) {
            maxElemOfIncreasingSeq[i] = 1;
            if (source.get(i - 1).compareTo(source.get(i)) < 0) {
                maxElemOfIncreasingSeq[i] = maxElemOfIncreasingSeq[i-1] + 1;
                if (maxElemOfIncreasingSeq[i] > maxLength) {
                    maxIndex = i;
                    maxLength = maxElemOfIncreasingSeq[i];
                }
            }
        }
        return source.subList(maxIndex + 1 - maxElemOfIncreasingSeq[maxIndex], maxIndex + 1);
    }
}
