package com.epam.jf.khvan.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ObjectListTest {

    @Test
    void addFiveWithDifferentType() {
        ObjectList list = new ObjectList();
        list.add(5);
        list.add(5.5);
        list.add('e');
        list.add(4L);
        list.add("string");

        assertTrue(list.size()==5 && list.get(0).equals(5) && list.get(1).equals(5.5) &&
                list.get(2).equals('e') && list.get(3).equals(4L) && list.get(4).equals("string"));
    }



    @Test
    void addElementWithIndex() {

        ObjectList list = new ObjectList();
        list.add(5);
        list.add(5.5);
        list.add('e');
        list.add(4L);
        list.add("string");
        list.add(3,1);

        assertTrue(list.get(1).equals(3) && list.get(2).equals(5.5) && list.get(5).equals("string"));
    }



    @Test
    void addElementsAndCheckOneElement() {
        ObjectList list = new ObjectList();
        list.add(5);
        list.add(5.5);
        list.add('a');
        list.add(4);
        list.add("lol");
        list.add(3.3,1);

        assertTrue(list.contains('a'));
    }



    @Test
    void containsAll() {

        ObjectList list = new ObjectList();

        list.add(5);
        list.add(5.5);
        list.add('a');
        list.add(4);
        list.add("string");
        list.add(3.3,1);

        AbstractObjectList listTwo = new ObjectList();
        list.add(5);
        list.add(5.5);
        list.add('a');

        assertTrue(list.containsAll(listTwo));
    }



    @Test
    void removeElementByIndex() {

        ObjectList list = new ObjectList();

        list.add(5);
        list.add(5.5);
        list.add('e');
        list.add(4L);
        list.add("string");
        list.remove(2);

        assertFalse(list.contains('e'));
    }



    @Test
    void removeElementByValue() {

        ObjectList list = new ObjectList();

        Object element = 'a';
        list.add(5);
        list.add(5.5);
        list.add('a');
        list.add(4L);
        list.add("string");
        list.remove(element);

        assertFalse(list.contains('a'));
    }



    @Test

    void removeAllElementsFromList() {

        ObjectList list = new ObjectList();

        list.add(5);
        list.add(5.5);
        list.add('a');
        list.add(4);
        list.add("string");
        list.add(3.3,1);

        AbstractObjectList listTwo = new ObjectList();
        listTwo.add(5);
        listTwo.add(5.5);
        listTwo.add('a');
        list.removeAll(listTwo);

        assertFalse(list.contains(5.5) && list.contains('a') && list.contains(5));
    }



    @Test

    void setElement() {

        ObjectList list = new ObjectList();

        Object element = 'b';

        list.add(5);
        list.add(5.5);
        list.add('a');
        list.add(4L);
        list.add("lol");
        list.set(element,2);

        assertTrue(list.get(2).equals('b'));
    }



    @Test

    void addAllElementsToList() {

        ObjectList list = new ObjectList();

        list.add(4);
        list.add("lol");
        list.add(3.3,1);

        AbstractObjectList listTwo = new ObjectList();

        listTwo.add(5);
        listTwo.add(5.5);
        listTwo.add('a');
        list.addAll(listTwo);

        assertTrue(list.contains(5.5) && list.contains('a') && list.contains(5));
    }



    @Test

    void sizeOfList() {

        ObjectList list = new ObjectList();

        list.add(5);
        list.add(5.5);
        list.add('a');
        list.add(4L);
        list.add("string");

        assertTrue(list.size() == 5);
    }



    @Test

    void clearList() {

        ObjectList list = new ObjectList();
        list.add(5);
        list.add(5.5);
        list.add('a');
        list.add(4L);
        list.add("lol");

        list.clear();

        assertTrue(list.size() == 0);

    }



    @Test

    void isEmptyList() {

        ObjectList list = new ObjectList();

        list.add(5);
        list.add('a');
        list.add(4L);
        list.add("string");

        assertFalse(list.isEmpty());
    }



    @Test

    void indexOfElement() {

        ObjectList list = new ObjectList();

        list.add(5);
        list.add(5.5);
        list.add('a');
        list.add('a');
        list.add(4L);
        list.add("string");

        assertTrue(list.indexOf('a') == 2);

    }



    @Test

    void lastIndexOfElement() {

        ObjectList list = new ObjectList();

        list.add(5);
        list.add(5.5);
        list.add('a');
        list.add('a');
        list.add("string");

        assertTrue(list.lastIndexOf('a') == 3);
    }



    @Test
    void subList() {
        ObjectList list = new ObjectList();

        list.add(4);
        list.add("string");
        list.add(3.3);

        AbstractObjectList listTwo = list.subList(0, 2);
        assertTrue(listTwo.get(0).equals(4) && list.get(1).equals("string"));
    }

    @Test
    void trimToSize() {
        ObjectList list = new ObjectList();
        list.add(0);
        list.add("string");

        int length = 2;
        list.trimToSize();

        assertTrue(length == list.values.length);
    }
}

