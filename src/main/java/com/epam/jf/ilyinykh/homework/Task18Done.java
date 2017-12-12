package com.epam.jf.ilyinykh.homework;

import com.epam.jf.common.homework.Task18;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Task18Done extends Task18 {
    /**
     * Осуществляет поиск максимальной по длине подпоследовательности строго возрастающих элементов, идущих подряд.
     * Оператор отношения можно определить на множестве, включающем более одного элемента.
     *
     * @param source Анализируемый список.
     * @return Подсписок, выделенный из исходного, содержащий найденную подпоследовательность {@link List#subList(int, int)}.
     */
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
