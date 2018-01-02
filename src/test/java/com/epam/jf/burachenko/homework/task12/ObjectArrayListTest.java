package com.epam.jf.burachenko.homework.task12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObjectArrayListTest {
    @Test
    void testConstructor() {
        ObjectArrayList list = new ObjectArrayList();
        Object obj = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();

        list.add(obj);
        list.add(obj2);

        ObjectArrayList list2 = new ObjectArrayList(list);
        list2.set(obj3,1);
        assertEquals(list.get(1), obj2);

    }

    @Test
    void add() {
        ObjectArrayList list = new ObjectArrayList();
        Object obj = new Object();
        Object anobj = new Object();

        list.add(obj);
        assertEquals(obj, list.get(0));
        list.add(anobj);
        assertEquals(anobj, list.get(1));
        assertNotEquals(obj, list.get(1));
        assertNotEquals(anobj, list.get(0));
    }

    @Test
    void add1() {
        ObjectArrayList list = new ObjectArrayList();
        Object obj = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
        list.add(obj);
        list.add(obj2,0);
        assertEquals(list.get(0),obj2);
        assertEquals(list.get(1),obj);
        list.add(obj3, 1);
        assertEquals(list.get(1),obj3);
        assertEquals(list.get(2),obj);
    }

    @Test
    void get() {
        ObjectArrayList list = new ObjectArrayList();
        Object obj = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();
        Object obj4 = new Object();
        Object obj5 = new Object();

        list.add(obj);
        list.add(obj2);
        list.add(obj3);
        list.add(obj3);
        list.add(obj5);
        list.add(obj4);
        assertEquals(list.get(3), obj3);
        assertEquals(list.get(4), obj5);
        assertEquals(list.get(1), obj2);
    }

    @Test
    void contains() {
        ObjectArrayList list = new ObjectArrayList();
        Object obj = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();

        list.add(obj);
        list.add(obj);
        list.add(obj2);
        list.add(obj);
        list.add(obj);

        assertTrue(list.contains(obj));
        assertTrue(list.contains(obj2));
        assertFalse(list.contains(obj3));
    }

    @Test
    void containsAll() {
        ObjectArrayList list = new ObjectArrayList();
        Object obj = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();

        ObjectArrayList list2 = new ObjectArrayList();
        ObjectArrayList list3 = new ObjectArrayList();

        list.add(obj);
        list.add(obj);
        list.add(obj2);
        list.add(obj);

        list2.add(obj);
        list2.add(obj2);
        list2.add(obj2);
        list2.add(obj2);
        list2.add(obj2);

        list3.add(obj3);
        list3.add(obj2);
        list3.add(obj);

        assertTrue(list3.containsAll(list));
        assertTrue(list3.containsAll(list2));
        assertTrue(list.containsAll(list2));
        assertFalse(list.containsAll(list3));
    }

    @Test
    void remove() {
        ObjectArrayList list = new ObjectArrayList();
        Object obj = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();

        list.add(obj);
        list.add(obj2);
        list.add(obj);
        list.add(obj3);

        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(4));
        assertEquals(list.remove(2), obj);
        assertEquals(list.get(2), obj3);
    }

    @Test
    void set() {
        ObjectArrayList list = new ObjectArrayList();
        Object obj = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();

        list.add(obj);
        list.add(obj2);
        list.add(obj);
        list.add(obj3);

        list.set(obj3,1);
        assertEquals(list.get(1),obj3);
        list.set(obj3, 2);
        assertEquals(list.get(2),obj3);
    }

    @Test
    void addAll() {
        ObjectArrayList list = new ObjectArrayList();
        ObjectArrayList list2 = new ObjectArrayList();
        Object obj = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();

        list.add(obj);
        list.add(obj2);

        list2.add(obj3);
        list2.addAll(list);
        assertEquals(list2.size(),3);
        assertTrue(list2.containsAll(list));
    }

    @Test
    void clear() {
        ObjectArrayList list = new ObjectArrayList();
        Object obj = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();

        list.add(obj);
        list.add(obj2);
        list.add(obj);
        list.add(obj3);

        list.clear();
        assertEquals(list.size(),0);
        assertThrows(IndexOutOfBoundsException.class,() -> list.get(0));
    }

    @Test
    void size() {
        ObjectArrayList list = new ObjectArrayList();
        Object obj = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();

        list.add(obj);
        list.add(obj2);
        list.add(obj);
        list.add(obj3);

        assertEquals(list.size(), 4);
        list.add(obj3);
        assertEquals(list.size(),5);
    }

    @Test
    void isEmpty() {
        ObjectArrayList list = new ObjectArrayList();
        Object obj = new Object();

        assertTrue(list.isEmpty());
        list.add(obj);
        assertFalse(list.isEmpty());
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    void indexOf() {
        ObjectArrayList list = new ObjectArrayList();
        Object obj = new Object();
        Object obj2 = new Object();
        list.add(obj);
        list.add(obj2);
        list.add(obj);
        list.add(obj2);
        list.add(obj);
        list.add(obj2);

        assertEquals(list.indexOf(obj),0);
        assertEquals(list.indexOf(obj2),1);
    }

    @Test
    void lastIndexOf() {
        ObjectArrayList list = new ObjectArrayList();
        Object obj = new Object();
        Object obj2 = new Object();
        list.add(obj);
        list.add(obj2);
        list.add(obj);
        list.add(obj2);
        list.add(obj);
        list.add(obj2);

        assertEquals(list.lastIndexOf(obj),4);
        assertEquals(list.lastIndexOf(obj2),5);
    }

    @Test
    void subList() {
        ObjectArrayList list = new ObjectArrayList();
        Object obj = new Object();
        Object obj2 = new Object();
        list.add(obj);
        list.add(obj);
        list.add(obj2);
        list.add(obj2);
        list.add(obj);

        ObjectArrayList list2 = (ObjectArrayList) list.subList(2,4);
        assertEquals(list2.size(), 3);
        assertEquals(list2.get(0), list.get(2));
        assertEquals(list2.get(2), list.get(4));
        assertEquals(list2.get(2), obj);
    }

    @Test
    void trimToSize() {
        ObjectArrayList list = new ObjectArrayList();
        Object obj = new Object();
        Object obj2 = new Object();
        assertEquals(10, list.values.length);
        list.add(obj);
        list.add(obj);
        list.add(obj2);
        list.add(obj2);
        list.add(obj);
        list.trimToSize();
        assertEquals(list.size(),list.values.length);
    }
}