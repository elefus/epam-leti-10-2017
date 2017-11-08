package com.epam.jf.common.classwork.lesson7;

abstract public class Point2D {
    private int x;
    private int y;

    public Point2D(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    public static int getVal() {
        return 1;
    }

    public Point2D(int size) {
        this(size, size);
        System.out.println(this.x);
        System.out.println(this.y);
    }
}

