package com.epam.jf.common.classwork.lesson16;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

public class ExceptionExample {

    private static final IOException ex = new IOException();

    public static void main(String[] args) {
        try {
            throw new IOException();
        } catch (FileNotFoundException ex) {
            System.out.println("___");
        } catch (IOException e) {
            System.out.println("___");
        } catch (Exception e) {
            System.out.println("___");
        } catch (Throwable e) {
            System.out.println("___");
        }

        try {
            throwIOEx();
        } catch (IOException ex) {
            System.out.println(System.identityHashCode(ex));
            ex.printStackTrace();
        }
    }

    private static void throwIOEx() throws IOException {
        ex.fillInStackTrace();
        System.out.println(System.identityHashCode(ex));
        throw ex;
    }

}

