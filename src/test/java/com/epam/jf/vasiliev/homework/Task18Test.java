package com.epam.jf.vasiliev.homework;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Task18Test {
    Task18 ref = new Task18();

    @Test
    void testOnOneSubseqAtTheEnd() {
        List<Integer> src = Arrays.asList(0, -1, -2, 1, 1, 2, 3, 4, 5);
        List<Integer> res = ref.getSublistOfMaximumIncreasingSequence(src);
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, res.toArray());
    }

    @Test
    void testOnOneSubseqAtStart() {
        List<Integer> src = Arrays.asList(-2, -1, 0, -1, 1, 0, 0, 4, 0);
        List<Integer> res = ref.getSublistOfMaximumIncreasingSequence(src);
        assertArrayEquals(new Integer[]{-2, -1, 0}, res.toArray());
    }

    @Test
    void testOnCoupleSubseqTargetIsTheLastOne() {
        List<Integer> src = Arrays.asList(-3, -2, -1, 0, -1, -2, 1, 1, 2, 3, 4, 5);
        List<Integer> res = ref.getSublistOfMaximumIncreasingSequence(src);
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, res.toArray());
    }

    @Test
    void testOnCoupleSubseqTargetIsTheFirstOne() {
        List<Double> src = Arrays.asList(1.2, 1.3, 5.1, 66.0, 71.9,  4.0, 3.3, 6.4, 8.233, 0.32);
        List<Double> res = ref.getSublistOfMaximumIncreasingSequence(src);
        assertArrayEquals(new Double[]{1.2, 1.3, 5.1, 66.0, 71.9}, res.toArray());
    }

    @Test
    void testOnAllListIsIncreasingSubseq() {
        List<Double> src = Arrays.asList(1.2, 1.3, 5.1, 66.0, 71.9,  444.0, 534.3, 6543.4, 8344.233, 10000.32);
        List<Double> res = ref.getSublistOfMaximumIncreasingSequence(src);
        assertArrayEquals(new Double[]{1.2, 1.3, 5.1, 66.0, 71.9,  444.0, 534.3, 6543.4, 8344.233, 10000.32}, res.toArray());
    }

    @Test
    void testOnAllListIsNotIncreasingSubseq() {
        List<Integer> src = Arrays.asList(9, 8, 7, 6, 5, 4, 4, 4, 1, 0, 0, 0);
        List<Integer> res = ref.getSublistOfMaximumIncreasingSequence(src);
        assertArrayEquals(new Integer[]{9}, res.toArray());
    }

}