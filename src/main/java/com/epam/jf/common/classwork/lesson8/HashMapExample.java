package com.epam.jf.common.classwork.lesson8;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {

    public static void main(String[] args) {
        Map<Person, String> map = new HashMap<>();


        Person person1 = new Person("a", "a", "a", 0, 0);
        System.out.println(person1.hashCode());
        System.out.println(person1);

        Person person2 = new Person("b", "b", "b", 0, 0);
        System.out.println(person2);

        System.out.println(person1 == person2);      // false
        System.out.println(person1.equals(person2)); // true

        map.put(person1, "person1");


        System.out.println(person1.hashCode());


        String result1 = map.get(person1);
        System.out.println(result1);

        String result2 = map.get(person2);
        System.out.println(result2);

    }
}
