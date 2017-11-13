package com.epam.jf.common.classwork.lesson11.compare;

public class Person implements Comparable<Person> {

    private final String name;
    private final String surName;
    private final int age;
    private int serial;
    private int number;

    public Person(String name, String surName, int age) {
        this.name = name;
        this.surName = surName;
        this.age = age;
    }

    @Override
    public int compareTo(Person other) {
        return Integer.compare(age, other.age);
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return serial == person.serial && number == person.number;
    }

    @Override
    public int hashCode() {
        int result = serial;
        result = 31 * result + number;
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", age=" + age +
                '}';
    }
}
