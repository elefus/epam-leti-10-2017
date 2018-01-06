package com.epam.jf.vasiliev.homework;

import java.util.*;

public class Task20 extends com.epam.jf.common.homework.Task20 {

    /**
     * Формирует упорядоченный список строк из стихотворений указанного автора.
     * @param poems Анализируемое множество стихотворений.
     * @param author Автор, стихотворения которого необходимо выбрать.
     * @return Список, упорядоченных по длине строк, составляющих стихотворения автора.
     */
    @Override
    public List<String> sortPoems(Set<IPoem> poems, String author) {
        ArrayList<String> lines = new ArrayList<>();
        for (IPoem crt : poems) {
            if (crt.getAuthor().equals(author)) {
                lines.addAll(crt.getLines());
            }
        }
        Collections.sort(lines, Comparator.comparingInt(String::length));
        return lines;
    }

    public static class Poem implements com.epam.jf.common.homework.Task20.IPoem {
        private List<String> lines;
        private String author;

        public Poem(List<String> lines, String author) {
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
