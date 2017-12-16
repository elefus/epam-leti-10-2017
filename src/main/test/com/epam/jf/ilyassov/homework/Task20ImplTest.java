package com.epam.jf.ilyassov.homework;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

class Task20ImplTest {

    @Test
    void sortPoemTest() {
        List<String> strings = new ArrayList<>();
        List<String> strings2 = new ArrayList<>();
        strings2.add("123213123");
        strings2.add("22123");
        strings2.add("12123");

        strings2.add("123213123afasf");
        strings2.add("123");
        strings2.add("1");



        IPoemImpl almas = new IPoemImpl(strings, "Almas");
        IPoemImpl yerdos = new IPoemImpl(strings2, "Yerdos");



        Set<IPoemImpl> iPoems = new LinkedHashSet<>();


        iPoems.add(almas);
        iPoems.add(yerdos);


        Task20Impl task = new Task20Impl();
        List<String> list = task.sortPoems(iPoems, "Yerdos");

        assertEquals(list.get(0),"1");
        assertEquals(list.get(1),"123");
        assertEquals(list.get(2),"22123");
        assertEquals(list.get(3),"12123");
        assertEquals(list.get(4),"123213123");
        assertEquals(list.get(5),"123213123afasf");

    }
}