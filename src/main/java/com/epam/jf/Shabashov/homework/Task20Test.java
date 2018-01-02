package com.epam.jf.Shabashov.homework;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Task20Test {
    private Task20 tt = new Task20();

    @Test
    void test1() {
        Set<Task20.IPoem> poems = new HashSet<>();
        poems.add(new IPoemRealization(Arrays.asList("Sas", "sadasd", "asdasd"), "author1"));
        poems.add(new IPoemRealization(Arrays.asList("Sas", "sadasd", "asdasd"), "author2"));
        poems.add(new IPoemRealization(Arrays.asList("qqqq", "qqqqqqq", "aqqqqqsdasd"), "author1"));
        List<String> list = new ArrayList<>();
        list.add("Sas\nsadasd\nasdasd\n");
        list.add("qqqq\nqqqqqqq\naqqqqqsdasd\n");
        assertArrayEquals(tt.sortPoems(poems, "author1").toArray(), list.toArray());
    }


}