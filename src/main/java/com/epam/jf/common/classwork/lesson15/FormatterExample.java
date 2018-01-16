package com.epam.jf.common.classwork.lesson15;

import java.util.Date;
import java.util.Formatter;

public class FormatterExample {

    public static void main(String[] args) {
        int hex = 0xFF;
        int octal = 010;

        System.out.println(System.lineSeparator().length());
        System.out.printf("%d %<d %<s %s %d %n", 1, "abc", 3);

        Formatter formatter = new Formatter();

        int i1 = 17;
        double d1 = 16.78967;
        formatter.format("1. (%%o) %o%n", i1);
        formatter.format("2. (%%a) %a%n", d1);
        formatter.format("3. (%%x) %x%n", i1);

        formatter.format("4. (%%#o) %#o%n", i1);
        formatter.format("5. (%%#a) %#a%n", d1);
        formatter.format("6. (%%#x) %#x%n", i1);
        System.out.println(formatter);

        i1 = 345000000;
        d1 = 16.0;
        formatter.format("- %-7dok%n", i1);
        formatter.format("- %-,7dok%n", i1);
        formatter.format("- %+7dok%n", i1);
        formatter.format("- % 7dok%n", i1);
        formatter.format("- %07dok%n", i1);
        formatter.format("- %fok%n", d1);
        formatter.format("- %#fok%n", d1);
        formatter.format("- %.2fok%n", d1);
        System.out.println(formatter);


        Date date = new Date();
        System.out.println(date);
        Date nextHour = new Date(System.currentTimeMillis() + 1000 * 60 * 60);
        System.out.println(nextHour);

    }
}
