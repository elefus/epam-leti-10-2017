package com.epam.jf.ilyinykh.homework;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Task18DoneTest {

    @org.junit.jupiter.api.Test
    void getSublistOfMaximumIncreasingSequence() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(4);
        list.add(5);
        list.add(6);
        List<Integer> answer = new Task18Done().getSublistOfMaximumIncreasingSequence(list);
        assertEquals(new Integer(2), answer.get(0));
        assertEquals(new Integer(4), answer.get(1));
        assertEquals(new Integer(5), answer.get(2));
        assertEquals(new Integer(6), answer.get(3));
    }
}