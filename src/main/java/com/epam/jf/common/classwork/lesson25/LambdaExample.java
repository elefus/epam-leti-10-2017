package com.epam.jf.common.classwork.lesson25;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaExample {

    private String defaultValue = "DEFAULT";

    public LambdaExample(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public static void main(String[] args) {
        Comparator<String> stringComparator = new Comparator<String>() {

            private final String myField = "123";

            @Override
            public int compare(String o1, String o2) {
                System.out.println(this.myField);
                return Integer.compare(o1.length(), o2.length());
            }
        };



        Comparator<String> lambda = (left, right) -> Integer.compare(left.length(), right.length());
        ToString expression = value -> "123";
        expression.toString(23);

        String local = "local";

        ToString statement = value -> {
            value++;
            System.out.println(local);
            return String.valueOf(value);
        };

        Runnable run = LambdaExample::voidMethod;
        method(run);

        method(() -> System.out.println("123"));

        Comparator<String> ref = LambdaExample::compareStrings;
        int compare = ref.compare("10", "20");

        LambdaExample qwerty = new LambdaExample("qwerty");
        Runnable printQwerty = qwerty::printDefaultValue;

        printQwerty.run();

        Factory factory = LambdaExample::new;


        Printer printer = LambdaExample::printDefaultValue;
        Arrays.sort(new Integer[0], Integer::compare);
        List<String> list = Arrays.asList("a1", "c22", "b33");
        list.sort((String o1, String o2) -> Integer.compare(o1.length(), o2.length()));
        list.sort(Comparator.comparingInt(String::length));
    }

    public static void method(Runnable run) {
        new Thread(run).start();
    }

    public static int compareStrings(String left, String right) {
        return 1;
    }

    public static void voidMethod() {
        System.out.println("123");
    }

    public void printDefaultValue(LambdaExample this) {
        System.out.println(defaultValue);
    }
}

interface MyVoidInterface {

    void voidMethod();
}

@FunctionalInterface
interface ToString {

    String toString(int value);
}

@FunctionalInterface
interface Factory {

    LambdaExample create(String value);
}

@FunctionalInterface
interface Printer {

    void print(LambdaExample ref);
}