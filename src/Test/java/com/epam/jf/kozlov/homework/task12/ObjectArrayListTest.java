package com.epam.jf.kozlov.homework.task12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObjectArrayListTest {
    @Test
    void addTest() {
        ObjectArrayList list = new ObjectArrayList(12345);
        for (int i = 0; i < 12345; i++) {
            assertEquals(true,list.add(i));
        }
    }

    @Test
    void addAllTest() {
        ObjectArrayList list = new ObjectArrayList(12345);
        for (int i = 0; i < 12345; i++) {
            list.add(i);
        }
        ObjectArrayList list2 = new ObjectArrayList();
        list2.addAll(list);
    }

    @Test
    void getTest() {
        ObjectArrayList list = new ObjectArrayList();
        list.add(3);
        assertEquals(3, list.get(0));
    }

    @Test
    void containsTest() {
        ObjectArrayList list = new ObjectArrayList();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        assertTrue(list.contains(2));
    }

    @Test
    void containsAllTestTrue() {
        ObjectArrayList list = new ObjectArrayList();
        ObjectArrayList list2 = new ObjectArrayList();
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
        ObjectArrayList list = new ObjectArrayList();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        list.remove(Integer.valueOf(3));
        assertEquals(4, list.get(3));
    }

    @Test
    void removeAllTestSecondListSmaller() {
        ObjectArrayList list = new ObjectArrayList();
        ObjectArrayList list2 = new ObjectArrayList();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        for (int i = 0; i < 3; i++) {
            list2.add(i);
        }
        list.removeAll(list2);
        assertEquals(3, list.get(0));
    }

    @Test
    void removeAllTestSecondListBigger() {
        ObjectArrayList list = new ObjectArrayList();
        ObjectArrayList list2 = new ObjectArrayList();
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
        ObjectArrayList list = new ObjectArrayList();
        assertNull(list.set(5, 3));
    }

    @Test
    void setTestNotNull() {
        ObjectArrayList list = new ObjectArrayList();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        assertEquals(3, list.set(123, 3));
        assertEquals(123, list.get(3));
    }


    @Test
    void clearTest() {
        ObjectArrayList list = new ObjectArrayList();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    void sizeTest() {
        ObjectArrayList list = new ObjectArrayList();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        assertEquals(5, list.size());
    }

    @Test
    void isEmptyTest() {
        assertTrue(new ObjectArrayList().isEmpty());
    }

    @Test
    void indexOfTest() {
        ObjectArrayList list = new ObjectArrayList();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        assertEquals(3, list.indexOf(3));
    }

    @Test
    void lastIndexOfTest() {
        ObjectArrayList list = new ObjectArrayList();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                list.add(j);
            }
        }
        assertEquals(22, list.lastIndexOf(2));
    }

    @Test
    void subListTestTest() {
        ObjectArrayList list = new ObjectArrayList();
        ObjectArrayList list2 = new ObjectArrayList();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        for (int i = 0; i < 3; i++) {
            list2.add(i);
        }
        ObjectArrayList list3 = list.subList(0, 2);
        assertTrue(list2.equeals(list3));
    }

    @Test
    void trimToSizeTest() {
        ObjectArrayList list = new ObjectArrayList(25);
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        list.trimToSize();
        assertEquals(list.size(), list.values.length);
    }

}