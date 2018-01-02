package com.epam.jf.Shabashov.homework;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Task18Tests {
    private Task18 tt = new Task18();

    @Test
    void test1() {
        List<Integer> list = Arrays.asList(100, 0, -1, 2, 3, 45, 5);
        list = tt.getSublistOfMaximumIncreasingSequence(list);
        assertArrayEquals(list.toArray(), new Integer[]{-1, 2, 3, 45});
    }

    @Test
    void test2() {
        List<Integer> list = Arrays.asList(100, 0, -1, 2, 3, 45, 5000);
        list = tt.getSublistOfMaximumIncreasingSequence(list);
        assertArrayEquals(list.toArray(), new Integer[]{-1, 2, 3, 45, 5000});
    }

    @Test
    void test4() {
        List<Integer> list = Arrays.asList(-1000, -500, -1, 2, 3, 45, 5000);
        list = tt.getSublistOfMaximumIncreasingSequence(list);
        assertArrayEquals(list.toArray(), new Integer[]{-1000, -500, -1, 2, 3, 45, 5000});
    }

    @Test
    void test3() {
        List<Integer> list = Arrays.asList(-1000, -1, 2, 3, 45, 5);
        list = tt.getSublistOfMaximumIncreasingSequence(list);
        assertArrayEquals(list.toArray(), new Integer[]{-1000, -1, 2, 3, 45});
    }

}