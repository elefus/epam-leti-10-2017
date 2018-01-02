package com.epam.jf.Shabashov.homework;

import java.util.*;

public class Task20 {

    /**
     * Формирует упорядоченный список строк из стихотворений указанного автора.
     *
     * @param poems  Анализируемое множество стихотворений.
     * @param author Автор, стихотворения которого необходимо выбрать.
     * @return Список, упорядоченных по длине строк, составляющих стихотворения автора.
     */
    public List<String> sortPoems(Set<IPoem> poems, final String author) {
        List<String> list = new ArrayList<>();
        poems.forEach((IPoem poem) -> {
            if (poem.getAuthor().equals(author)) {
                StringBuilder sb = new StringBuilder();
                for (String str : poem.getLines()) {
                    sb.append(str).append('\n');
                }
                list.add(sb.toString());
            }
        });
        list.sort(Comparator.comparingInt(String::length));
        return list;
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

class IPoemRealization implements Task20.IPoem {
    final List<String> lines;
    final String author;

    IPoemRealization(List<String> lines, String author) {
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