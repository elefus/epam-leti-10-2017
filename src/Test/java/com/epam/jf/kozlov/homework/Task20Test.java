package com.epam.jf.kozlov.homework;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class Task20Test {

    @Test
    void poemSortTest() {
        Task20.Poem authorA = new Task20.Poem(new ArrayList<String>(Arrays.asList("AAA", "AA", "A", "AAAA")), "A");
        Task20.Poem authorB = new Task20.Poem(new ArrayList<String>(Arrays.asList("BBBB", "B", "BBBB", "BB")), "B");
        Task20.Poem authorC = new Task20.Poem(new ArrayList<String>(Arrays.asList("C", "CCC", "CC", "CCCC")), "C");

        HashSet<com.epam.jf.common.homework.Task20.IPoem> poemSet = new HashSet<>();

        poemSet.add(authorA);
        poemSet.add(authorB);
        poemSet.add(authorC);

        Task20 task = new Task20();

        assertEquals(Arrays.asList("A", "AA", "AAA", "AAAA"), task.sortPoems(poemSet, "A"));
        assertEquals(Arrays.asList("B", "BB", "BBBB", "BBBB"), task.sortPoems(poemSet, "B"));
        assertEquals(Arrays.asList("C", "CC", "CCC", "CCCC"), task.sortPoems(poemSet, "C"));
    }

}