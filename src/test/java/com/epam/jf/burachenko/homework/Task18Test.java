package com.epam.jf.burachenko.homework;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Task18Test {
    @Test
    void getSublistOfMaximumIncreasingSequenceTest1() {
        Task18 obj = new Task18();
        Integer[] seq1 = {7, 2, 1, 3, 8, 4, 9, 1, 2, 6, 5, 9, 3, 8, 1};
        List<Integer> seq = Arrays.asList(seq1);
        Integer[] ans1 = {1, 3, 8};
        List<Integer> ans = Arrays.asList(ans1);
        assertTrue(obj.getSublistOfMaximumIncreasingSequence(seq).equals(ans));
    }

    @Test
    void getSublistOfMaximumIncreasingSequenceTest2() {
        Task18 obj = new Task18();
        Integer[] seq1 = {1, 2, 3, 4, 3, 3, 4, 5};
        List<Integer> seq = Arrays.asList(seq1);
        Integer[] ans1 = {1, 2, 3, 4};
        List<Integer> ans = Arrays.asList(ans1);
        assertEquals(ans, obj.getSublistOfMaximumIncreasingSequence(seq));
    }

    @Test
    void getSublistOfMaximumIncreasingSequenceTest3() {
        Task18 obj = new Task18();
        String[] seq1 = {"A", "B", "C", "ab", "aa", "ab", "ac", "ad", "bc", "cd"};
        List<String> seq = Arrays.asList(seq1);
        String[] ans1 = {"aa", "ab", "ac", "ad", "bc", "cd"};
        List<String> ans = Arrays.asList(ans1);
        assertEquals(ans, obj.getSublistOfMaximumIncreasingSequence(seq));
    }

    @Test
    void getSublistOfMaximumIncreasingSequenceTest4() {
        Task18 obj = new Task18();
        Integer[] seq1 = {};
        List<Integer> seq = Arrays.asList(seq1);
        assertNull(obj.getSublistOfMaximumIncreasingSequence(seq));
    }

    @Test
    void getSublistOfMaximumIncreasingSequenceTest5() {
        Task18 obj = new Task18();
        String[] seq1 = {"C", "B"};
        List<String> seq = Arrays.asList(seq1);
        String[] ans1 = {"C"};
        List<String> ans = Arrays.asList(ans1);
        assertEquals(ans, obj.getSublistOfMaximumIncreasingSequence(seq));
    }

    @Test
    void test1() {
        List<Integer> list = Arrays.asList(100, 0, -1, 2, 3, 45, 5);
        list = new Task18().getSublistOfMaximumIncreasingSequence(list);
        assertArrayEquals(list.toArray(), new Integer[]{-1, 2, 3, 45});
    }

    @Test
    void test2() {
        List<Integer> list = Arrays.asList(100, 0, -1, 2, 3, 45, 5000);
        list = new Task18().getSublistOfMaximumIncreasingSequence(list);
        assertArrayEquals(list.toArray(), new Integer[]{-1, 2, 3, 45, 5000});
    }

    @Test
    void test4() {
        List<Integer> list = Arrays.asList(-1000, -500, -1, 2, 3, 45, 5000);
        list = new Task18().getSublistOfMaximumIncreasingSequence(list);
        assertArrayEquals(list.toArray(), new Integer[]{-1000, -500, -1, 2, 3, 45, 5000});
    }

    @Test
    void test3() {
        List<Integer> list = Arrays.asList(-1000, -1, 2, 3, 45, 5);
        list = new Task18().getSublistOfMaximumIncreasingSequence(list);
        assertArrayEquals(list.toArray(), new Integer[]{-1000, -1, 2, 3, 45});
    }

    @Test
    void getSublistOfMaximumInNotIncreasingSequence() {
        Task18 task = new Task18();
        List<Integer> list = new LinkedList<>();
        List<Integer> list2;
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
        List<Integer> list2;
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
        List<Integer> list2;
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
        List<Integer> list2;
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
