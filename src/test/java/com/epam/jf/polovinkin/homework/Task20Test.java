package com.epam.jf.polovinkin.homework;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class Task20Test {

    @Test
    void sortPoems() {
        Set<Task20.IPoem> poems = new HashSet<>();
        poems.add(new Task20.Poem(Arrays.asList("Sa1s", "sadasd", "asdas1d"), "author1"));
        poems.add(new Task20.Poem(Arrays.asList("Sas", "sadasd", "asdasd"), "author2"));
        poems.add(new Task20.Poem(Arrays.asList("qqqq", "qqqqqqq", "aqqqqqsdasd"), "author1"));

        String[] actualStrings = {"Sa1s", "qqqq", "sadasd", "asdas1d", "qqqqqqq", "aqqqqqsdasd"};
        assertArrayEquals( actualStrings, new Task20().sortPoems(poems, "author1").toArray());
    }
}