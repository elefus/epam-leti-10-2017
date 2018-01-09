package com.epam.jf.kozlov.homework;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class Task20 extends com.epam.jf.common.homework.Task20 {

    /**
     * Формирует упорядоченный список строк из стихотворений указанного автора.
     * @param poems Анализируемое множество стихотворений.
     * @param author Автор, стихотворения которого необходимо выбрать.
     * @return Список, упорядоченных по длине строк, составляющих стихотворения автора.
     */
    @Override
    public List<String> sortPoems(Set<IPoem> poems, String author) {
        ArrayList<String> authorLines = new ArrayList<>();
        for (IPoem poem : poems) {
            if (author.equals(poem.getAuthor())) {
                authorLines.addAll(poem.getLines());
            }
        }
        authorLines.sort(Comparator.comparingInt(String::length));
        return authorLines;
    }

    static class Poem implements IPoem {

        private ArrayList<String> lines;
        private String author;

        Poem(ArrayList<String> lines, String author) {
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
