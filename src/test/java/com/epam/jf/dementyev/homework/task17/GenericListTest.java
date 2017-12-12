package com.epam.jf.dementyev.homework.task17;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.epam.jf.dementyev.homework.task16.GenericList;
import java.util.Comparator;
import org.junit.jupiter.api.Test;

class GenericListTest {

    @Test
    void testAdd1() {
        Object[] expected;
        GenericList<Number> list1 = new GenericArrayList<>();
        GenericList<Number> list2 = new GenericLinkedList<>();

        expected = new Number[0];
        assertEquals(0, list1.size());
        assertEquals(0, list2.size());
        assertArrayEquals(expected, list1.toArray());
        assertArrayEquals(expected, list2.toArray());

        list1.add(10);
        list2.add(10);
        assertEquals(1, list1.size());
        assertEquals(1, list2.size());
        assertEquals(10, list1.get(0));
        assertEquals(10, list2.get(0));

        list1.add(11L);
        list2.add(11L);
        assertEquals(2, list1.size());
        assertEquals(2, list2.size());
        assertEquals(11L, list1.get(1));
        assertEquals(11L, list2.get(1));
    }

    @Test
    void testAdd2() {
        GenericList<Number> list1 = new GenericArrayList<>();
        GenericList<Number> list2 = new GenericLinkedList<>();

        list1.add(12, 0);
        list2.add(12, 0);
        assertEquals(1, list1.size());
        assertEquals(1, list2.size());
        assertEquals(12, list1.get(0));
        assertEquals(12, list2.get(0));

        list1.add(11L, 0);
        list2.add(11L, 0);
        assertEquals(2, list1.size());
        assertEquals(2, list2.size());
        assertEquals(11L, list1.get(0));
        assertEquals(11L, list2.get(0));

        list1.add(10, 1);
        list2.add(10, 1);
        Object[] expected = new Number[]{11L, 10, 12};
        assertArrayEquals(expected, list1.toArray());
        assertArrayEquals(expected, list2.toArray());
    }

    @Test
    void testAddAll() {
        GenericList<Integer> list = new GenericArrayList<>();
        list.add(5);

        GenericList<Number> list1 = new GenericArrayList<>(list);
        GenericList<Number> list2 = new GenericLinkedList<>(list);

        list.remove(0);
        list.add(10);
        list.add(15);
        list1.addAll(list);
        list2.addAll(list);

        Object[] expected = new Number[]{5, 10, 15};
        assertArrayEquals(expected, list1.toArray());
        assertArrayEquals(expected, list2.toArray());
    }

    @Test
    void testGet() {
        GenericList<Number> list1 = new GenericArrayList<>();
        GenericList<Number> list2 = new GenericLinkedList<>();

        assertThrows(IndexOutOfBoundsException.class, () -> list1.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> list2.get(0));

        list1.add(100);
        list2.addAll(list1);

        assertEquals(100, list1.get(0));
        assertEquals(list1.get(0), list2.get(0));
    }

    @Test
    void testContains() {
        GenericList<Number> list1 = new GenericArrayList<>();
        list1.add(128);
        GenericList<Number> list2 = new GenericLinkedList<>(list1);

        assertTrue(list1.contains(128));
        assertTrue(list2.contains(128));
        assertFalse(list1.contains(129));
        assertFalse(list2.contains(129));
        assertFalse(list1.contains(null));
        assertFalse(list2.contains(null));
    }

    @Test
    void testContainsAll() {
        GenericList<Long> list = new GenericLinkedList<>();
        list.add(128L);
        GenericList<Number> list1 = new GenericArrayList<>(list);
        GenericList<Number> list2 = new GenericLinkedList<>(list);

        assertTrue(list1.containsAll(list));
        assertTrue(list2.containsAll(list));

        list.add(129L);
        assertFalse(list1.containsAll(list));
        assertFalse(list2.containsAll(list));
    }

    @Test
    void testRemove1() {
        GenericList<Number> list1 = new GenericArrayList<>();
        GenericList<Number> list2 = new GenericLinkedList<>();

        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list1.addAll(list2);

        Object[] expected = new Number[]{1, 2, 4};
        list1.remove(2);
        list2.remove(2);
        assertArrayEquals(expected, list1.toArray());
        assertArrayEquals(expected, list2.toArray());

        list1.remove(2);
        list2.remove(2);
        expected = new Number[]{1, 2};
        assertArrayEquals(expected, list1.toArray());
        assertArrayEquals(expected, list2.toArray());

        list1.remove(0);
        list2.remove(0);
        expected = new Number[]{2};
        assertArrayEquals(expected, list1.toArray());
        assertArrayEquals(expected, list2.toArray());

        list1.remove(0);
        list2.remove(0);
        expected = new Number[0];
        assertArrayEquals(expected, list1.toArray());
        assertArrayEquals(expected, list2.toArray());

        assertThrows(IndexOutOfBoundsException.class, () -> list1.remove(0));
        assertThrows(IndexOutOfBoundsException.class, () -> list2.remove(0));
    }

