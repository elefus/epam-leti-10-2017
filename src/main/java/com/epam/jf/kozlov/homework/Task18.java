package com.epam.jf.kozlov.homework;

import java.util.Collections;
import java.util.List;

public class Task18 extends com.epam.jf.common.homework.Task18 {
    /**
     * Осуществляет поиск максимальной по длине подпоследовательности строго возрастающих элементов, идущих подряд.
     * Оператор отношения можно определить на множестве, включающем более одного элемента.
     * @param source Анализируемый список.
     * @return Подсписок, выделенный из исходного, содержащий найденную подпоследовательность {@link List#subList(int, int)}.
     */
    @Override
    public  <T extends Comparable<T>> List<T> getSublistOfMaximumIncreasingSequence(List<T> source) {
        if (source.isEmpty()) {
            return Collections.emptyList();
        }
        int index = 0;
        int maxStartIndex = 0;
        int maxLength = 0;
        int curStartIndex = 0;
        int curLength = 0;
        T previous = source.get(0);
        for (T element : source) {
            if (element.compareTo(previous) > 0) {
                curLength++;
                if (index == source.size() - 1 && curLength > maxLength) {
                    maxLength = curLength;
                    maxStartIndex = curStartIndex;
                }
            } else {
                if (curLength > maxLength) {
                    maxLength = curLength;
                    maxStartIndex = curStartIndex;
                }
                curStartIndex = index;
                curLength = 0;
            }
            previous = element;
            index++;
        }
        return source.subList(maxStartIndex, maxStartIndex + maxLength + 1);
    }
}
