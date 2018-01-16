package com.epam.jf.yessenbayev.homework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Task20 extends com.epam.jf.common.homework.Task20 {

    @Override
    public List<String> sortPoems(Set<IPoem> poems, String author) {
        List<String> poemLines = new LinkedList<>();
        for(IPoem poem: poems) {
            if(poem.getAuthor().equals(author)) {
                poemLines.addAll(poem.getLines());
            }
        }
        poemLines.sort(String::compareTo);
        return poemLines;
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
