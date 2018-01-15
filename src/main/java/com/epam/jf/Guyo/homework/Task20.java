package com.epam.jf.Guyo.homework;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class Task20 extends com.epam.jf.common.homework.Task20{

    @Override
    public List<String> sortPoems(Set<IPoem> poems, String author) {
        List<String> sortedPoemsList = new ArrayList<>();

        for (IPoem poem : poems) {
            if (poem.getAuthor().equals(author)){
                sortedPoemsList.addAll(poem.getLines());
            }
        }
        sortedPoemsList.sort(new PoemComparator());
        return sortedPoemsList;
    }

    static class PoemComparator implements Comparator<String> {
        public int compare(String str1, String str2){
            if (str1.length() == str2.length()){
                return str1.compareTo(str2);
            }
            else {
                return (str1.length() - str2.length());
            }
        }
    }

    static class Poem implements IPoem{
        private List<String> lines;
        private String author;

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