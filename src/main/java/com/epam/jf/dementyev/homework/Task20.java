package com.epam.jf.dementyev.homework;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class Task20 extends com.epam.jf.common.homework.Task20 {

    @Override
    public List<String> sortPoems(Set<IPoem> poems, String author) {
        if (poems == null || author == null) {
            throw new IllegalArgumentException();
        }
        List<String> result = new ArrayList<>(0);
        for (IPoem poem : poems) {
            if (poem.getAuthor().equals(author)) {
                result.addAll(poem.getLines());
            }
        }
        result.sort(Comparator.comparingInt(String::length));
        return result;
    }
}
