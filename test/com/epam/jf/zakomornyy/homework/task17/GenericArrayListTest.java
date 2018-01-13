package com.epam.jf.zakomornyy.homework.task17;

import com.epam.jf.zakomornyy.homework.task16.GenericList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GenericArrayListTest {
    @Test
    void constructor() {
        GenericArrayList<Integer> arrayList = new GenericArrayList<>();
        assertEquals(arrayList.size(), 0);
        arrayList.add(5);
        assertEquals(arrayList.size(), 1);
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
        GenericArrayList<Integer> arrayList = new GenericArrayList<>(3);
        arrayList.add(13);
        arrayList.add(53);
        arrayList.add(28);
        GenericArrayList<Integer> anotherArrayList = new GenericArrayList<>(arrayList);
        assertEquals(arrayList.get(0), anotherArrayList.get(0));
        assertEquals(arrayList.get(1), anotherArrayList.get(1));
        assertEquals(arrayList.get(2), anotherArrayList.get(2));
        assertEquals(anotherArrayList.size(), 3);
    }

    @Test
    void toArray() {
        GenericArrayList<Integer> arrayList = new GenericArrayList<>(3);
        arrayList.add(13);
        arrayList.add(53);
        arrayList.add(28);
        Object[] array = arrayList.toArray();
        for (int i = 0; i < array.length; i++) {
            array[i].equals(arrayList.get(i));
        }
    }

    @Test
    void add() {
        GenericArrayList<Integer> arrayList = new GenericArrayList<>(1);
        arrayList.add(13);
        assertEquals(arrayList.get(0), new Integer(13));
        assertEquals(arrayList.size(), 1);
    }

    @Test
    void remove() {
        GenericArrayList<Integer> arrayList = new GenericArrayList<>(3);
        arrayList.add(13);
        arrayList.add(53);
        arrayList.add(28);
        arrayList.remove(1);
        assertEquals(arrayList.get(0), new Integer(13));
        assertEquals(arrayList.get(1), new Integer(28));
        assertEquals(arrayList.size(), 2);
    }

    @Test
    void get() {
        GenericArrayList<Integer> arrayList = new GenericArrayList<>(3);
        arrayList.add(13);
        assertEquals(arrayList.get(0), new Integer(13));
    }

    @Test
    void set() {
        GenericArrayList<Integer> arrayList = new GenericArrayList<>(3);
        arrayList.add(13);
        Integer integer = arrayList.set(0, 24);
        assertEquals(arrayList.get(0), new Integer(24));
        assertEquals(integer, new Integer(13));
    }

    @Test
    void add1() {
        GenericArrayList<Integer> arrayList = new GenericArrayList<>(3);
        arrayList.add(13);
        arrayList.add(0, 26);
        assertEquals(arrayList.get(0), new Integer(26));
    }

    @Test
    void remove1() {
        GenericArrayList<Integer> arrayList = new GenericArrayList<>(0);
        arrayList.add(13);
        arrayList.add(0, 26);
        assertEquals(arrayList.get(0), new Integer(26));
    }

    @Test
    void indexOf() {
        GenericArrayList<Integer> arrayList = new GenericArrayList<>(0);
        arrayList.add(24);
        arrayList.add(13);
        arrayList.add(13);
        arrayList.add(13);
        arrayList.add(12);
        assertEquals(arrayList.indexOf(13), 1);
    }

    @Test
    void lastIndexOf() {
        GenericArrayList<Integer> arrayList = new GenericArrayList<>(0);
        arrayList.add(24);
        arrayList.add(13);
        arrayList.add(13);
        arrayList.add(13);
        arrayList.add(12);
        assertEquals(arrayList.lastIndexOf(13), 3);
    }

    @Test
    void subList() {
        GenericArrayList<Integer> arrayList = new GenericArrayList<>(0);
        arrayList.add(24);
        arrayList.add(13);
        arrayList.add(13);
        arrayList.add(13);
        arrayList.add(12);
        GenericList<Integer> anotherArrayList = arrayList.subList(1, 3);
        for(int i = 0; i < anotherArrayList.size(); i++) {
            anotherArrayList.get(i).equals(13);
        }
    }
}
