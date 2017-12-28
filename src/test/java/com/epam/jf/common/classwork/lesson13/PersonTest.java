package com.epam.jf.common.classwork.lesson13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testToString() {
        Person person = Person.builder()
                              .lastName("Ivanov")
                              .firstName("Ivan")
                              .patronymic("Ivanovich")
                              .serial(0)
                              .number(1)
                              .build();

        assertEquals("Person(hidden=100, firstName=Ivan, lastName=Ivanov, patronymic=Ivanovich, serial=0, number=1)", person.toString());
    }

    @Test
    void testNameGetter() throws NoSuchMethodException {
        Person person = new Person("Ivan", "Ivanov", "Ivanovich", 0, 1);
        assertEquals("Ivan", person.getFirstName());
    }
}