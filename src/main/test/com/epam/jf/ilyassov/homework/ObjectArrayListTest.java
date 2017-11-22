package com.epam.jf.ilyassov.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObjectArrayListTest {

    @Test
    void addTest() {
        ObjectArrayList list = new ObjectArrayList();
        for (int i = 0; i < 5; i++) {
            assertEquals(true,list.add(i));
        }
    }

    @Test
    void addIndexTest() {
        ObjectArrayList list = new ObjectArrayList();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        list.add(2,2);
        assertEquals(2,list.values[2]);
    }

    @Test
    void getTest() {
        ObjectArrayList list = new ObjectArrayList();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        assertEquals(0,list.get(0));
        assertEquals(1,list.get(1));
        assertEquals(2,list.get(2));
        assertEquals(3,list.get(3));
        assertEquals(4,list.get(4));
    }

    @Test
    void containsTest() {
        ObjectArrayList list = new ObjectArrayList();
        for (int i = 0; i < 5; i++) {
            list.add("list"+i);
        }
        assertFalse(list.contains("list6"));
        assertTrue(list.contains("list2"));
    }

    @Test
    void containsAllTest() {
        ObjectArrayList list = new ObjectArrayList();
        ObjectArrayList list2 = new ObjectArrayList();
        for (int i = 0; i < 5; i++) {
            list.add("list"+i);
            list2.add(i);
        }
        ObjectArrayList list1 = new ObjectArrayList(list);
        assertTrue(list.containsAll(list1));
        assertFalse(list.containsAll(list2));
    }

    @Test
    void removeTest() {
        ObjectArrayList list = new ObjectArrayList();
        list.add(45.6);
        list.add("erw");
        list.add(4);
        list.add('5');
        assertEquals(45.6,list.remove(0));
        assertEquals('5',list.remove((Object)'5'));
        assertEquals(4,list.remove(1));
    }

    @Test
    void removeAllTest() {
        ObjectArrayList list = new ObjectArrayList();
        ObjectArrayList list2 = new ObjectArrayList();
        for (int i = 0; i < 5; i++) {
            list.add("list"+i);
            list2.add(i);
        }
        list2.add("list3");
        list2.add("list4");
        assertTrue(list.removeAll(list2));
        assertEquals(3,list.size());
    }

    @Test
    void setTest() {
        ObjectArrayList list = new ObjectArrayList();
        for (int i = 0; i < 5; i++) {
            list.add("list"+i);
        }
        assertEquals("list7",list.set("list7",4));
        assertEquals("list7",list.get(4));
    }

    @Test
    void addAllTest() {
        ObjectArrayList list = new ObjectArrayList();
        for (int i = 0; i < 5; i++) {
            list.add("list"+i);
        }
        ObjectArrayList list1 = new ObjectArrayList(list);
        assertTrue(list.addAll(list1));
        assertEquals("list0",list.get(5));
    }

    @Test
    void clearTest() {

    }

    @Test
    void sizeTest() {
        ObjectArrayList list = new ObjectArrayList();
        for (int i = 0; i < 5; i++) {
            list.add("list"+i);
        }
        assertEquals(5,list.size());
    }

    @Test
    void isEmptyTest() {
        ObjectArrayList list = new ObjectArrayList();
        assertTrue(list.isEmpty());
        list.add(1);
        assertFalse(list.isEmpty());
    }

    @Test
    void indexOfTest() {
        ObjectArrayList list = new ObjectArrayList();
        list.add('g');
        list.add(5);
        assertEquals(0,list.indexOf('g'));
        assertEquals(1,list.indexOf(5));
    }

    @Test
    void lastIndexOfTest() {
        ObjectArrayList list = new ObjectArrayList();
        list.add('g');
        list.add(5);
        list.add(5);
        list.add('g');
        assertEquals(3,list.lastIndexOf('g'));
        assertEquals(2,list.lastIndexOf(5));
    }

    @Test
    void subListTest() {
        ObjectArrayList list = new ObjectArrayList();
        for (int i = 0; i < 5; i++) {
            list.add("list"+i);
        }
        AbstractObjectArrayList sublist=list.subList(0,1);
        assertEquals("list0",sublist.get(0));
        assertEquals("list1",sublist.get(1));
        assertEquals(2,sublist.size());
    }

    @Test
    void trimToSizeTest() {
        ObjectArrayList list = new ObjectArrayList();
        for (int i = 0; i < 11; i++) {
            list.add("list"+i);
        }
        assertEquals(20,list.values.length);
        list.trimToSize();
        assertEquals(list.size(),list.values.length);

    }
}