package com.epam.jf.common.classwork.lesson11.compare;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class ComparatorExample {

    public static void main(String[] args) {
        Person[] persons = {
                new Person("d", "t", 1),
                new Person("e", "a", 1),
                new Person("a", "a", 5),
                new Person("a", "b", 2),
        };

        sortByAge(persons);
        sortBySurname(persons);

        Arrays.sort(persons, Comparator.comparing(Person::getSurName)
                                       .thenComparing(Person::getName));
    }

    private static void sortBySurname(Person[] persons) {
        Comparator<Person> surNameComparator = new SurNameComparator();
        Arrays.sort(persons, surNameComparator);
        System.out.println(Arrays.toString(persons));
    }

    private static void sortByAge(Person[] persons) {
        Arrays.sort(persons);

        System.out.println(Arrays.toString(persons));
    }
}

class SurNameComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getSurName().compareTo(o2.getName());
    }
}

class SurNameAndNameComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        int compareToSurName = o1.getSurName().compareTo(o2.getSurName());
        return compareToSurName == 0 ? o1.getName().compareTo(o2.getName())
                                     : compareToSurName;
    }
}