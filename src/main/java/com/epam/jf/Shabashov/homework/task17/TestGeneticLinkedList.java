package com.epam.jf.Shabashov.homework.task17;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGeneticLinkedList {
    @Test
    public void addGetTest(){
        GenericLinkedList<Integer> list = new GenericLinkedList<Integer>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        for (int i = 0; i < 100; i++) {
            assertEquals((int)list.get(i),i);
        }
    }

    @Test
    public void removeTest(){
        GenericLinkedList<Integer> list = new GenericLinkedList<Integer>();
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
        GenericLinkedList<Integer> list = new GenericLinkedList<Integer>();
        GenericLinkedList<Integer> list2 = new GenericLinkedList<Integer>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
            list2.add(i);
        }
        assertTrue(list.containsAll(list2));
    }

    @Test
    public void sublistTest(){
        GenericLinkedList<Integer> list = new GenericLinkedList<Integer>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        GenericLinkedList subList = (GenericLinkedList) list.subList(10, 50);
        for (int i = 10; i <= 50; i++) {
            assertEquals(subList.get(i-10),i);
        }

    }
}
