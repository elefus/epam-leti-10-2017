package com.epam.jf.common.classwork.lesson17;

import lombok.SneakyThrows;

import java.io.IOException;

public class SneakyThrowsExample {

    public static void main(String[] args) {
        throwable();
    }

    @SneakyThrows
    private static void throwable() {
        throw new IOException();
//        throwChecked(new IOException());
    }

    private static <T extends Throwable> void throwChecked(Throwable ex) throws T {
        throw (T)ex;
    }
}
