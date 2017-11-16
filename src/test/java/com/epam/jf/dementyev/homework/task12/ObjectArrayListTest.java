package com.epam.jf.dementyev.homework.task12;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ObjectArrayListTest {

    @Test
    void add() {
        ObjectArrayList list = new ObjectArrayList(2);
        Object obj = new Object();

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
        list.add(obj);
        assertEquals(obj, list.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
    }

    @Test
    void add1() {
        ObjectArrayList list = new ObjectArrayList(4);
        Object obj1 = new Object();
        Object obj2 = new Object();

        list.add(obj1);
        list.add(obj1);
        list.add(obj2, 1);
        assertEquals(obj1, list.get(0));
        assertEquals(obj2, list.get(1));
        assertEquals(obj1, list.get(2));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(3));
    }

    @Test
    void contains() {
        ObjectArrayList list = new ObjectArrayList();
        Object obj = new Object();
        assertFalse(list.contains(obj));
        list.add(obj);
        assertTrue(list.contains(obj));
    }

    @Test
    void containsAll() {
        ObjectArrayList list1 = new ObjectArrayList();
        ObjectArrayList list2 = new ObjectArrayList();
        list2.add(new Object());
        list2.add(new Object());
        assertFalse(list1.containsAll(list2));
        list1.add(list2.get(1));
        assertFalse(list1.containsAll(list2));
        list1.add(list2.get(0));
        assertTrue(list1.containsAll(list2));
    }

    @Test
    void remove() {
        ObjectArrayList list = new ObjectArrayList();
        Object obj = new Object();
        list.add(obj);
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(1));
        assertEquals(obj, list.remove(0));
        assertEquals(0, list.size());
    }

    @Test
    void remove1() {
        ObjectArrayList list = new ObjectArrayList();
        Object obj1 = new Object();
        Object obj2 = new Object();
        list.add(obj1);
        list.add(obj2);
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(2));
        assertEquals(obj1, list.remove(obj1));
        assertEquals(obj2, list.get(0));
        assertEquals(1, list.size());
    }

    @Test
    void removeAll() {
        ObjectArrayList list1 = new ObjectArrayList();
        ObjectArrayList list2 = new ObjectArrayList();
        list2.add(new Object());
        list2.add(new Object());

        list1.add(list2.get(0));
        list1.add(list2.get(1));
        list1.add(new Object());

        list1.removeAll(list2);
        assertEquals(1, list1.size());
    }

    @Test
    void set() {
        ObjectArrayList list = new ObjectArrayList();
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(null, 0));
        list.add(new Object());
        list.set(null, 0);
        assertNull(list.get(0));
    }

    @Test
    void addAll() {
        ObjectArrayList list1 = new ObjectArrayList();
        ObjectArrayList list2 = new ObjectArrayList();
        list2.add(new Object());
        list2.add(new Object());

        list1.add(new Object());
        list1.addAll(list2);

        assertTrue(list1.containsAll(list2));
    }

    @Test
    void clear() {
        ObjectArrayList list = new ObjectArrayList();
        list.add(null);
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    void size() {
        ObjectArrayList list = new ObjectArrayList();
        assertEquals(0, list.size());
        list.add(null);
        list.add(null);
        list.add(null);
        assertEquals(3, list.size());
    }

    @Test
    void isEmpty() {
        ObjectArrayList list = new ObjectArrayList();
        assertTrue(list.isEmpty());
        list.add(null);
        assertFalse(list.isEmpty());
    }

    @Test
    void indexOf() {
        ObjectArrayList list = new ObjectArrayList();
        Object obj = new Object();
        list.add(null);
        list.add(obj);
        assertEquals(1, list.indexOf(obj));
        assertEquals(0, list.indexOf(null));

        list.remove(0);
        assertEquals(-1, list.indexOf(null));
    }

    @Test
    void lastIndexOf() {
        ObjectArrayList list = new ObjectArrayList();
        list.add(null);
        list.add(null);
        assertEquals(1, list.lastIndexOf(null));
    }

    @Test
    void subList() {
        ObjectArrayList list = new ObjectArrayList();
        Object obj1 = new Object();
        Object obj2 = new Object();
        list.add(null);
        list.add(obj1);
        list.add(null);
        list.add(obj2);
        list.add(null);

        ObjectArrayList newList = (ObjectArrayList) list.subList(1, 4);
        assertEquals(3, newList.size());
        assertEquals(obj1, newList.get(0));
        assertNull(newList.get(1));
        assertEquals(obj2, newList.get(2));
    }

    @Test
    void trimToSize() {
        ObjectArrayList list = new ObjectArrayList(5);
        assertEquals(5, list.values.length);
        list.add(null);
        list.trimToSize();
        assertEquals(1, list.values.length);
        list.remove(0);
        list.trimToSize();
        assertEquals(0, list.values.length);
    }

}