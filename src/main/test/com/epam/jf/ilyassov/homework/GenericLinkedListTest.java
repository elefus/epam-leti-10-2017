package com.epam.jf.ilyassov.homework;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class GenericLinkedListTest {
    @Test
    void addTest() {
        GenericLinkedList<Number> list = new GenericLinkedList<>();
        assertTrue(list.add(4));
    }

    @Test
    void addIndexTest() {
        GenericLinkedList<Number> list = new GenericLinkedList<>();
        assertTrue(list.add(0,0));

    }

    @Test
    void getTest() {
        GenericLinkedList<Number> list = new GenericLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        assertEquals(9,list.get(9));

    }

    @Test
    void setTest() {
        GenericLinkedList<Number> list = new GenericLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.set(9,111);
        assertEquals(111,list.get(9));

    }

    @Test
    void removeTest() {
        GenericLinkedList<Number> list = new GenericLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.remove(5);
        assertEquals(9,list.size());
    }
    @Test
    void clearTest() {
        GenericLinkedList<Number> list = new GenericLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.clear();
        assertEquals(0,list.size());
    }
    @Test
    void sublistTest() {
        GenericLinkedList<Number> list = new GenericLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        GenericLinkedList<Number> list2=(GenericLinkedList)list.sublist(2,5);
        assertEquals(list2.get(0),2);
        assertEquals(list2.get(1),3);
        assertEquals(list2.get(2),4);
        assertEquals(list2.get(3),5);
        assertEquals(4,list2.size());
    }
}