package com.epam.jf.common.classwork.lesson13;

import com.epam.jf.common.classwork.lesson11.compare.Person;

import java.util.Arrays;

public class EnumExample {

    public static void main(String[] args) {
        System.out.println(Season.class.isEnum());

        SeasonClass winter1 = new SeasonClass("WiNTER");
        SeasonClass winter2 = new SeasonClass("WiNTER");

        System.out.println(winter1 == winter2);


        System.out.println(Season.WiNTER == Season.WiNTER);
        System.out.println(Season.SUMMER.compareTo(Season.WiNTER));
        System.out.println(Season.WiNTER.ordinal());
        System.out.println(Season.FALL.ordinal());
        Season.WiNTER.printHello();

        PersonFactory factory = PersonFactoryImpl.INSTANCE;
        factory.create("123", "123", 123);

        System.out.println(Arrays.toString(Season.values()));
        System.out.println(Season.valueOf("WiNTER"));
        Season winter = Enum.valueOf(Season.class, "WiNTER");
        System.out.println(winter);
    }
}

interface PersonFactory {

    Person create(String name, String surName, int age);
}

enum PersonFactoryImpl implements PersonFactory {
    INSTANCE {
        @Override
        public Person create(String name, String surName, int age) {
            return new Person(name, surName, age);
        }
    }
}

enum Season {
    WiNTER("Winter hello") {
        {
            System.out.println("123");
        }

        @Override
        boolean isCold() {
            myMethod();
            return false;
        }

        public void myMethod() {

        }

        @Override
        public String toString() {
            return super.toString().toLowerCase();
        }
    },
    SPRING("Spring hello") {
        @Override
        boolean isCold() {
            return false;
        }
    },
    SUMMER("Summer hello") {
        @Override
        boolean isCold() {
            return false;
        }
    },
    FALL("Fall hello") {
        @Override
        boolean isCold() {
            return false;
        }
    };

    Season(String greeting) {
        this.greeting = greeting;
    }

    static {
        System.out.println("123");
    }

    {
        System.out.println("Non static");
    }

    public static void method() {}

    abstract boolean isCold();

    public void printHello() {
        System.out.println(greeting);
    }

    private final String greeting;
}

class SeasonClass {

    private final String title;

    SeasonClass(String title) {
        this.title = title;
    }
}

