package com.epam.jf.khvan.homework;

import java.util.*;

public class Task20Implement extends Task20 {

    @Override
    public List<String> sortPoems(Set<IPoem> poems, String author) {
        List<String> list = new ArrayList<>();

        for (IPoem a: poems) {
            if ( a.getAuthor() == author ){
                a.getLines().forEach(line -> list.add(line));
            }
        }

        Collections.sort(list, String::compareTo);
        Collections.sort(list, Comparator.comparingInt(String::length));

        return list;
    }
}

