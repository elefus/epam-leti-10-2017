package com.epam.jf.dementyev.homework;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class Task18Test {

    @Test
    void test1() {
        List<Integer> l = Arrays.asList(1, 2, 3, 4, 5);
        assertArrayEquals(l.toArray(), new Task18().getSublistOfMaximumIncreasingSequence(l).toArray());
    }

    @Test
    void test2() {
        List<Integer> l = Arrays.asList(5, 4, 3, 2, 1);
        assertArrayEquals(new Integer[]{5}, new Task18().getSublistOfMaximumIncreasingSequence(l).toArray());
    }

    @Test
    void test3() {
        List<Integer> l = Arrays.asList(7, 5, 6, 1, 2, 3);
        assertArrayEquals(new Integer[]{1, 2, 3}, new Task18().getSublistOfMaximumIncreasingSequence(l).toArray());
    }

    @Test
    void test4() {
        List<Integer> l = Arrays.asList(7, 8, 9, 5, 6, 1);
        assertArrayEquals(new Integer[]{7, 8, 9}, new Task18().getSublistOfMaximumIncreasingSequence(l).toArray());
    }

}