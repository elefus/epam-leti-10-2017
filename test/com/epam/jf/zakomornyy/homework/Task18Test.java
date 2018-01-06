package com.epam.jf.zakomornyy.homework;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task18Test {
    @Test
    void getSublistOfMaximumIncreasingSequence() {
        Object[] arr = new Task18().getSublistOfMaximumIncreasingSequence(new ArrayList<>(Arrays.asList(3, -2, 13, 23, 4))).toArray();
        Integer[] requiredArr = new Integer[]{-2, 13, 23};
        assertEquals(arr.length, requiredArr.length);
        for (int i = 0; i < arr.length; i++) {
            assertEquals(arr[i], requiredArr[i]);
        }
    }

    @Test
    void getSublistOfMaximumIncreasingSequence2() {
        Object[] arr = new Task18().getSublistOfMaximumIncreasingSequence(new ArrayList<>(Arrays.asList(3, -2, 13, 23, 4, 5, 6, 7, 8))).toArray();
        Integer[] requiredArr = new Integer[]{4, 5, 6, 7, 8};
        assertEquals(arr.length, requiredArr.length);
        for (int i = 0; i < arr.length; i++) {
            assertEquals(arr[i], requiredArr[i]);
        }
    }

    @Test
    void getSublistOfMaximumIncreasingSequence3() {
        Object[] arr = new Task18().getSublistOfMaximumIncreasingSequence(new ArrayList<>(Arrays.asList(3))).toArray();
        assertEquals(arr.length, 0);
    }

    @Test
    void getSublistOfMaximumIncreasingSequence4() {
        Object[] arr = new Task18().getSublistOfMaximumIncreasingSequence(new ArrayList<>(Arrays.asList(3, -2, 13, 13, 13, 13, 23, 4, 5, 6, 7, 8))).toArray();
        Integer[] requiredArr = new Integer[]{4, 5, 6, 7, 8};
        assertEquals(arr.length, requiredArr.length);
        for (int i = 0; i < arr.length; i++) {
            assertEquals(arr[i], requiredArr[i]);
        }
    }
}