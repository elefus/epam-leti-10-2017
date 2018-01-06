package com.epam.jf.polovinkin.homework;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task20 extends com.epam.jf.common.homework.Task20 {
    @Override
    public List<String> sortPoems(Set<IPoem> poems, String author) {
        poems.stream()
             .filter(x -> Objects.equals(x.getAuthor(), author))
             .map(IPoem::getLines)
             .reduce((a, b) -> Stream.concat(a.stream(), b.stream()).collect(Collectors.toList()))
             .orElse(Collections.emptyList())
             .sort(Comparator.comparingInt(String::length));
        return null;
    }
}
