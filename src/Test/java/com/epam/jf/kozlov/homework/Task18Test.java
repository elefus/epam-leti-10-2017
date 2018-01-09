package com.epam.jf.kozlov.homework;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Task18Test {

    @Test
    void emptyListTest() {
        Task18 task = new Task18();
        assertTrue(task.getSublistOfMaximumIncreasingSequence(new ArrayList<Integer>()).isEmpty());
    }

    @Test
    void oneElementListTest() {
        Task18 task = new Task18();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        assertEquals(list ,task.getSublistOfMaximumIncreasingSequence(list));
    }

    @Test
    void MultipleElementListTest() {
        Task18 task = new Task18();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1337; i++) {
            list.add(i);
        }
        assertEquals(list ,task.getSublistOfMaximumIncreasingSequence(list));
    }

    @Test
    void sublistWithLengthOneTest() {
        Task18 task = new Task18();
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(7, 6, 5, 4, 3, 2, 1, 0));
        assertEquals(new ArrayList<>(Arrays.asList(7)) ,task.getSublistOfMaximumIncreasingSequence(list));
    }

    @Test
    void sublistTest() {
        Task18 task = new Task18();
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(0, 0, 1, 2, 2, 3, 5, 6, 7, 8));
        assertEquals(new ArrayList<>(Arrays.asList(2, 3, 5, 6, 7, 8)) ,task.getSublistOfMaximumIncreasingSequence(list));
    }

    @Test
    void sublistBetweenTest() {
        Task18 task = new Task18();
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(0, 0, 1, 2, 2, 3, 5, 6, 7, 8, 8, 8, 3, 2));
        assertEquals(new ArrayList<>(Arrays.asList(2, 3, 5, 6, 7, 8)) ,task.getSublistOfMaximumIncreasingSequence(list));
    }

}