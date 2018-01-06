package com.epam.jf.common.classwork.lesson12;

public class StringBuilderExample {

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        builder.append("123")
               .append("123")
               .insert(0, "12");
    }
}
