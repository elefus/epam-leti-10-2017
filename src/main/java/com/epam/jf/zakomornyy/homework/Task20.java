package com.epam.jf.zakomornyy.homework;

import java.util.*;


public class Task20 extends com.epam.jf.common.homework.Task20 {

    @Override
    public List<String> sortPoems(Set<IPoem> poems, String author) {
        List<String> authorsPoemsLines = new LinkedList<>();
        for (IPoem poem: poems) {
            if(poem.getAuthor().equals(author)) {
                authorsPoemsLines.addAll(poem.getLines());
            }
        }
        authorsPoemsLines.sort(String::compareTo);
        return authorsPoemsLines;
    }

    public static class Poem implements com.epam.jf.common.homework.Task20.IPoem{
        private List<String> lines;
        private String autor;

        Poem(List<String> lines, String autor) {
            this.lines = lines;
            this.autor = autor;
        }
        @Override
        public List<String> getLines() {
            return lines;
        }

        @Override
        public String getAuthor() {
            return autor;
        }
    }
}
