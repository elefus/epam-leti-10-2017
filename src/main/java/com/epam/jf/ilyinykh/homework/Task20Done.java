package com.epam.jf.ilyinykh.homework;

import com.epam.jf.common.homework.Task20;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class Task20Done extends Task20 {

    /**
     * Формирует упорядоченный список строк из стихотворений указанного автора.
     *
     * @param poems  Анализируемое множество стихотворений.
     * @param author Автор, стихотворения которого необходимо выбрать.
     * @return Список, упорядоченных по длине строк, составляющих стихотворения автора.
     */
    @Override
    public List<String> sortPoems(Set<IPoem> poems, String author) {
        ArrayList<String> lines = new ArrayList<>();

        for (IPoem poem : poems) {
            if (author.equals(poem.getAuthor())) {
                lines.addAll(poem.getLines());
            }
        }
        lines.sort(Comparator.comparingInt(String::length));

        return lines;
    }
}

class Poem implements Task20.IPoem {
    private List<String> strings;
    private String author;

    public Poem(List<String> strings, String author) {
        this.strings = strings;
        this.author = author;
    }

    /**
     * @return Список строк, составляющих стихотворение.
     */
    @Override
    public List<String> getLines() {
        return strings;
    }

    /**
     * @return Автор стихотворения.
     */
    @Override
    public String getAuthor() {
        return author;
    }
}
