package com.epam.jf.Shabashov.homework.task17;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGeneticArrayList {
    @Test
    public void addGetTest(){
        GenericArrayList<Integer> list = new GenericArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        for (int i = 0; i < 100; i++) {
            assertEquals((int)list.get(i),i);
        }
    }

    @Test
    public void removeTest(){
        GenericArrayList<Integer> list = new GenericArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        list.remove(0);
        list.remove(98);
        list.remove(50);
        for (int i = 0; i < 50; i++) {
            assertEquals((int)list.get(i),i+1);
        }
        for (int i = 50; i < 97; i++) {
            assertEquals((int)list.get(i),i+2);
        }
    }

    @Test
    public void contatinsTest(){
        GenericArrayList<Integer> list = new GenericArrayList<Integer>();
        GenericArrayList<Integer> list2 = new GenericArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
            list2.add(i);
        }
        assertTrue(list.containsAll(list2));
    }

    @Test
    public void sublistTest(){
        GenericArrayList<Integer> list = new GenericArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        GenericArrayList subList = (GenericArrayList) list.subList(10, 50);
        for (int i = 10; i <= 50; i++) {
            assertEquals(subList.get(i-10),i);
        }

    }
}
