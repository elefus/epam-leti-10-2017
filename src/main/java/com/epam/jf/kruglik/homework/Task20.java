package com.epam.jf.kruglik.homework;

import java.util.*;

public class Task20 {

    /**
     * Формирует упорядоченный список строк из стихотворений указанного автора.
     * @param poems Анализируемое множество стихотворений.
     * @param author Автор, стихотворения которого необходимо выбрать.
     * @return Список, упорядоченных по длине строк, составляющих стихотворения автора.
     */
    public List<String> sortPoems(Set<IPoem> poems, String author){
        List<String> authorLines = new LinkedList<>();
        for (IPoem poem : poems) {
            if (poem.getAuthor().compareTo(author) == 0){
                authorLines.addAll(poem.getLines());
            }
        }
        authorLines.sort(Comparator.comparingInt(String::length));
        return authorLines;
    }

    public static class Poem implements  IPoem {
        List<String> lines;
        String author;

        Poem(List<String> lines,String author){
            this.lines = new LinkedList<>();
            this.lines.addAll(lines);
            this.author = author;
        }

        @Override
        public List<String> getLines() {
            return this.lines;
        }

        @Override
        public String getAuthor() {
            return this.author;
        }
    }


    /**
     * Стихотворение.
     */
    public interface IPoem {

        /**
         * @return Список строк, составляющих стихотворение.
         */
        List<String> getLines();

        /**
         * @return Автор стихотворения.
         */
        String getAuthor();
    }
}
