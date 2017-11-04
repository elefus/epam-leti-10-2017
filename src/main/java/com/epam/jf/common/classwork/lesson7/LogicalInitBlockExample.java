package com.epam.jf.common.classwork.lesson7;

public class LogicalInitBlockExample {

    static {
        System.out.println(LogicalInitBlockExample.staticField);
    }

    public static final int staticField;

    static {
        staticField = 200;
    }

    {
        int val = 10;
        System.out.println("1" + this.field);
    }

    private final int field = initField();

    {
        System.out.println("2" + field);
    }

    {
        System.out.println("3");
    }

    public LogicalInitBlockExample() {

    }

    public LogicalInitBlockExample(int value) {
    }

    {
        System.out.println("4");
    }

    public int getField() {
        return field;
    }

    private int initField() {
        int value = 200;
        return value + 10;
    }
}

class Launcher1 {

    public static void main(String[] args) {
        LogicalInitBlockExample logicalInitBlockExample = new LogicalInitBlockExample();
        System.out.println(logicalInitBlockExample.getField());


        System.out.println(LogicalInitBlockExample.staticField);
    }
}
