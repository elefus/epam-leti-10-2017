package com.epam.jf.polovinkin.homework;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task20 extends com.epam.jf.common.homework.Task20 {
    @Override
    public List<String> sortPoems(Set<IPoem> poems, String author) {
        return poems.stream()
                    .filter(x -> Objects.equals(x.getAuthor(), author))
                    .map(IPoem::getLines)
                    .reduce((a, b) -> Stream.concat(a.stream(), b.stream())
                                            .collect(Collectors.toList()))
                    .orElse(Collections.emptyList())
                    .stream()
                    .sorted((a, b) -> b.length() - a.length())
                    .collect(Collectors.toList());
    }

    static class Poem implements IPoem {

        private List<String> poems;
        private String author;

        public Poem(List<String> poems, String author) {
            this.poems = poems;
            this.author = author;
        }

        @Override
        public List<String> getLines() {
            return new ArrayList<>(poems);
        }

        @Override
        public String getAuthor() {
            return author;
        }
    }
}


