package com.epam.jf.common.classwork.lesson16;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternExample {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("(1*0)(p*)");

        String[] result = pattern.split("a111110b");
        System.out.println(Arrays.toString(result));


        Matcher matcher = pattern.matcher("110b 10");
        System.out.println(matcher.matches());
        System.out.println(matcher.lookingAt());

        matcher.reset();
        if (matcher.find()) {
            System.out.println(matcher.group());
            System.out.println(matcher.start());
            System.out.println(matcher.end());
        }

        if (matcher.find(1)) {
            System.out.println(matcher.group());
            System.out.println(matcher.start());
            System.out.println(matcher.end());
        }

        System.out.println(matcher.groupCount());
        System.out.println(matcher.group(2));
        System.out.println(matcher.start(2));
        System.out.println(matcher.end(2));

        Pattern p = Pattern.compile(" J(\\w*)", Pattern.CASE_INSENSITIVE);
    }
}
