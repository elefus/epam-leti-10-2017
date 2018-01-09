package com.epam.jf.kuchinskii.homework;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class Task20Test {

    @Test
    public void testEmptySet() {
        List<String> sortedPoems;
        Task20 t = new Task20();

        sortedPoems = t.sortPoems(new HashSet<>(), "");
        assertTrue(sortedPoems.isEmpty());
    }

    @Test
    public void testSet() {
        List<String> sortedPoems;
        Task20 t = new Task20();
        Set<Task20.IPoem> poems = new HashSet<>();

        poems.add(t.new Poem("a", "a", "aa", "aaa"));
        poems.add(t.new Poem("b", "b", "bb", "bbb"));
        poems.add(t.new Poem("c", "c", "cc", "ccc"));
        poems.add(t.new Poem("d", "d", "dd", "ddd"));
        poems.add(t.new Poem("a", "a2", "aa2", "aaa2"));

        sortedPoems = t.sortPoems(poems, "a");
        List<String> check = Arrays.asList("a", "a2", "aa", "aa2", "aaa", "aaa2");
        assertTrue(sortedPoems.equals(check));
    }

    @Test
    public void testNoAuthor() {
        List<String> sortedPoems;
        Task20 t = new Task20();
        Set<Task20.IPoem> poems = new HashSet<>();

        poems.add(t.new Poem("a", "a", "aa", "aaa"));
        poems.add(t.new Poem("b", "b", "bb", "bbb"));
        poems.add(t.new Poem("c", "c", "cc", "ccc"));
        poems.add(t.new Poem("d", "d", "dd", "ddd"));
        poems.add(t.new Poem("a", "a2", "aa2", "aaa2"));

        sortedPoems = t.sortPoems(poems, "e");
        assertTrue(sortedPoems.isEmpty());
    }
}
