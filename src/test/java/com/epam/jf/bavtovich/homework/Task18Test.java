package com.epam.jf.bavtovich.homework;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;
//import static org.hamcrest.MatcherAssert.assertThat;

class Task18Test {
    @Test
    void getSublistOfMaximumIncreasingSequence() {
        Task18 obj = new Task18();
        Integer[] seq1 = {7, 2, 1, 3, 8, 4, 9, 1, 2, 6, 5, 9, 3, 8, 1};
        List<Integer> seq = Arrays.asList(seq1);
        Integer[] ans1 = {1, 3, 8};
        List<Integer> ans = Arrays.asList(ans1);
        assertTrue(obj.getSublistOfMaximumIncreasingSequence(seq).equals(ans));
    }
}