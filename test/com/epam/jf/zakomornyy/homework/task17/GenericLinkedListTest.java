package com.epam.jf.zakomornyy.homework.task17;


import com.epam.jf.zakomornyy.homework.task16.GenericList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GenericLinkedListTest {
    @Test
    void constructor() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        assertEquals(list.size(), 0);
        list.add(5);
        assertEquals(list.size(), 1);
    }

    @Test
    void copasityConstructor() {
        GenericArrayList<Integer> arrayList = new GenericArrayList<>(1);
        arrayList.add(0, 13);
        assertEquals(arrayList.get(0), new Integer(13));
        assertEquals(arrayList.size(), 1);
    }

    @Test
    void copyConstructor() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.add(13);
        list.add(53);
        list.add(28);
        GenericLinkedList<Integer> anotherList = new GenericLinkedList<>(list);
        assertEquals(list.get(0), anotherList.get(0));
        assertEquals(list.get(1), anotherList.get(1));
        assertEquals(list.get(2), anotherList.get(2));
        assertEquals(anotherList.size(), 3);
    }

    @Test
    void toArray() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.add(13);
        list.add(53);
        list.add(28);
        Object[] array = list.toArray();
        for (int i = 0; i < array.length; i++) {
            array[i].equals(list.get(i));
        }
    }

    @Test
    void add() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.add(13);
        assertEquals(list.get(0), new Integer(13));
        assertEquals(list.size(), 1);
    }

    @Test
    void remove() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.add(13);
        list.add(53);
        list.add(28);
        list.remove(1);
        assertEquals(list.get(0), new Integer(13));
        assertEquals(list.get(1), new Integer(28));
        assertEquals(list.size(), 2);
    }

    @Test
    void get() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.add(13);
        assertEquals(list.get(0), new Integer(13));
    }

    @Test
    void set() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.add(13);
        Integer integer = list.set(0, 24);
        assertEquals(list.get(0), new Integer(24));
        assertEquals(integer, new Integer(13));
    }

    @Test
    void add1() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.add(13);
        list.add(0, 26);
        assertEquals(list.get(0), new Integer(26));
    }

    @Test
    void remove1() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.add(13);
        list.add(0, 26);
        assertEquals(list.get(0), new Integer(26));
    }

    @Test
    void indexOf() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.add(24);
        list.add(13);
        list.add(13);
        list.add(13);
        list.add(12);
        assertEquals(list.indexOf(13), 1);
    }

    @Test
    void lastIndexOf() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.add(24);
        list.add(13);
        list.add(13);
        list.add(13);
        list.add(12);
        assertEquals(list.lastIndexOf(13), 3);
    }

    @Test
    void subList() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.add(24);
        list.add(13);
        list.add(13);
        list.add(13);
        list.add(12);
        GenericList<Integer> anotherList = list.subList(1, 3);
        for(int i = 0; i < anotherList.size(); i++) {
            anotherList.get(i).equals(13);
        }
    }
}