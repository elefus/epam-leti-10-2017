package com.epam.jf.kozlov.homework.task17;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericArrayListTest {

    @Test
    void addTest() {
        GenericArrayList<Integer> list = new GenericArrayList<>(12345);
        for (int i = 0; i < 12345; i++) {
            assertEquals(true,list.add(i));
        }
    }

    @Test
    void addAllTest() {
        GenericArrayList<Integer> list = new GenericArrayList<>(12345);
        for (int i = 0; i < 12345; i++) {
            list.add(i);
        }
        GenericArrayList<Integer> list2 = new GenericArrayList<>();
        list2.addAll(list);
        assertTrue(list.equeals(list2));
    }

    @Test
    void getTest() {
        GenericArrayList<Integer> list = new GenericArrayList<>();
        list.add(3);
        assertEquals((Integer) 3, list.get(0));
    }

    @Test
    void containsTest() {
        GenericArrayList<Integer> list = new GenericArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        assertTrue(list.contains(2));
    }

    @Test
    void containsAllTestTrue() {
        GenericArrayList<Integer> list = new GenericArrayList<>();
        GenericArrayList<Integer> list2 = new GenericArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        for (int i = 0; i < 3; i++) {
            list2.add(i);
        }
        assertTrue(list.containsAll(list2));
    }

    @Test
    void removeTest() {
        GenericArrayList<Integer> list = new GenericArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        list.remove(Integer.valueOf(3));
        assertEquals((Integer) 4, list.get(3));
    }

    @Test
    void removeAllTestSecondListSmaller() {
        GenericArrayList<Integer> list = new GenericArrayList<>();
        GenericArrayList<Integer> list2 = new GenericArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        for (int i = 0; i < 3; i++) {
            list2.add(i);
        }
        list.removeAll(list2);
        assertEquals((Integer) 3, list.get(0));
    }

    @Test
    void removeAllTestSecondListBigger() {
        GenericArrayList<Integer> list = new GenericArrayList<>();
        GenericArrayList<Integer> list2 = new GenericArrayList<>();
        for (int i = 0; i < 5; i++) {
            list2.add(i);
        }
        for (int i = 0; i < 3; i++) {
            list.add(i);
        }
        list.removeAll(list2);
        assertTrue(list.isEmpty());
    }

    @Test
    void setTestNull() {
        GenericArrayList<Integer> list = new GenericArrayList<>();
        assertNull(list.set(5, 3));
    }

    @Test
    void clearTest() {
        GenericArrayList<Integer> list = new GenericArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    void sizeTest() {
        GenericArrayList<Integer> list = new GenericArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        assertEquals(5, list.size());
    }

    @Test
    void isEmptyTest() {
        assertTrue(new GenericArrayList<>().isEmpty());
    }

    @Test
    void indexOfTest() {
        GenericArrayList<Integer> list = new GenericArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        assertEquals(3, list.indexOf(3));
    }

    @Test
    void lastIndexOfTest() {
        GenericArrayList<Integer> list = new GenericArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                list.add(j);
            }
        }
        assertEquals(22, list.lastIndexOf(2));
    }

    @Test
    void subListTest() {
        GenericArrayList<Integer> list = new GenericArrayList<>();
        GenericArrayList<Integer> list2 = new GenericArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        for (int i = 0; i < 3; i++) {
            list2.add(i);
        }
        GenericArrayList<Integer> list3 = list.sublist(0, 2);
        assertTrue(list2.equeals(list3));
    }
}
