package com.epam.jf.kruglik.homework;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Task18Test {

    @Test
    void getSublistOfMaximumInNotIncreasingSequence() {
        Task18 task = new Task18();
        List<Integer> list = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list2 = task.getSublistOfMaximumIncreasingSequence(list);
        Integer[] res = {1};
        assertArrayEquals(list2.toArray(),res);
    }

    @Test
    void getSublistOfMaximumInIncreasingSequence() {
        Task18 task = new Task18();
        List<Integer> list = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list2 = task.getSublistOfMaximumIncreasingSequence(list);
        Integer[] res = {1,2,3,4,5};
        assertArrayEquals(list2.toArray(),res);
    }

    @Test
    void getSublistOfMaximumInIncreasingSequenceInStart() {
        Task18 task = new Task18();
        List<Integer> list = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(1);
        list2 = task.getSublistOfMaximumIncreasingSequence(list);
        Integer[] res = {1,2,3};
        assertArrayEquals(list2.toArray(),res);
    }
    @Test
    void getSublistOfMaximumInIncreasingSequenceInFinish() {
        Task18 task = new Task18();
        List<Integer> list = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(2);
        list.add(3);
        list2 = task.getSublistOfMaximumIncreasingSequence(list);
        Integer[] res = {1,2,3};
        assertArrayEquals(list2.toArray(),res);
    }
}