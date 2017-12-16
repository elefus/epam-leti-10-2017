package com.epam.jf.ilyassov.homework;


import com.epam.jf.common.homework.Task20;

import java.util.*;

public class Task20Impl extends Task20 {

    public static void main(String[] args) {
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

        Iterator<String> iterator=list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Override
    public List<String> sortPoems(Set<IPoemImpl> poems, String author) {

        List<String> list=new ArrayList<>();

        for (IPoemImpl i : poems) {
            if(i.getAuthor().equals(author)){
                i.getLines().sort(Comparator.comparingInt(String::length));
                list=i.getLines();
            }
        }
        return list;
    }
}
