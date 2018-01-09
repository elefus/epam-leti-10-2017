package com.epam.jf.kozlov.homework.task17;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericLinkedListTest {
    
    @Test
    void addTest() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        for (int i = 0; i < 12345; i++) {
            assertEquals(true, list.add(i));
        }
    }

    @Test
    void addAllTest() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        for (int i = 0; i < 12345; i++) {
            list.add(i);
        }
        GenericLinkedList<Integer> list2 = new GenericLinkedList<>();
        list2.addAll(list);
        assertTrue(list.equeals(list2));
    }

    @Test
    void getTest() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.add(3);
        assertEquals((Integer) 3, list.get(0));
    }

    @Test
    void containsTest() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        assertTrue(list.contains(2));
    }

    @Test
    void containsAllTestTrue() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        GenericLinkedList<Integer> list2 = new GenericLinkedList<>();
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
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        list.remove(Integer.valueOf(3));
        assertEquals((Integer) 4, list.get(3));
    }

    @Test
    void removeAllTestSecondListSmaller() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        GenericLinkedList<Integer> list2 = new GenericLinkedList<>();
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
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        GenericLinkedList<Integer> list2 = new GenericLinkedList<>();
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
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        assertNull(list.set(5, 3));
    }

    @Test
    void clearTest() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    void sizeTest() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        assertEquals(5, list.size());
    }

    @Test
    void isEmptyTest() {
        assertTrue(new GenericLinkedList<>().isEmpty());
    }

    @Test
    void indexOfTest() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        assertEquals(3, list.indexOf(3));
    }

    @Test
    void lastIndexOfTest() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                list.add(j);
            }
        }
        assertEquals(22, list.lastIndexOf(2));
    }

    @Test
    void subListTest() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        GenericLinkedList<Integer> list2 = new GenericLinkedList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        for (int i = 0; i < 3; i++) {
            list2.add(i);
        }
        GenericLinkedList<Integer> list3 = list.sublist(0, 2);
        assertTrue(list2.equeals(list3));
    }
}