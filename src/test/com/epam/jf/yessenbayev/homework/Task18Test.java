package com.epam.jf.yessenbayev.homework;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.*;

public class Task18Test {

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

}
