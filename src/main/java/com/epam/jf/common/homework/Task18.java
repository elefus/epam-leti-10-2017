package com.epam.jf.common.homework;

import java.util.List;

public abstract class Task18 {

    /**
     * Осуществляет поиск максимальной по длине подпоследовательности строго возрастающих элементов, идущих подряд.
     * Оператор отношения можно определить на множестве, включающем более одного элемента.
     * @param source Анализируемый список.
     * @return Подсписок, выделенный из исходного, содержащий найденную подпоследовательность {@link List#subList(int, int)}.
     */
    public abstract <T extends Comparable<T>> List<T> getSublistOfMaximumIncreasingSequence(List<T> source);
}
