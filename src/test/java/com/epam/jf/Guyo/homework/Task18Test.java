package com.epam.jf.Guyo.homework;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Task18Test {
    @Test
    void getSublistOfMaximumIncreasingSequenceTest1() {
        Task18 obj = new Task18();
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> subList = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertTrue(obj.getSublistOfMaximumIncreasingSequence(list).equals(subList));
    }

    @Test
    void getSublistOfMaximumIncreasingSequenceTest2() {
        Task18 obj = new Task18();
        List<Integer> list = Arrays.asList(1, 2, 3, 0, 0, 0, 5, 6, 7, 8, 0, 0, 0, 0, 8, 7, 6, 5);
        List<Integer> subList = Arrays.asList(0, 5, 6, 7, 8);
        assertTrue(obj.getSublistOfMaximumIncreasingSequence(list).equals(subList));
    }

    @Test
    void getSublistOfMaximumIncreasingSequenceTest3() {
        Task18 obj = new Task18();
        List<Integer> list = Arrays.asList(1, 0);
        List<Integer> subList = Arrays.asList(1);
        assertTrue(obj.getSublistOfMaximumIncreasingSequence(list).equals(subList));
    }
}