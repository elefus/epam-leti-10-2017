package com.epam.jf.kruglik.homework;

import java.util.LinkedList;
import java.util.List;

public class Task18 {

    /**
     * Осуществляет поиск максимальной по длине подпоследовательности строго возрастающих элементов, идущих подряд.
     * Оператор отношения можно определить на множестве, включающем более одного элемента.
     * @param source Анализируемый список.
     * @return Подсписок, выделенный из исходного, содержащий найденную подпоследовательность {@link List#subList(int, int)}.
     */
    public  <T extends Comparable<T>> List<T> getSublistOfMaximumIncreasingSequence(List<T> source){
        int maxElements = 0;
        int numberElementsNow = 1;
        int leftRange = 0;
        int rightRange = 0;
        int resultLeftRange = 0;
        int resultRightRange = 0;
        for (int i = 0; i < source.size(); i++) {
            if (i < (source.size() - 1) && source.get(i).compareTo(source.get(i + 1)) < 0){
                ++numberElementsNow;
                ++rightRange;
            } else {
                if (maxElements < numberElementsNow){
                    maxElements = numberElementsNow;
                    resultLeftRange = leftRange;
                    resultRightRange = rightRange;
                }
                numberElementsNow = 1;
                leftRange = i + 1;
                rightRange = i + 1;
            }
        }

        List<T> subList = new LinkedList<>();
        for (int i = resultLeftRange; i < (resultRightRange + 1); i++) {
            subList.add(source.get(i));
        }

        return subList;
    }
}
