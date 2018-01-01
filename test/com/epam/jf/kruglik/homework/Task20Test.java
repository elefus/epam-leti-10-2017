package com.epam.jf.kruglik.homework;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class Task20Test {

    @Test
    void sortPoemsForFirstAuthor() {
        String[] res = {"bxczvh", "gjkfdsljk", "dklsfjlsj", "gjkfdsljk", "skdafhjksaf", "skdafhjksaf", "fbdjksjhjbbfdvjkbfnk"};
        List<String> lines = new LinkedList<>();
        lines.add("skdafhjksaf");
        lines.add("bxczvh");
        lines.add("gjkfdsljk");
        String author = "Kruglik";
        Task20.Poem poem = new Task20.Poem(lines, author);
        Set<Task20.IPoem> poems = new HashSet<>();
        poems.add(poem);
        lines.remove(1);
        lines.add("fbdjksjhjbbfdvjkbfnk");
        lines.add("dklsfjlsj");
        Task20.Poem poem2 = new Task20.Poem(lines, author);
        poems.add(poem2);
        assertArrayEquals(new Task20().sortPoems(poems,"Kruglik").toArray(),res);
    }

    @Test
    void sortPoemsForSecondAuthor() {
        String[] res = {"a", "aa", "aaa", "gjkfdsljk", "dklsfjlsj", "skdafhjksaf", "fbdjksjhjbbfdvjkbfnk"};
        List<String> lines = new LinkedList<>();
        lines.add("skdafhjksaf");
        lines.add("bxczvh");
        lines.add("gjkfdsljk");
        String author = "Kruglik";
        String author2 = "Kruglyak";
        Task20.Poem poem = new Task20.Poem(lines, author);
        Set<Task20.IPoem> poems = new HashSet<>();
        poems.add(poem);
        lines.remove(1);
        lines.add("fbdjksjhjbbfdvjkbfnk");
        lines.add("dklsfjlsj");
        Task20.Poem poem2 = new Task20.Poem(lines, author);
        poems.add(poem2);
        lines.add("a");
        lines.add("aa");
        lines.add("aaa");
        Task20.Poem poem3 = new Task20.Poem(lines, author2);
        poems.add(poem3);
        assertArrayEquals(new Task20().sortPoems(poems,"Kruglyak").toArray(),res);
    }
}