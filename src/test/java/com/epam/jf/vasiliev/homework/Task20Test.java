package com.epam.jf.vasiliev.homework;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.epam.jf.common.homework.Task20.IPoem;
import com.epam.jf.vasiliev.homework.Task20.Poem;

import static org.junit.jupiter.api.Assertions.*;

class Task20Test {
    Task20 ref = new Task20();

    @Test
    void testThreeAuthorsWithUniquePoems() {
        Set<IPoem> poems = new HashSet<>();
        poems.add(new Poem(Arrays.asList("qwer", "a", "sfdfsd"), "Author1"));
        poems.add(new Poem(Arrays.asList("12345", "lol", "55lw", "code"), "Author2"));
        poems.add(new Poem(Arrays.asList("asdf", "a", "dsf", "long-long line"), "Author3"));

        List<String> expected = Arrays.asList("a", "dsf", "asdf", "long-long line");
        List<String> result = ref.sortPoems(poems, "Author3");
        assertArrayEquals(expected.toArray(),result.toArray());
    }

    @Test
    void testTwoAuthorsOneHasMultiplePoems() {
        Set<IPoem> poems = new HashSet<>();
        poems.add(new Poem(Arrays.asList("Sas", "sadasd", "asdasd"), "author1"));
        poems.add(new Poem(Arrays.asList("Sas", "sadasd", "asdasd"), "author2"));
        poems.add(new Poem(Arrays.asList("qqqq", "qqqqqqq", "aqqqqqsdasd"), "author1"));

        List<String> expected = Arrays.asList("Sas", "qqqq", "sadasd", "asdasd", "qqqqqqq", "aqqqqqsdasd");
        List<String> result = ref.sortPoems(poems, "author1");
        assertArrayEquals(expected.toArray(),result.toArray());
    }

    @Test
    void testAuthorWithoutPoems() {
        Set<IPoem> poems = new HashSet<>();
        poems.add(new Poem(Arrays.asList("qwer", "a", "sfdfsd"), "Author1"));
        poems.add(new Poem(Arrays.asList("12345", "lol", "55lw", "code"), "Author2"));
        poems.add(new Poem(Arrays.asList("asdf", "a", "dsf", "long-long line"), "Author3"));

        List<String> expected = Arrays.asList();
        List<String> result = ref.sortPoems(poems, "Author4");
        assertArrayEquals(expected.toArray(),result.toArray());
    }
}