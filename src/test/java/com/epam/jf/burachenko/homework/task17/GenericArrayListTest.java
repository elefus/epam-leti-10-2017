package com.epam.jf.burachenko.homework.task17;

import com.epam.jf.burachenko.homework.task16.GenericList;
import org.junit.jupiter.api.Test;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class GenericArrayListTest {
    @Test
    void add() {
        GenericArrayList<Integer> list = new GenericArrayList<>();
        list.add(5);
        list.add(4);
        list.add(3);
        assertEquals(list.get(2), new Integer(3));
    }

    @Test
    void add1() {
        GenericArrayList<Integer> list = new GenericArrayList<>();
        list.add(3);
        list.add(1);
        list.add(4);
        list.add(5, 1);
        assertEquals(new Integer(5), list.get(1));
    }

    @Test
    void remove() {
        GenericArrayList<Integer> list = new GenericArrayList<>();
        list.add(2);
        list.add(0);
        list.add(-1);
        list.remove(1);
        assertEquals(new Integer(-1), list.get(1));
    }

    @Test
    void clear() {
        GenericArrayList<Integer> list = new GenericArrayList<>();
        list.add(2);
        list.add(0);
        list.add(-1);
        list.remove(1);
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    void subList() {
        GenericArrayList<Integer> list = new GenericArrayList<>();
        list.add(2);
        list.add(0);
        list.add(-1);
        GenericList<Integer> subList = list.subList(1, 2);
        assertEquals(new Integer(-1), subList.get(1));
        assertEquals(new Integer(0), subList.get(0));
    }

    @Test
    void testGet() {
        GenericList<Number> list = new GenericArrayList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
        list.add(100);
        assertEquals(100, list.get(0));
    }

    @Test
    void testContains() {
        GenericList<Number> list = new GenericArrayList<>();
        list.add(128);
        assertTrue(list.contains(128));
        assertFalse(list.contains(129));
    }

    @Test
    void testRemove() {
        GenericList<Number> list1 = new GenericArrayList<>();

        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);

        list1.remove(2);
        assertArrayEquals(new Number[]{1, 2, 4}, list1.toArray());

        list1.remove(2);
        assertArrayEquals(new Number[]{1, 2}, list1.toArray());

        list1.remove(0);
        assertArrayEquals(new Number[]{2}, list1.toArray());

        list1.remove(0);
        assertArrayEquals(new Number[0], list1.toArray());

        assertThrows(IndexOutOfBoundsException.class, () -> list1.remove(0));
    }

    @Test
    void testSet() {
        GenericList<Number> list = new GenericArrayList<>();
        list.add(444);
        list.set(555, 0);
        assertArrayEquals(new Number[]{555}, list.toArray());
    }

    @Test
    void testClear() {
        GenericList<Number> list = new GenericArrayList<>();
        list.add(444);
        list.clear();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    void testIsEmpty() {
        GenericList<Number> lisе = new GenericArrayList<>(100);
        assertTrue(lisе.isEmpty());
    }

    @Test
    void testIndexOf() {
        GenericList<Number> list = new GenericArrayList<>();
        list.add(444);

        assertEquals(0, list.indexOf(444));
        assertEquals(-1, list.indexOf(555));
    }

    @Test
    void testLastIndexOf() {
        GenericList<Number> list = new GenericArrayList<>();
        list.add(444);
        list.add(555);
        list.add(444);
        list.add(555);

        assertEquals(2, list.lastIndexOf(444));
        assertEquals(-1, list.lastIndexOf(333));
    }

    @Test
    void testSubList() {
        GenericList<Integer> list1 = new GenericArrayList<>();
        list1.add(444);
        list1.add(555);
        list1.add(444);
        list1.add(555);

        GenericList<? extends Number> list2 = list1.subList(1, 2);
        assertArrayEquals(new Number[]{555, 444}, list2.toArray());
    }

    @Test
    void testSort() {
        GenericList<Integer> list = new GenericArrayList<>();
        list.add(6);
        list.add(8);
        list.add(1);
        list.add(3);

        list.sort(Comparator.comparing(o -> o));
        assertArrayEquals(new Number[]{1, 3, 6, 8}, list.toArray());
    }
}
