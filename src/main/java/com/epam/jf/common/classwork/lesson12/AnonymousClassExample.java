package com.epam.jf.common.classwork.lesson12;

import java.util.Date;

public class AnonymousClassExample {

    public static void main(String[] args) {
        Date date = new Date() {

            public int fieldA = 400;

            @Override
            public String toString() {
                getDate1();
                return "new version toString method";
            }

            private Date getDate1() {
                return null;
            }
        }.getDate1();
        System.out.println(date.getClass());

        new Thread() {
            @Override
            public void run() {
                super.run();
            }
        }.start();
    }
}
