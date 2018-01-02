package com.epam.jf.Shabashov.homework.task12;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestObjectArrayList {
    @Test
    public void addGetTest(){
        ObjectArrayList list = new ObjectArrayList();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        for (int i = 0; i < 100; i++) {
            assertEquals(list.get(i),i);
        }
    }

    @Test
    public void removeTest(){
        ObjectArrayList list = new ObjectArrayList();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        list.remove(0);
        list.remove(98);
        list.remove(50);
        for (int i = 0; i < 50; i++) {
            assertEquals(list.get(i),i+1);
        }
        for (int i = 50; i < 97; i++) {
            assertEquals(list.get(i),i+2);
        }
    }

    @Test
    public void contatinsTest(){
        ObjectArrayList list = new ObjectArrayList();
        ObjectArrayList list2 = new ObjectArrayList();
        for (int i = 0; i < 100; i++) {
            list.add(i);
            list2.add(i);
        }
        assertTrue(list.containsAll(list2));
    }

    @Test
    public void sublistTest(){
        ObjectArrayList list = new ObjectArrayList();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        AbstractObjectArrayList subList = list.subList(10, 50);
        for (int i = 10; i <= 50; i++) {
            assertEquals(subList.get(i-10),i);
        }

    }
}
