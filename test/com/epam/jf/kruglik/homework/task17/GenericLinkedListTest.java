package com.epam.jf.kruglik.homework.task17;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericLinkedListTest {

    @Test
    void addSeveralElementsAndGetLastOfThem() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.add(5);
        list.add(4);
        list.add(3);
        assertTrue(list.getLast().compareTo(3) == 0);
    }

    @Test
    void addSeveralElementsAndAddNewElementOnTheSecondPosition() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(1,9);
        assertTrue(list.get(1).compareTo(9) == 0);
    }

    @Test
    void addElementOnLastPositionInList() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.add(5);
        list.add(4);
        list.add(3);
        list.addLast(1);
        assertTrue(list.getLast().compareTo(1) == 0);
    }

    @Test
    void addElementOnFirstPositionInList() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.add(5);
        list.add(4);
        list.add(3);
        list.addFirst(1);
        assertTrue(list.getFirst().compareTo(1) == 0);
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
    void createLinkedListAndTryToGetOneOfElementsUsingEntry() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(4);
        assertTrue(list.entry(1) == 4);
    }

    @Test
    void createLinkedListAndTryToGetOneOfElementsUsingGet() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(4);
        assertTrue(list.get(1) == 4);
    }

    @Test
    void getLastElementFromList() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(4);
        assertTrue(list.getLast() == 4);
    }

    @Test
    void getFirstElementFromList() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(4);
        assertTrue(list.getFirst() == 5);
    }

    @Test
    void removeFirstElementFromList() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(4);
        list.removeFirst();
        assertTrue(list.getFirst() == 4);
    }

    @Test
    void removeLastElementFromList() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(4);
        list.removeLast();
        assertTrue(list.getLast() == 3);
    }

    @Test
    void removeSecondElementFromList() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(4);
        list.remove(1);
        assertTrue(list.get(1) == 3);
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
}