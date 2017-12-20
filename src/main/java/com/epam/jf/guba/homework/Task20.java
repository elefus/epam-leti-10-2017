package com.epam.jf.guba.homework;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public class Task20 extends com.epam.jf.common.homework.Task20 {

    @Override
    public List<String> sortPoems(Set<IPoem> poems, String author) {
        if(poems == null || author == null){
            throw new IllegalArgumentException("Your arguments is null");
        }
        List<String> result = new ArrayList<>();
        for (IPoem iPoem : poems){
            if(iPoem.getAuthor().equals(author)){
                result.addAll(iPoem.getLines());
            }
        }
        result.sort(String::compareTo);
        result.sort(Comparator.comparingInt(String::length));
        return result;
    }

}
