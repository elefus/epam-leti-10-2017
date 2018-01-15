package com.epam.jf.common.classwork.lesson16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class OptionalExample {

    public static void main(String[] args) {
        try {
            Cloneable.class.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        List<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        integers.add(1);
        System.out.println(integers);

        Optional<String> optional = getString();
        System.out.println(optional.isPresent());
        optional.ifPresent(string -> System.out.println(string.substring(1)));

        Optional<String> optional2 = optional.filter("124"::equals);
        optional2.ifPresent(System.out::println);
    }

    private static Optional<String> getString() {
        return Optional.of("123");
    }

    private static String getStringOldStyle() {
        return null;
    }
}
