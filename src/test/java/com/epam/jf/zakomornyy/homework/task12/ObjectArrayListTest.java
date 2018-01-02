package java.com.epam.jf.zakomornyy.homework.task12;



import com.epam.jf.zakomornyy.homework.task12.ObjectArrayList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ObjectArrayListTest {
    @Test
    void add() {
        ObjectArrayList list = new ObjectArrayList(0);
        Object obj = new Object();

        list.add(obj);
        assertEquals(obj, list.get(0));
    }

    @Test
    void add1() {
    }

    @Test
    void get() {
    }

    @Test
    void contains() {
    }

    @Test
    void containsAll() {
    }

    @Test
    void remove() {
    }

    @Test
    void remove1() {
    }

    @Test
    void removeAll() {
    }

    @Test
    void set() {
    }

    @Test
    void addAll() {
    }

    @Test
    void clear() {
    }

    @Test
    void size() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void indexOf() {
    }

    @Test
    void lastIndexOf() {
    }

    @Test
    void subList() {
    }

    @Test
    void trimToSize() {
    }

}