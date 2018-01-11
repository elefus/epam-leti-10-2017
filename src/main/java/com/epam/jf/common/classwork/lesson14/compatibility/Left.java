package com.epam.jf.common.classwork.lesson14.compatibility;

public interface Left {

    default int getValue() {
        return 100;
    }

    static int method() {
        return 100;
    }
}
