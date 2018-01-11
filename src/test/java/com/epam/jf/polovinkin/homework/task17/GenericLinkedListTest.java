package com.epam.jf.polovinkin.homework.task17;

import com.epam.jf.polovinkin.homework.task16.GenericList;
import org.junit.jupiter.api.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.jupiter.api.Assertions.*;

class GenericLinkedListTest {
    @Test
    void add() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.add(5);
        list.add(4);
        list.add(3);
        assertEquals(list.get(2), new Integer(3));
    }

    @Test
    void add1() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.add(3);
        list.add(1);
        list.add(4);
        list.add(1, 5);
        assertEquals(new Integer(5), list.get(1));
    }

    @Test
    void remove() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.add(2);
        list.add(0);
        list.add(-1);
        list.remove(1);
        assertEquals(new Integer(-1), list.get(1));
    }

    @Test
    void clear() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.add(2);
        list.add(0);
        list.add(-1);
        list.remove(1);
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    void subList() throws OperationNotSupportedException {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.add(2);
        list.add(0);
        list.add(-1);
        GenericList<Integer> subList = list.subList(0, 1);
        assertEquals(new Integer(2), subList.get(0));
        assertEquals(new Integer(0), subList.get(1));
    }
}