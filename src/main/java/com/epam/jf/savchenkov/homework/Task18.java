package com.epam.jf.savchenkov.homework;

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
        if (source.size() > 0) {
            int start = 0;
            int counter = 0;
            int max = 0;
            for (int i = 1; i < source.size(); i++) {
                if (source.get(i).compareTo(source.get(i - 1)) > 0) {
                    counter++;
                } else {
                    counter = 0;
                }
                if (counter > max) {
                    start = i - counter;
                    max = counter;
                }
            }
            return source.subList(start,start + max + 1);
        } else {
            return null;
        }
    }
}
