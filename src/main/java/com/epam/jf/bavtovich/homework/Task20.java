package com.epam.jf.bavtovich.homework;

import java.util.*;

public class Task20 {

    /**
     * Формирует упорядоченный список строк из стихотворений указанного автора.
     * @param poems Анализируемое множество стихотворений.
     * @param author Автор, стихотворения которого необходимо выбрать.
     * @return Список, упорядоченных по длине строк, составляющих стихотворения автора.
     */
    public static List<String> sortPoems(Set<? extends IPoem> poems, String author) {
        List<String> authorsPoems = new ArrayList<>();
        for (IPoem poem: poems) {
            if (poem.getAuthor().equals(author)) {
                authorsPoems.addAll(poem.getLines());
            }
        }
        authorsPoems.sort(((o1, o2) -> Integer.compare(o1.length(), o2.length())));
        return authorsPoems;
    }


    static class Poem implements IPoem {

        public Poem(String author, List<String> poemsText) {
            this.author = author;
            this.poemsText = new ArrayList(poemsText);
        }

        public Poem(String author, String poemsText) {
            this.author = author;
            this.poemsText = new ArrayList<String>(Arrays.asList(poemsText.split("\\n")));
        }

        private String author;
        private ArrayList<String> poemsText;

        @Override
        public List<String> getLines() {
            return poemsText;
        }

        @Override
        public String getAuthor() {
            return author;
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
