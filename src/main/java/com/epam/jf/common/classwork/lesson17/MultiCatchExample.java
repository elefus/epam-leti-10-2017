package com.epam.jf.common.classwork.lesson17;

import java.io.IOException;

public class MultiCatchExample {

    public static void main(String[] args) throws IOException {
        try {
            if (true) {
                throw new IOException();
            } else {
                throw new IllegalAccessException();
            }
        } catch (IOException ex) {
            // ...
            ex = new IOException();
            throw ex;
        } catch (final IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
