package com.epam.jf.common.classwork.lesson6;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Scanner;

/**
 * top-level class
 * Код с занятия 01.11.2017.
 *
 * Примеры javadoc
 */
public class Lesson6 {

    /** Ответ на главный вопрос вселенной и всего всего остального. */
    private static int value = 42;


    public static void main(String[] args) {
//        nullableExample();
//        for (int i : getValues()) {
//            System.out.println(i);
//        }
//        Optional<Integer> integer = Optional.of(1);

        Lesson6 obj = null;
        obj.getValues();

    }

    private static void nullableExample() {
        Scanner scanner = new Scanner(System.in);
        @NotNull String string = scanner.nextLine();
//        @NotNull String str1 = method(string);
    }

    /**
     * {@code int a = 30;}
     * Value = {@value Lesson6#value}
     * asdsad {@link Lesson6#getValues()}
     * @param string
     * @param a
     * @param b
     * @param j
     * @return
     * @throws IllegalAccessError
     * @throws NullPointerException
     * @see <a href="https://jcp.org/en/jsr/detail?id=335">JSR-335: Lambda Expressions for the Java Programming Language</a>
     * @see Lesson6#isCellEditable(int)
     *
     */
    public static @Nullable String method(@NotNull String string, int a, double b, int j) throws IllegalAccessError, NullPointerException {
        System.out.println(string);
        return "123";
    }

    private static int[] getValues() {
        return new int[0];
    }

    /**
     * Проверяет, является ли ячейка редактируемой.
     * 123<br>
     * 1232<br>
     * 2323<br>
     *
     * @param numberColumn номер колонки для проверки.
     * @return true - ячейка редактируема, иначе false.
     */
    public boolean isCellEditable(int numberColumn) {
        Child child = new Child();
        child.method(5);
        return numberColumn % 2 == 0;
    }

    /**
     * inner-class
     */
    private class A {

    }

    /**
     * nested-class
     */
    protected static class Parent {


        /**
         * I'm parent
         * @param value val
         * @return ret
         * @throws RuntimeException abc
         * @see Lesson6
         * @since 1.6
         */
        public int method(int value) throws RuntimeException {
            return value;
        }

    }

    private static class Child extends Parent {

        /**
         * 3333
         * {@inheritDoc}
         * 123
         *
         */
        @Override
        public int method(int value) throws RuntimeException {
            return super.method(value);
        }
    }
}





