package com.epam.jf.bavtovich.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task12Test {

    @Test
    void testConstructor() {
        Task12 list = new Task12();
        Object obj = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();

        list.add(obj);
        list.add(obj2);

        Task12 list2 = new Task12(list);
        list2.set(obj3,1);
        assertEquals(list.get(1), obj2);

    }

    @Test
    void add() {
        Task12 list = new Task12();
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
        Task12 list = new Task12();
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
        Task12 list = new Task12();
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
        Task12 list = new Task12();
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
        Task12 list = new Task12();
        Object obj = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();

        Task12 list2 = new Task12();
        Task12 list3 = new Task12();

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
        Task12 list = new Task12();
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
    void remove1() {

    }

    @Test
    void removeAll() {
    }

    @Test
    void set() {
        Task12 list = new Task12();
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
        Task12 list = new Task12();
        Task12 list2 = new Task12();
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
        Task12 list = new Task12();
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
        Task12 list = new Task12();
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
        Task12 list = new Task12();
        Object obj = new Object();

        assertTrue(list.isEmpty());
        list.add(obj);
        assertFalse(list.isEmpty());
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    void indexOf() {
        Task12 list = new Task12();
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
        Task12 list = new Task12();
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
        Task12 list = new Task12();
        Object obj = new Object();
        Object obj2 = new Object();
        list.add(obj);
        list.add(obj);
        list.add(obj2);
        list.add(obj2);
        list.add(obj);

        Task12 list2 = (Task12) list.subList(2,4);
        assertEquals(list2.size(), 3);
        assertEquals(list2.get(0), list.get(2));
        assertEquals(list2.get(2), list.get(4));
        assertEquals(list2.get(2), obj);
    }

    @Test
    void trimToSize() {
        Task12 list = new Task12();
        Object obj = new Object();
        Object obj2 = new Object();
        assertEquals(10, list.capacity);
        list.add(obj);
        list.add(obj);
        list.add(obj2);
        list.add(obj2);
        list.add(obj);
        list.trimToSize();
        assertEquals(list.size(),list.capacity);
    }

}