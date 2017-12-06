package com.epam.jf.common.classwork.lesson14.lambda;

import java.util.function.Function;

@FunctionalInterface
public interface Summator {

    int sum(int a, int b);

    default void method1() {

    }

    static void method2() {

    }
}

class Launcher {

    private final int finalValue = 42;

    public void main(Object a, int b) {

    }
    public static void main(String[] args) {
        Comparable<String> comparable = o -> 0;

        Summator summator = (int a, int b) -> a + b;
        Summator summatorStatement = (a, b) -> {
            System.out.println(a + " " + b);
            return a + b;
        };
        printSum(summator, 10, 20);

        Function<String, Integer> stringLength = String::length;
        Function<Integer, Double> intToDouble = Double::valueOf;
        Function<String, Double> stringTouDouble = stringLength.andThen(intToDouble);
        Function<Double, String> doubleToString = String::valueOf;
        Function<String, String> a = stringLength.andThen(intToDouble).andThen(doubleToString);
        System.out.println(a.apply("10"));
    }

    public static void printSum(Summator summator, int a, int b) {
        System.out.println(summator.sum(a, b));
    }

    public void method() {

        Summator summator = (int a, int b) -> this.finalValue + a + b;


        int value = 50;

        Runnable runnable = new MyRunnable(value);
        Runnable anonymousRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(value);
            }
        };
        Runnable lambdaRunnable1 = () -> System.out.println(value);
        Runnable lambdaRunnable2 = () -> System.out.println(this.finalValue);

        Function<Launcher, Integer> getter = Launcher::getFinalValue;
    }

    public int getFinalValue(Launcher this) {
        return finalValue;
    }
}

class MyRunnable implements Runnable {

    private final int value;

    MyRunnable(int value) {
        this.value = value;
    }

    @Override
    public void run() {
        System.out.println(value);
    }
}
