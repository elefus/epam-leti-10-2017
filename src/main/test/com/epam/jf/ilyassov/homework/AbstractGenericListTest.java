package com.epam.jf.ilyassov.homework;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AbstractGenericListTest {
    @Test
    void isEmptyTest() {
        GenericLinkedList<Number> list = new GenericLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        assertFalse(list.isEmpty());
    }

    @Test
    void sizeTest() {
        GenericLinkedList<Number> list = new GenericLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        assertEquals(10,10);
    }

    @Test
    void containsTest() {
        GenericLinkedList<Number> list = new GenericLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        assertTrue(list.contains(4));
        assertFalse(list.contains(11));
    }


    @Test
    void containsAllTest() {
        GenericLinkedList<Number> list = new GenericLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        GenericLinkedList<Number> list2 = new GenericLinkedList<>(list);
        assertTrue(list.containsAll(list2));
    }

    @Test
    void removeTest() {
        GenericLinkedList<Number> list = new GenericLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.remove(0);
        assertEquals(1,list.get(0));
    }

    @Test
    void removeAllTest() {
        GenericLinkedList<Number> list = new GenericLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        GenericLinkedList<Number> list2 = new GenericLinkedList<>(list);
        list.add(3,5);
        list.add(4);
        list.removeAll(3);
        assertEquals(6,list.get(5));
    }

    @Test
    void removeAllListTest() {
        GenericLinkedList<Number> list = new GenericLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        GenericLinkedList<Number> list2 = new GenericLinkedList<>(list);
        list.removeAll(list2);
        assertTrue(list.isEmpty());
    }

    @Test
    void indexOfTest() {
        GenericLinkedList<Number> list = new GenericLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        assertEquals(9,list.indexOf(9));
        assertEquals(-1,list.indexOf(10));
    }

    @Test
    void lasIndexOfTest() {
        GenericLinkedList<Number> list = new GenericLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.add(3);
        assertEquals(list.lastIndexOf(3),10);
    }


}