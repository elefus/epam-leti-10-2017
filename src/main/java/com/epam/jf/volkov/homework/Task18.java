package com.epam.jf.volkov.homework;

import java.util.List;

public class Task18 {

    /**
     * Осуществляет поиск максимальной по длине подпоследовательности строго возрастающих элементов, идущих подряд.
     * Оператор отношения можно определить на множестве, включающем более одного элемента.
     * @param source Анализируемый список.
     * @return Подсписок, выделенный из исходного, содержащий найденную подпоследовательность {@link List#subList(int, int)}.
     */
    public <T extends Comparable<T>> List<T> getSublistOfMaximumIncreasingSequence(List<T> source) {
        if (source.size() > 0) {
            int startIndex = 0;
            int counter = 0;
            int maxCount = 0;
            for (int i = 1; i < source.size(); i++) {
                if (source.get(i).compareTo(source.get(i - 1)) > 0) {
                    counter++;
                } else {
                    counter = 0;
                }
                if (counter > maxCount) {
                    startIndex = i - counter;
                    maxCount = counter;
                }
            }
            return (source.subList(startIndex, startIndex + maxCount + 1));
        }
        return null;
    }
}
