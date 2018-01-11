package com.epam.jf.common.classwork.lesson14.compatibility;

public interface Right {

    default int getValue() {
        return -200;
    }

    static int method() {
        return 100;
    }
}
