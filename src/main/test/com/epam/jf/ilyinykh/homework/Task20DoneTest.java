package com.epam.jf.ilyinykh.homework;

import com.epam.jf.common.homework.Task20;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

class Task20DoneTest {

    @Test
    void sortPoems() {
        Set<Task20.IPoem> poems = new HashSet<>();
        poems.add(new Poem(Arrays.asList("kek", "0", "141820", "0000"), "ilya"));
        poems.add(new Poem(Arrays.asList("vot", "vam"), "on"));

        List<String> list = new Task20Done().sortPoems(poems, "ilya");
        System.out.println(list);

        assertTrue(list.get(0).equals("0"));


    }
}