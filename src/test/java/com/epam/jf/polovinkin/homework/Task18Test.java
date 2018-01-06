package com.epam.jf.polovinkin.homework;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Task18Test {

    @Test
    void getSublistOfMaximumIncreasingSequenceTest1() {
        assertEquals(5, new Task18().getSublistOfMaximumIncreasingSequence(new ArrayList<>(Arrays.asList(3, 2, 1, 1, 1, 2, 3, 4, 5, 1, 2))).size());
    }

    @Test
    void getSublistOfMaximumIncreasingSequenceTest2() {
        List<Integer> seq = new Task18().getSublistOfMaximumIncreasingSequence(new ArrayList<>(Arrays.asList(3, 2, 1, 1, 1, 1, 0)));
        assertEquals(0, seq.size());
    }

    @Test
    void getSublistOfMaximumIncreasingSequenceTest3() {
        assertEquals(3, new Task18().getSublistOfMaximumIncreasingSequence(new ArrayList<>(Arrays.asList(1,2,3,3,3,4))).size());
    }
}