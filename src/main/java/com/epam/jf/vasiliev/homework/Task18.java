package com.epam.jf.vasiliev.homework;

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
        int maxStartIndex = 0;
        int crtStartIndex = 0;
        int crtLength = 1;
        int maxLength = 1;

        for (int i = 1; i < source.size(); i++) {
            if(source.get(i).compareTo(source.get(i-1)) > 0) {
                crtLength++;
                continue;
            }

            if (crtLength > maxLength) {
                maxLength = crtLength;
                maxStartIndex = crtStartIndex;
            }

            crtStartIndex = i;
            crtLength = 1;
        }

        if (crtLength > maxLength) {
            maxLength = crtLength;
            maxStartIndex = crtStartIndex;
        }

        return source.subList(maxStartIndex, maxStartIndex + maxLength);
    }
}
