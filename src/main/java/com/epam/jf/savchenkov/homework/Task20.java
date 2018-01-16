package com.epam.jf.savchenkov.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Task20 extends com.epam.jf.common.homework.Task20 {

    @Override
    public List<String> sortPoems(Set<IPoem> poems, String author) {
        List<String> sortedPoemsList = new ArrayList<>();

        for (IPoem poem : poems) {
            if (poem.getAuthor().equals(author)) {
                sortedPoemsList.addAll(poem.getLines());
            }
        }

        sortedPoemsList.sort(String::compareTo);
        return sortedPoemsList;
    }

    static class Poem implements IPoem {

        private String author;
        private List<String> lines;

        public Poem(String author, List<String> lines) {
            this.author = author;
            this.lines = lines;
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
