package com.epam.jf.bavtovich.homework.task17;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GenericLinkedListTest {

    @Test
    void add() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        assertTrue(list.add(1));
        assertTrue(list.add(5));
        assertTrue(list.add(10));
        assertEquals(list.size, 3);
    }

    @Test
    void contains() {
        GenericLinkedList<Integer> list2 = new GenericLinkedList<>();
        list2.add(1);
        list2.add(5);
        list2.add(10);
        assertFalse(list2.contains(89));
        assertTrue(list2.contains(5));
    }

    @Test
    void remove() {
        GenericLinkedList<Integer> list2 = new GenericLinkedList<>();
        list2.add(1);
        list2.add(5);
        list2.add(10);
        list2.add(22);
        list2.remove(1);
        assertFalse(list2.contains(5));
        list2.remove((Integer) 22);
        assertFalse(list2.contains(22));
    }

    @Test
    void addAll() {
        GenericLinkedList<Integer> list2 = new GenericLinkedList<>();
        list2.add(1);
        list2.add(5);
        list2.add(10);
        GenericLinkedList<Integer> list3 = new GenericLinkedList<>();
        list3.add(8);
        list3.add(20);
        list3.add(17);
        list2.addAll(list3);
        assertEquals(6, list2.size);
    }

    @Test
    void get() {
        GenericLinkedList<Integer> list2 = new GenericLinkedList<>();
        list2.add(1);
        list2.add(5);
        list2.add(10);
        assertEquals((Integer) 10, list2.get(2));
    }

    @Test
    void set() {
        GenericLinkedList<Integer> list2 = new GenericLinkedList<>();
        list2.add(1);
        list2.add(5);
        list2.add(10);
        list2.set(1, -5);
        assertEquals(-5, (int) list2.get(1));
    }

    @Test
    void addFirst() {
        GenericLinkedList<Integer> list2 = new GenericLinkedList<>();
        list2.add(1);
        list2.add(5);
        list2.add(10);
        list2.addFirst(-1);
        assertEquals(-1, (int) list2.getFirst());
        assertEquals(1, (int) list2.get(1));
    }

    @Test
    void addLast() {
        GenericLinkedList<Integer> list2 = new GenericLinkedList<>();
        list2.add(1);
        list2.add(5);
        list2.add(10);
        list2.addLast(-1);
        assertEquals(-1, (int) list2.getLast());
        assertEquals(10, (int) list2.get(2));
    }

    @Test
    void removeFirst() {
        GenericLinkedList<Integer> list2 = new GenericLinkedList<>();
        list2.add(1);
        list2.add(5);
        list2.add(10);
        list2.removeFirst();
        assertEquals(5, (int) list2.getFirst());
    }

    @Test
    void removeLast() {
        GenericLinkedList<Integer> list2 = new GenericLinkedList<>();
        list2.add(1);
        list2.add(5);
        list2.add(10);
        list2.removeLast();
        assertEquals(5, (int) list2.getLast());
    }

}