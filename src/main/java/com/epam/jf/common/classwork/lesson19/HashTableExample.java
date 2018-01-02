package com.epam.jf.common.classwork.lesson19;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

public class HashTableExample {

    public static void main(String[] args) {
        Hashtable<String, String> ht = new Hashtable<>();
        ht.put("1", "One");
        ht.put("2", "Two");
        ht.put("3", "Three");
        ht.values().forEach(System.out::println);

        Enumeration e = ht.elements();
        while (e.hasMoreElements()) {
            System.out.println(e.nextElement());
        }

    }
}
