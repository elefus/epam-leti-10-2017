package com.epam.jf.zakomornyy.homework;

import com.epam.jf.common.homework.Task20;
import com.epam.jf.zakomornyy.homework.Task20.Poem;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;


class Task20Test {
    @Test
    void sortPoems() {
        Set<Task20.IPoem> poems = new HashSet<>();
        poems.add(new Poem(Arrays.asList("aaa", "bb", "c"), "Shakespeare"));
        poems.add(new Poem(Arrays.asList("aaa", "bb", "c"), "Shekspear"));
        poems.add(new Poem(Arrays.asList("cc", "bb", "ac"), "Shakespeare"));
        List<String> lines = new com.epam.jf.zakomornyy.homework.Task20().sortPoems(poems, "Shakespeare");
        String[] requiredLines = new String[]{"aaa", "ac", "bb", "bb", "c", "cc"};
        for (int i = 0; i < lines.size(); i++) {
            assertEquals(lines.get(i), requiredLines[i]);
        }
    }

}