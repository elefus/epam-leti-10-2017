package com.epam.jf.Shabashov.homework.task7;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestArrayList {
    ArrayList list = new ArrayList();
    @Test
    public void addGetTest(){
        ArrayList list = new ArrayList();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        for (int i = 0; i < 100; i++) {
            assertEquals(list.get(i),i);
        }
    }

    @Test
    public void removeTest(){
        ArrayList list = new ArrayList();
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
        ArrayList list = new ArrayList();
        ArrayList list2 = new ArrayList();
        for (int i = 0; i < 100; i++) {
            list.add(i);
            list2.add(i);
        }
        assertTrue(list.containsAll(list2));
    }

    @Test
    public void sublistTest(){
        ArrayList list = new ArrayList();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        AbstractIntArrayList subList = list.subList(10, 50);
        for (int i = 10; i <= 50; i++) {
            assertEquals(subList.get(i-10),i);
        }

    }
}
