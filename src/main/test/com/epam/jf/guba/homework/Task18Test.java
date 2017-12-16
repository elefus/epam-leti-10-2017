package com.epam.jf.guba.homework;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class Task18Test {

    private Task18 task18 = new Task18();

    @Test
    void testEmpty() {
        assertThrows(IllegalArgumentException.class,
            () -> task18.getSublistOfMaximumIncreasingSequence(new ArrayList<Integer>(Arrays.asList(new Integer[0]))));
    }

    @Test
    void testRegular() {
        List<Integer> expected = new ArrayList<>();
        expected.addAll(Arrays.asList(1, 2, 3, 4, 5));
        assertThat(task18.getSublistOfMaximumIncreasingSequence(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5))), is(expected));
    }

    @Test
    void testSimilar() {
        List<Integer> expected = new ArrayList<>();
        expected.addAll(Arrays.asList(1));
        assertThat(task18.getSublistOfMaximumIncreasingSequence(new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1))),
            is(expected));
    }

    @Test
    void testWithEquals() {
        List<Integer> expected = new ArrayList<>();
        expected.addAll(Arrays.asList(2, 3, 4, 5));
        assertThat(task18.getSublistOfMaximumIncreasingSequence(new ArrayList<Integer>(Arrays.asList(1, 2, 2, 3, 4, 5))), is(expected));
    }

}
