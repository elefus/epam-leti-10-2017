package com.epam.jf.common.classwork.lesson8;

public class Person {

    private final String firstName;
    private final String lastName;
    private final String patronymic;
    private final int serial;
    private final int number;

    public Person(String firstName, String lastName, String patronymic, int serial, int number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.serial = serial;
        this.number = number;
    }

    @Override
    public boolean equals(Object other) {
        return super.equals(other)
            || !(other == null || getClass() != other.getClass())
            && serial == ((Person) other).serial
            && number == ((Person) other).number;
    }
}
