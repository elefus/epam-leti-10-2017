package com.epam.jf.zakomornyy.homework;


import com.epam.jf.zakomornyy.homework.task12.ObjectArrayList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObjectArrayListTest {
    @Test
    void add() {
        ObjectArrayList list = new ObjectArrayList(0);
        Object o = new Object();
        list.add(o);
        assertEquals(o, list.get(0));
    }

    @Test
    void add1() {
        ObjectArrayList list = new ObjectArrayList(3);
        Object o = new Object();
        list.add(o, 2);
        assertEquals(o, list.get(2));
    }

    @Test
    void get() {
        ObjectArrayList list = new ObjectArrayList(0);
        Object o1 = new Object();
        list.add(o1);
        Object o2 = list.get(0);
        assertEquals(o1, o2);
    }

    @Test
    void contains() {
        ObjectArrayList list = new ObjectArrayList(2);
        Object o = new Object();
        list.add(o,2);
        assertTrue(list.contains(o));
    }

    @Test
    void containsAll() {
        ObjectArrayList list1 = new ObjectArrayList(0);
        ObjectArrayList list2 = new ObjectArrayList(0);
        Object o1 = new Object();
        Object o2 = new Object();
        Object o3 = new Object();
        Object o4 = new Object();
        list1.add(o1);
        list1.add(o4);
        list1.add(o2);
        list1.add(o3);
        list2.add(o4);
        list2.add(o3);
        assertTrue(list1.containsAll(list2));
    }

    @Test
    void remove() {
        ObjectArrayList list = new ObjectArrayList(0);
        Object o1 = new Object();
        list.add(o1);
        Object o2 = list.remove(0);
        assertEquals(o1, o2);
        assertEquals(list.size(), 0);
    }

    @Test
    void remove1() {
        ObjectArrayList list = new ObjectArrayList(0);
        Object o1 = new Object();
        list.add(o1);
        Object o2 = list.remove(o1);
        assertEquals(o1, o2);
        assertEquals(list.size(), 0);
    }

    @Test
    void removeAll() {
        ObjectArrayList list1 = new ObjectArrayList(0);
        ObjectArrayList list2 = new ObjectArrayList(0);
        Object o1 = new Object();
        Object o2 = new Object();
        Object o3 = new Object();
        Object o4 = new Object();
        list1.add(o1);
        list1.add(o4);
        list1.add(o2);
        list1.add(o3);
        list2.add(o4);
        list2.add(o3);
        list1.removeAll(list2);
        for(int i = 0; i < list2.size(); i++) {
            assertFalse(list1.contains(list2.get(i)));
        }
    }

    @Test
    void set() {
        ObjectArrayList list = new ObjectArrayList(0);
        Object o1 = new Object();
        Object o2 = new Object();
        list.add(o1);
        list.set(o2, 0);
        assertEquals(list.get(0), o2);
    }

    @Test
    void addAll() {
        ObjectArrayList list1 = new ObjectArrayList(0);
        ObjectArrayList list2 = new ObjectArrayList(0);
        Object o1 = new Object();
        Object o2 = new Object();
        Object o3 = new Object();
        Object o4 = new Object();
        list1.add(o1);
        list1.add(o4);
        list1.add(o2);
        list1.add(o3);
        list2.addAll(list1);
        assertTrue(list1.containsAll(list2));
    }

    @Test
    void clear() {
        ObjectArrayList list1 = new ObjectArrayList(0);
        Object o1 = new Object();
        Object o2 = new Object();
        Object o3 = new Object();
        Object o4 = new Object();
        list1.add(o1);
        list1.add(o4);
        list1.add(o2);
        list1.add(o3);
        list1.clear();
        assertTrue(list1.size() == 0);
    }

    @Test
    void size() {
        ObjectArrayList list1 = new ObjectArrayList(0);
        Object o1 = new Object();
        Object o2 = new Object();
        Object o3 = new Object();
        Object o4 = new Object();
        list1.add(o1);
        list1.add(o4);
        list1.add(o2);
        list1.add(o3);
        assertTrue(list1.size() == 4);
    }

    @Test
    void isEmpty() {
        ObjectArrayList list1 = new ObjectArrayList(0);
        Object o1 = new Object();
        Object o2 = new Object();
        Object o3 = new Object();
        Object o4 = new Object();
        list1.add(o1);
        list1.add(o4);
        list1.add(o2);
        list1.add(o3);
        list1.clear();
        assertTrue(list1.isEmpty());
    }

    @Test
    void indexOf() {
        ObjectArrayList list1 = new ObjectArrayList(0);
        Object o1 = new Object();
        Object o2 = new Object();
        Object o3 = new Object();
        Object o4 = new Object();
        list1.add(o1);
        list1.add(o4);
        list1.add(o2);
        list1.add(o3);
        assertTrue(list1.indexOf(o2) == 2);
    }

    @Test
    void lastIndexOf() {
        ObjectArrayList list1 = new ObjectArrayList(0);
        Object o1 = new Object();
        Object o2 = new Object();
        Object o3 = new Object();
        Object o4 = new Object();
        list1.add(o1);
        list1.add(o4);
        list1.add(o2);
        list1.add(o4);
        list1.add(o3);
        assertTrue(list1.lastIndexOf(o4) == 3);
    }

    @Test
    void subList() {
        ObjectArrayList list1 = new ObjectArrayList(0);
        ObjectArrayList list2 = new ObjectArrayList(0);
        Object o1 = new Object();
        Object o2 = new Object();
        Object o3 = new Object();
        Object o4 = new Object();
        list1.add(o1);
        list1.add(o4);
        list1.add(o2);
        list1.add(o3);
        list2.add(o1);
        list2.add(o4);
        assertTrue(list1.subList(0, 1).containsAll(list2));
    }

    @Test
    void trimToSize() {
        ObjectArrayList list = new ObjectArrayList();
        assertEquals(list.size(), 10);
        list.add(new Object());
        list.trimToSize();
        assertEquals(list.size(), 1);
    }

}