package main.java.com.epam.jf.kruglik.homework.task12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObjectArrayListTest {
    @Test
    void addFiveWithDifferentTypeElementsInListAndGetAllElements() {
        ObjectArrayList list = new ObjectArrayList();
        list.add(5);
        list.add(5.5);
        list.add('a');
        list.add(4L);
        list.add("lol");
        assertTrue(list.size()==5 && list.get(0).equals(5) && list.get(1).equals(5.5) &&
                            list.get(2).equals('a') && list.get(3).equals(4L) && list.get(4).equals("lol"));
    }

    @Test
    void addElementWithIndexInList() {
        ObjectArrayList list = new ObjectArrayList();
        list.add(5);
        list.add(5.5);
        list.add('a');
        list.add(4L);
        list.add("lol");
        list.add(3.3,1);
        assertTrue(list.get(1).equals(3.3) && list.get(2).equals(5.5) && list.get(5).equals("lol"));
    }

    @Test
    void addManyElementsInListAndCheckOneElementFromThere() {
        ObjectArrayList list = new ObjectArrayList();
        list.add(5);
        list.add(5.5);
        list.add('a');
        list.add(4);
        list.add("lol");
        list.add(3.3,1);
        assertTrue(list.contains('a'));
    }

    @Test
    void containsAllCreateTwoListsAndTryToFindSecondIntoFirstList() {
        ObjectArrayList list = new ObjectArrayList();
        list.add(5);
        list.add(5.5);
        list.add('a');
        list.add(4);
        list.add("lol");
        list.add(3.3,1);
        AbstractObjectArrayList listTwo = new ObjectArrayList();
        list.add(5);
        list.add(5.5);
        list.add('a');

        assertTrue(list.containsAll(listTwo));
    }

    @Test
    void removeCreateListWithFiveElementsAndRemoveSecondElementUsingIndex() {
        ObjectArrayList list = new ObjectArrayList();
        list.add(5);
        list.add(5.5);
        list.add('a');
        list.add(4L);
        list.add("lol");
        list.remove(2);
        assertFalse(list.contains('a'));
    }

    @Test
    void removeCreateListWithFiveElementsAndRemoveSecondElementUsingElement() {
        ObjectArrayList list = new ObjectArrayList();
        Object element = 'a';
        list.add(5);
        list.add(5.5);
        list.add('a');
        list.add(4L);
        list.add("lol");
        list.remove(element);
        assertFalse(list.contains('a'));
    }

    @Test
    void removeAllElementsSecondListFromFirst() {
        ObjectArrayList list = new ObjectArrayList();
        list.add(5);
        list.add(5.5);
        list.add('a');
        list.add(4);
        list.add("lol");
        list.add(3.3,1);
        AbstractObjectArrayList listTwo = new ObjectArrayList();
        listTwo.add(5);
        listTwo.add(5.5);
        listTwo.add('a');
        list.removeAll(listTwo);

        assertFalse(list.contains(5.5) && list.contains('a') && list.contains(5));
    }

    @Test
    void setElementToList() {
        ObjectArrayList list = new ObjectArrayList();
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
    void addAllElementsFromSecondListIntoFirst() {
        ObjectArrayList list = new ObjectArrayList();
        list.add(4);
        list.add("lol");
        list.add(3.3,1);
        AbstractObjectArrayList listTwo = new ObjectArrayList();
        listTwo.add(5);
        listTwo.add(5.5);
        listTwo.add('a');
        list.addAll(listTwo);

        assertTrue(list.contains(5.5) && list.contains('a') && list.contains(5));
    }

    @Test
    void sizeOfTheList() {
        ObjectArrayList list = new ObjectArrayList();
        list.add(5);
        list.add(5.5);
        list.add('a');
        list.add(4L);
        list.add("lol");
        assertTrue(list.size() == 5);
    }

    @Test
    void clearAllElementsFromList() {
        ObjectArrayList list = new ObjectArrayList();
        list.add(5);
        list.add(5.5);
        list.add('a');
        list.add(4L);
        list.add("lol");
        list.clear();
        assertTrue(list.size() == 0);
    }

    @Test
    void isEmptyListOrNot() {
        ObjectArrayList list = new ObjectArrayList();
        list.add(5);
        list.add(5.5);
        list.add('a');
        list.add(4L);
        list.add("lol");
        assertFalse(list.isEmpty());
    }

    @Test
    void indexOfElementFromList() {
        ObjectArrayList list = new ObjectArrayList();
        list.add(5);
        list.add(5.5);
        list.add('a');
        list.add('a');
        list.add(4L);
        list.add("lol");
        assertTrue(list.indexOf('a') == 2);
    }

    @Test
    void lastIndexOfElementFromList() {
        ObjectArrayList list = new ObjectArrayList();
        list.add(5);
        list.add(5.5);
        list.add('a');
        list.add('a');
        list.add("lol");
        assertTrue(list.lastIndexOf('a') == 3);
    }

    @Test
    void getSubListFromAnotherList() {
        ObjectArrayList list = new ObjectArrayList();
        list.add(4);
        list.add("lol");
        list.add(3.3);
        AbstractObjectArrayList listTwo = null;
        listTwo = list.subList(0, 1);

        assertTrue(listTwo.get(0).equals(4) && list.get(1).equals("lol"));
    }

}