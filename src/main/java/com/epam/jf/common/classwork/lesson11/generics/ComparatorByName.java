package com.epam.jf.common.classwork.lesson11.generics;

import java.util.Comparator;

/**
 * Created by student on 13.11.2017.
 */
public class ComparatorByName implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
}
