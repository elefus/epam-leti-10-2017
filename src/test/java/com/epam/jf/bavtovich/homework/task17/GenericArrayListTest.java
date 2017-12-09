package com.epam.jf.bavtovich.homework.task17;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

class GenericArrayListTest {

    GenericArrayList<String> list = new GenericArrayList<>();

    @Test
    void add() {
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        assertEquals(4, list.size());
    }

    @Test
    void addAll() {
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        GenericArrayList<String> list2 = new GenericArrayList<>();
        list2.add("q");
        list2.add("w");
        list2.add("e");
        list.addAll(list2);
        assertEquals(7, list.size());
    }

    @Test
    void contains() {
        GenericArrayList<String> list2 = new GenericArrayList<>();
        list2.add("q");
        list2.add("w");
        list2.add("e");
        assertTrue(list2.contains("q"));
        assertFalse(list2.contains("adawd"));
    }

    @Test
    void remove() {
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.remove(1);
        assertEquals("c", list.get(1));
        list.remove("c");
        assertEquals("d", list.get(1));
    }

    @Test
    void clear() {
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    void get() {
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        assertEquals("c",list.get(2));
    }

    @Test
    void set() {
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.set(2, "wada");
        assertFalse(list.contains("c"));
        assertEquals("wada", list.get(2));
    }

    @Test
    void subList() {
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("q");
        list.add("w");
        list.add("e");
        list.add("r");
        GenericArrayList<String> newList = (GenericArrayList<String>) list.subList(1, 5);
        assertEquals(4, newList.size());
        assertEquals("b", newList.get(0));
        assertEquals("q", newList.get(3));
    }
}