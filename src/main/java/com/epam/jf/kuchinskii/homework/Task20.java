package com.epam.jf.kuchinskii.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class Task20 extends com.epam.jf.common.homework.Task20 {

    @Override
    public List<String> sortPoems(Set<IPoem> poems, String author) {
        List<String> result = new ArrayList<>();

        for (IPoem poem : poems) {
            if (poem.getAuthor().equals(author)) {
                result.addAll(poem.getLines());
            }
        }
        result.sort(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()));
        
        return result;
    }

    class Poem implements IPoem {

        private String author;
        private List<String> lines;

        public Poem(String author, String... lines) {
            this.author = author;
            this.lines = Arrays.asList(lines);
        }

        @Override
        public String getAuthor() {
            return author;
        }

        @Override
        public List<String> getLines() {
            return lines;
        }
    }
}