    @Test
    void testRemove2() {
        GenericList<Number> list1 = new GenericArrayList<>();
        GenericList<Number> list2 = new GenericLinkedList<>();

        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list1.addAll(list2);

        Object[] expected = new Number[]{1, 2, 4};
        list1.remove(Integer.valueOf(3));
        list2.remove(Integer.valueOf(3));
        assertArrayEquals(expected, list1.toArray());
        assertArrayEquals(expected, list2.toArray());

        list1.remove(Integer.valueOf(4));
        list2.remove(Integer.valueOf(4));
        expected = new Number[]{1, 2};
        assertArrayEquals(expected, list1.toArray());
        assertArrayEquals(expected, list2.toArray());

        list1.remove(Integer.valueOf(1));
        list2.remove(Integer.valueOf(1));
        expected = new Number[]{2};
        assertArrayEquals(expected, list1.toArray());
        assertArrayEquals(expected, list2.toArray());

        list1.remove(Integer.valueOf(2));
        list2.remove(Integer.valueOf(2));
        expected = new Number[0];
        assertArrayEquals(expected, list1.toArray());
        assertArrayEquals(expected, list2.toArray());

        assertThrows(IndexOutOfBoundsException.class, () -> list1.remove(0));
        assertThrows(IndexOutOfBoundsException.class, () -> list2.remove(0));
    }

    @Test
    void testRemoveAll() {
        GenericList<Long> list = new GenericLinkedList<>();
        list.add(128L);
        list.add(129L);
        list.add(130L);
        GenericList<Number> list1 = new GenericArrayList<>(list);
        GenericList<Number> list2 = new GenericLinkedList<>(list);
        list.remove(2);

        list1.removeAll(list);
        list2.removeAll(list);
        Object[] expected = new Number[]{130L};
        assertArrayEquals(expected, list1.toArray());
        assertArrayEquals(expected, list2.toArray());
    }

    @Test
    void testSet() {
        GenericList<Number> list1 = new GenericArrayList<>();
        list1.add(444);
        GenericList<Number> list2 = new GenericLinkedList<>(list1);

        list1.set(555, 0);
        list2.set(555, 0);
        Object[] expected = new Number[]{555};
        assertArrayEquals(expected, list1.toArray());
        assertArrayEquals(expected, list2.toArray());
    }

    @Test
    void testClear() {
        GenericList<Number> list1 = new GenericArrayList<>();
        list1.add(444);
        GenericList<Number> list2 = new GenericLinkedList<>(list1);

        list1.clear();
        list2.clear();

        assertTrue(list1.isEmpty() && list2.isEmpty());
        assertEquals(0, list1.size() + list2.size());
    }

    @Test
    void testIsEmpty() {
        GenericList<Number> list1 = new GenericArrayList<>(100);
        GenericList<Number> list2 = new GenericLinkedList<>(list1);

        assertTrue(list1.isEmpty() && list2.isEmpty());
    }

    @Test
    void testIndexOf() {
        GenericList<Number> list1 = new GenericArrayList<>();
        list1.add(444);
        GenericList<Number> list2 = new GenericLinkedList<>(list1);

        assertEquals(0, list1.indexOf(444));
        assertEquals(0, list2.indexOf(444));
        assertEquals(-1, list1.indexOf(555));
        assertEquals(-1, list2.indexOf(555));
    }

    @Test
    void testLastIndexOf() {
        GenericList<Number> list1 = new GenericArrayList<>();
        list1.add(444);
        list1.add(555);
        list1.add(444);
        list1.add(555);
        GenericList<Number> list2 = new GenericLinkedList<>(list1);

        assertEquals(2, list1.lastIndexOf(444));
        assertEquals(2, list2.lastIndexOf(444));
        assertEquals(-1, list1.lastIndexOf(333));
        assertEquals(-1, list2.lastIndexOf(333));
    }

    @Test
    void testSubList() {
        GenericList<Integer> list1 = new GenericArrayList<>();
        list1.add(444);
        list1.add(555);
        list1.add(444);
        list1.add(555);
        GenericList<Integer> list2 = new GenericLinkedList<>(list1);

        GenericList<? extends Number> list3 = list1.subList(1, 2);
        GenericList<? extends Number> list4 = list2.subList(1, 2);
        Object[] expected = new Number[]{555, 444};
        assertArrayEquals(expected, list3.toArray());
        assertArrayEquals(expected, list4.toArray());
    }

    @Test
    void testSort() {
        GenericList<Integer> list1 = new GenericArrayList<>();
        list1.add(6);
        list1.add(8);
        list1.add(1);
        list1.add(3);
        GenericList<Integer> list2 = new GenericLinkedList<>(list1);

        list1.sort(Comparator.comparing(o -> o));
        list2.sort(Comparator.comparing(o -> o));
        Object[] expected = new Number[]{1, 3, 6, 8};
        assertArrayEquals(expected, list1.toArray());
        assertArrayEquals(expected, list2.toArray());
    }
}