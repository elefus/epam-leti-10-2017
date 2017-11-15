package com.epam.jf.ilyinykh.homework.task12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObjectArrayListTest {
    private ObjectArrayList list;

    @Test
    void add() {
        list = new ObjectArrayList();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    void add1() {
        list = new ObjectArrayList();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4, 1);
        assertEquals(list.get(1), 4);
    }

    @Test
    void get() {
        list.add(0);
        list.add(1);
        list.add(7, 0);
        assertEquals(list.get(0), 7);
    }

    @Test
    void contains() {
        list = new ObjectArrayList();
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        assertTrue(list.contains(15));
        assertFalse(list.contains(100));
    }

    @Test
    void containsAll() {
        AbstractObjectArrayList list1 = new ObjectArrayList();
        for (int i = 0; i < 20; i++) {
            list1.add(i);
        }
        AbstractObjectArrayList list2 = new ObjectArrayList();
        for (int i = 0; i < 5; i++) {
            list2.add(i);
        }
        assertFalse(list2.containsAll(list1));
        assertTrue(list1.containsAll(list2));
    }

    @Test
    void remove() {
        list = new ObjectArrayList();
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        assertEquals(1, list.remove(1));
        assertEquals(2, list.get(1));
    }

    @Test
    void remove1() {
        list = new ObjectArrayList();
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        assertEquals(3, list.remove(new Integer(3)));
    }

    @Test
    void removeAll() {
        AbstractObjectArrayList list1 = new ObjectArrayList();
        for (int i = 0; i < 20; i++) {
            list1.add(i);
        }
        AbstractObjectArrayList list2 = new ObjectArrayList();
        for (int i = 0; i < 5; i++) {
            list2.add(i);
        }
        list1.removeAll(list2);
        assertEquals(5, list1.get(0));
    }

    @Test
    void set() {
        list = new ObjectArrayList();
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        assertEquals(2, list.set(1, 2));
        assertEquals(1, list.get(2));
    }

    @Test
    void addAll() {
        AbstractObjectArrayList list1 = new ObjectArrayList();
        for (int i = 0; i < 20; i++) {
            list1.add(i);
        }
        AbstractObjectArrayList list2 = new ObjectArrayList();
        for (int i = 0; i < 5; i++) {
            list2.add(i);
        }
        list1.addAll(list2);
        assertEquals(25, list1.size());
    }

    @Test
    void clear() {
        list = new ObjectArrayList();
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    void size() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void indexOf() {
    }

    @Test
    void lastIndexOf() {
        list = new ObjectArrayList();
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        list.add(1);
        assertEquals(20, list.lastIndexOf(1));
    }

    @Test
    void subList() {
        list = new ObjectArrayList();
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        AbstractObjectArrayList sl = list.subList(0, 5);
        assertEquals(6, sl.size());
        assertEquals(0, sl.get(0));
        assertEquals(5, sl.get(5));
    }

    @Test
    void trimToSize() {
    }

}