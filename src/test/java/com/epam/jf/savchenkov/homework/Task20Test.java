package com.epam.jf.savchenkov.homework;

import com.epam.jf.savchenkov.homework.Task20.Poem;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class Task20Test {

    @Test
    void test() {
        Poem a = new Poem("Pushkin", Arrays.asList("aaa", "aa", "aaaa"));
        Poem b = new Poem("Esenin", Arrays.asList("bb", "bbb", "b"));
        Poem c = new Poem("Mayakovskiy", Arrays.asList("c", "c", "ccc"));
        Poem d = new Poem("Fet", Arrays.asList("dddd", "ddd", "dd", "d"));

        Task20 task20 = new Task20();
        HashSet<com.epam.jf.common.homework.Task20.IPoem> poem = new HashSet<>();
        poem.add(a);
        poem.add(b);
        poem.add(c);
        poem.add(d);

        assertEquals(Arrays.asList("aa", "aaa", "aaaa"), task20.sortPoems(poem, "Pushkin"));
        assertEquals(Arrays.asList("b", "bb", "bbb"), task20.sortPoems(poem, "Esenin"));
        assertEquals(Arrays.asList("c", "c", "ccc"), task20.sortPoems(poem, "Mayakovskiy"));
        assertEquals(Arrays.asList("d", "dd", "ddd", "dddd"), task20.sortPoems(poem, "Fet"));
    }
}