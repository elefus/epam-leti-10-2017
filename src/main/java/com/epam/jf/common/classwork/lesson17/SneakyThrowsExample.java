package com.epam.jf.common.classwork.lesson17;

import lombok.SneakyThrows;

import java.io.IOException;

public class SneakyThrowsExample {

    public static void main(String[] args) {
        throwable();
    }

    @SneakyThrows
    private static void throwable() {
        try {
            throw new IOException();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        throwChecked(new IOException());
    }

    private static <T extends Throwable> void throwChecked(Throwable ex) throws T {
        throw (T)ex;
    }
}
