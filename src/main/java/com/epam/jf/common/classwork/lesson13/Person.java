package com.epam.jf.common.classwork.lesson13;

import lombok.*;

// Plain
// Old
// Java
// Object
@Value
@Builder
public class Person {

    private final int hidden = 100;
    private final String firstName;
    private final String lastName;
    private final String patronymic;
    private final int serial;
    private final int number;
}
