package com.epam.jf.burachenko.homework.task17;

import com.epam.jf.burachenko.homework.task16.GenericList;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class GenericLinkedListTest {
    @Test
    void addSeveralElementsAndAddNewElementOnTheSecondPosition() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(9,1);
        assertTrue(list.get(1).compareTo(9) == 0);
    }

    @Test
    void addElementOnLastPositionInList() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(1);
        assertTrue(list.get(3).compareTo(1) == 0);
    }

    @Test
    void addElementOnFirstPositionInList() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(1, 0);
        assertTrue(list.get(0).compareTo(1) == 0);
    }

    @Test
    void setSecondElementFromList() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.add(5);
        list.add(4);
        list.add(3);
        list.set(1,1);
        assertTrue(list.get(1).compareTo(1) == 0);
    }

    @Test
    void clearList() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.add(5);
        list.add(4);
        list.add(3);
        list.clear();
        assertTrue(list.size() == 0);
    }

    @Test
    void tryingToFindOneOfElementsFromList() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.add(5);
        list.add(4);
        list.add(3);
        assertTrue(list.contains(4));
    }

    @Test
    void tryingToFindOneOfElementsFromListAndGetIndex() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(4);
        assertTrue(list.indexOf(4) == 1);
    }

    @Test
    void tryingToFindOneOfElementsFromListAndGetLastIndex() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(4);
        assertTrue(list.lastIndexOf(4) == 3);
    }

    @Test
    void removeFirstElementFromList() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(4);
        list.remove(0);
        assertTrue(list.get(0) == 4);
    }

    @Test
    void removeLastElementFromList() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(4);
        list.remove(3);
        assertTrue(list.get(2) == 3);
    }

    @Test
    void removeElementFromList() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(4);
        list.remove(2);
        assertTrue(list.get(2) == 4);
    }

    @Test
    void removeOneOfListElements() {
        GenericLinkedList<String> list = new GenericLinkedList<>();
        list.add("5");
        list.add("4");
        list.add("3");
        list.add("4");
        list.remove("5");
        assertTrue(list.get(0).compareTo("4") == 0);
    }

    @Test
    void testSort() {
        GenericList<Integer> list = new GenericLinkedList<>();
        list.add(6);
        list.add(8);
        list.add(1);
        list.add(3);

        System.out.println(Arrays.toString(list.toArray()));
        list.sort(Integer::compareTo);
        System.out.println(Arrays.toString(list.toArray()));
        assertArrayEquals(new Number[]{1, 3, 6, 8}, list.toArray());
    }
}
