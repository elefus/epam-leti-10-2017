package com.epam.jf.yessenbayev.homework;

import org.junit.jupiter.api.Test;

import com.epam.jf.yessenbayev.homework.Task20.Poem;
import com.epam.jf.common.homework.Task20;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class Task20Test {

    @Test
    void test1() {
        Set<Task20.IPoem> poems = new HashSet<>();
        poems.add(new Poem(Arrays.asList("aaa", "bb", "c"), "Shakespeare"));
        poems.add(new Poem(Arrays.asList("aaa", "bb", "c"), "Shekspear"));
        poems.add(new Poem(Arrays.asList("cc", "bb", "ac"), "Shakespeare"));
        List<String> lines = new com.epam.jf.yessenbayev.homework.Task20().sortPoems(poems, "Shakespeare");
        String[] requiredLines = new String[]{"aaa", "ac", "bb", "bb", "c", "cc"};
        for (int i = 0; i < lines.size(); i++) {
            assertEquals(lines.get(i), requiredLines[i]);
        }
    }

}