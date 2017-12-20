package com.epam.jf.khvan.homework;


import org.junit.jupiter.api.Test;
import task17.ArrayListImplement;
import task17.LinkedListImplement;


import static org.junit.jupiter.api.Assertions.*;

class GenericListTest {

    @Test
    void testAdd1() {
        Object[] expected;
        ArrayListImplement<Number> list1 = new ArrayListImplement<>();
        LinkedListImplement<Number> list2 = new LinkedListImplement<>();

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
        list2.add(12L);
        assertEquals(2, list1.size());
        assertEquals(2, list2.size());
        assertEquals(11L, list1.get(1));
        assertEquals(12L, list2.get(1));
    }

    @Test
    void testAdd2() {
        ArrayListImplement<Number> list1 = new ArrayListImplement<>();
        LinkedListImplement<Number> list2 = new LinkedListImplement<>();

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
        ArrayListImplement<Number> list = new ArrayListImplement<>();
        list.add(5);
        list.add(10);
        list.add(15);

        ArrayListImplement<Number> list1 = new ArrayListImplement<>();
        LinkedListImplement<Number> list2 = new LinkedListImplement<>();

        list1.addAll(list);
        list2.addAll(list);

        Object[] expected = new Number[]{5, 10, 15};
        assertArrayEquals(expected, list1.toArray());
        assertArrayEquals(expected, list2.toArray());
    }

    @Test
    void testGet() {
        ArrayListImplement<Number> list1 = new ArrayListImplement<>();
        LinkedListImplement<Number> list2 = new LinkedListImplement<>();

        list1.add(100);
        list2.addAll(list1);

        assertEquals(100, list1.get(0));
        assertEquals(list1.get(0), list2.get(0));
    }

    @Test
    void testContains() {
        ArrayListImplement<Number> list1 = new ArrayListImplement<>();
        list1.add(128);
        LinkedListImplement<Number> list2 = new LinkedListImplement<>(list1);

        assertTrue(list1.contains(128));
        assertTrue(list2.contains(128));
        assertFalse(list1.contains(129));
        assertFalse(list2.contains(129));
        assertFalse(list1.contains(null));
        assertFalse(list2.contains(null));
    }

    @Test
    void testContainsAll() {
        LinkedListImplement<Long> list = new LinkedListImplement<>();
        list.add(128L);

        ArrayListImplement<Number> list1 = new ArrayListImplement<>(list);
        LinkedListImplement<Number> list2 = new LinkedListImplement<>(list);

        assertTrue(list1.containsAll(list));
        assertTrue(list2.containsAll(list));

        list.add(129L);
        assertFalse(list1.containsAll(list));
        assertFalse(list2.containsAll(list));
    }

    @Test
    void testRemove1() {
        ArrayListImplement<Number> list1 = new ArrayListImplement<>();
        LinkedListImplement<Number> list2 = new LinkedListImplement<>();

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
    }


    @Test
    void testRemoveAll() {
        ArrayListImplement<Long> list = new ArrayListImplement<>();
        list.add(128L);
        list.add(129L);
        list.add(130L);
        ArrayListImplement<Number> list1 = new ArrayListImplement<>(list);
        LinkedListImplement<Number> list2 = new LinkedListImplement<>(list);
        list.remove(2);

        list1.removeAll(list);
        list2.removeAll(list);
        Object[] expected = new Number[]{130L};
       assertArrayEquals(expected, list1.toArray());
        assertArrayEquals(expected, list2.toArray());
    }


    @Test
    void testSet() {
        ArrayListImplement<Number> list1 = new ArrayListImplement<>();
        list1.add(444);
        LinkedListImplement<Number> list2 = new LinkedListImplement<>(list1);

        list1.set(555, 0);
        list2.set(555, 0);
        Object[] expected = new Number[]{555};
        assertArrayEquals(expected, list1.toArray());
        assertArrayEquals(expected, list2.toArray());
    }



    @Test
    void testClear() {
        ArrayListImplement<Number> list1 = new ArrayListImplement<>();

        list1.add(444);
        LinkedListImplement<Number> list2 = new LinkedListImplement<>(list1);

        list1.clear();
        list2.clear();

        assertTrue(list1.isEmpty() && list2.isEmpty());
        assertEquals(0, list1.size() + list2.size());
    }

    @Test
    void testIsEmpty() {
        ArrayListImplement<Number> list1 = new ArrayListImplement<>(100);
        LinkedListImplement<Number> list2 = new LinkedListImplement<>(list1);

        assertTrue(list1.isEmpty() && list2.isEmpty());
    }

    @Test
    void testIndexOf() {
        ArrayListImplement<Number> list1 = new ArrayListImplement<>();
        list1.add(444);
        LinkedListImplement<Number> list2 = new LinkedListImplement<>(list1);

        assertEquals(0, list1.indexOf(444));
        assertEquals(0, list2.indexOf(444));
        assertEquals(-1, list1.indexOf(555));
        assertEquals(-1, list2.indexOf(555));
    }

    @Test
    void testLastIndexOf() {
        ArrayListImplement<Number> list1 = new ArrayListImplement<>();
        list1.add(444);
        list1.add(555);
        list1.add(444);
        list1.add(555);
        LinkedListImplement<Number> list2 = new LinkedListImplement<>(list1);

        assertEquals(2, list1.lastIndexOf(444));
        assertEquals(2, list2.lastIndexOf(444));
        assertEquals(-1, list1.lastIndexOf(333));
        assertEquals(-1, list2.lastIndexOf(333));
    }

    @Test
    void testSubList() {
        ArrayListImplement<Integer> list1 = new ArrayListImplement<>();
        list1.add(444);
        list1.add(555);
        list1.add(444);
        list1.add(555);
        LinkedListImplement<Integer> list2 = new LinkedListImplement<>(list1);

        ArrayListImplement<? extends Number> list3 = list1.subList(1, 2);
        LinkedListImplement<? extends Number> list4 = list2.subList(1, 2);
        Object[] expected = new Number[]{555};
        assertArrayEquals(expected, list3.toArray());
        assertArrayEquals(expected, list4.toArray());
    }
}

