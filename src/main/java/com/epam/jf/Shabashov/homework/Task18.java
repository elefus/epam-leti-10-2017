package com.epam.jf.Shabashov.homework;

import java.util.ArrayList;
import java.util.List;

public class Task18 {

    /**
     * Осуществляет поиск максимальной по длине подпоследовательности строго возрастающих элементов, идущих подряд.
     * Оператор отношения можно определить на множестве, включающем более одного элемента.
     *
     * @param source Анализируемый список.
     * @return Подсписок, выделенный из исходного, содержащий найденную подпоследовательность {@link List#subList(int, int)}.
     */
    public <T extends Comparable<T>> List<T> getSublistOfMaximumIncreasingSequence(List<T> source) {
        int answerLeft = 0;
        int maxRange = 0;
        int range = 1;
        for (int i = 0; i < source.size() - 1; i++) {
            if (source.get(i).compareTo(source.get(i + 1)) < 0) {
                range++;
            } else {
                if (range > maxRange) {
                    answerLeft = i - range + 1;
                    maxRange = range;
                }
                range = 1;
            }
        }
        if (range > maxRange) {
            answerLeft = source.size() - range;
            maxRange = range;
        }
        if (maxRange <= 1) return null;
        List<T> list = new ArrayList<>(maxRange);
        for (int i = answerLeft; i < answerLeft + maxRange; i++) {
            list.add(source.get(i));
        }
        return list;
    }
}