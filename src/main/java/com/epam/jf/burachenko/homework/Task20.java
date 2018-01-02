package com.epam.jf.burachenko.homework;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class Task20 extends com.epam.jf.common.homework.Task20 {
    @Override
    public List<String> sortPoems(Set<com.epam.jf.common.homework.Task20.IPoem> poems, String author) {
        List<String> sortedLines = new ArrayList<>();

        for (com.epam.jf.common.homework.Task20.IPoem poem : poems) {
            if(poem.getAuthor().equals(author)) {
                sortedLines.addAll(poem.getLines());
            }
        }

        sortedLines.sort(Comparator.comparingInt(String::length));
        return sortedLines;
    }

    public static class IPoem implements com.epam.jf.common.homework.Task20.IPoem {
        final List<String> lines;
        final String author;

        public IPoem(List<String> lines, String author) {
            this.lines = lines;
            this.author = author;
        }

        @Override
        public List<String> getLines() {
            return lines;
        }

        @Override
        public String getAuthor() {
            return author;
        }
    }
}
