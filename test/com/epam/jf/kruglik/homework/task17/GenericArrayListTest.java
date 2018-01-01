package com.epam.jf.kruglik.homework.task17;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericArrayListTest {

    @Test
    void addSeveralStringsAndGetSecondElement() {
        GenericArrayList<String> list = new GenericArrayList<>();
        list.add("Alex");
        list.add("Need");
        list.add("Study");
        list.add("Java");
        assertTrue(list.get(1).compareTo("Need") == 0);
    }

    @Test
    void addStringOnAnyonePositionAndGetThisElement() {
        GenericArrayList<String> list = new GenericArrayList<>();
        list.add("Alex");
        list.add("Need");
        list.add("Study");
        list.add("Java");
        list.add(1,"Kruglik");
        assertTrue(list.get(1).compareTo("Kruglik") == 0);
    }

    @Test
    void addAnotherListToYourListAndGetOneOfThemElement() {
        GenericArrayList<String> list = new GenericArrayList<>();
        GenericArrayList<String> listTwo = new GenericArrayList<>();
        list.add("Alex");
        list.add("Need");
        listTwo.add("Study");
        listTwo.add("Java");
        list.addAll(listTwo);
        assertTrue(list.get(2).compareTo("Study") == 0);
    }
    
    @Test
    void addSeveralElementsInListAndIndexOfAnyoneElement() {
        GenericArrayList<String> list = new GenericArrayList<>();
        GenericArrayList<String> listTwo = new GenericArrayList<>();
        list.add("Alex");
        list.add("Need");
        listTwo.add("Study");
        listTwo.add("Java");
        listTwo.add("Need");
        list.addAll(listTwo);
        assertTrue(list.indexOf("Need") == 1);
    }

    @Test
    void addSeveralElementsInListAndLastIndexOfAnyoneElement() {
        GenericArrayList<String> list = new GenericArrayList<>();
        GenericArrayList<String> listTwo = new GenericArrayList<>();
        list.add("Alex");
        list.add("Need");
        listTwo.add("Study");
        listTwo.add("Java");
        listTwo.add("Need");
        list.addAll(listTwo);
        assertTrue(list.lastIndexOf("Need") == 4);
    }

    @Test
    void addSeveralElementsInListAndTryToFindAnotherElement() {
        GenericArrayList<String> list = new GenericArrayList<>();
        GenericArrayList<String> listTwo = new GenericArrayList<>();
        list.add("Alex");
        list.add("Need");
        listTwo.add("Study");
        listTwo.add("Java");
        listTwo.add("Need");
        list.addAll(listTwo);
        assertFalse(list.contains("Studykj"));
    }

    @Test
    void addSeveralElementsInListAndRemoveFirstElement() {
        GenericArrayList<String> list = new GenericArrayList<>();
        GenericArrayList<String> listTwo = new GenericArrayList<>();
        list.add("Alex");
        list.add("Need");
        listTwo.add("Study");
        listTwo.add("Java");
        listTwo.add("Need");
        list.addAll(listTwo);
        list.remove(0);
        assertFalse(list.contains("Alex"));
    }

    @Test
    void addSeveralElementsInListAndRemoveVariableEqualsFirstElement() {
        GenericArrayList<String> list = new GenericArrayList<>();
        GenericArrayList<String> listTwo = new GenericArrayList<>();
        list.add("Alex");
        list.add("Need");
        listTwo.add("Study");
        listTwo.add("Java");
        listTwo.add("Need");
        list.addAll(listTwo);
        list.remove("Alex");
        assertFalse(list.contains("Alex"));
    }

    @Test
    void removeAllElementsAnotherListFromYourListToYourList() {
        GenericArrayList<String> list = new GenericArrayList<>();
        GenericArrayList<String> listTwo = new GenericArrayList<>();
        list.add("Alex");
        list.add("Need");
        list.add("Study");
        listTwo.add("Alex");
        listTwo.add("Need");
        list.removeAll(listTwo);
        assertFalse(list.contains("Alex"));
    }

    @Test
    void setFirstElementFromList() {
        GenericArrayList<String> list = new GenericArrayList<>();
        list.add("Alex");
        list.add("Need");
        list.add("Study");
        list.set(0,"Denis");
        assertTrue(list.get(0).compareTo("Denis") == 0);
    }

    @Test
    void clearList() {
        GenericArrayList<String> list = new GenericArrayList<>();
        list.add("Alex");
        list.add("Need");
        list.add("Study");
        list.clear();
        assertTrue(list.size() == 0);
    }

    @Test
    void subList() {
    }

    @Test
    void trimToSize() {
        GenericArrayList<String> list = new GenericArrayList<>();
        list.add("Alex");
        list.add("Need");
        list.add("Study");
        list.trimToSize();
        assertTrue(list.size() == list.getCapacity());
    }
}