package com.epam.jf.volkov.homework;

public class Task2 {
    public static void main (String...args) {
        if (args.length>0) {
            String max = args[0];
            String min = args[0];
            for (String curr : args) {
                if (curr.length()>=max.length()) max = curr;
                if (curr.length()<=min.length()) min = curr;
            }
            System.out.println("\nString with a maximum length: "+max);
            System.out.println("String with a minimum length: "+min+"\n");
        } else System.out.println("No args detected");
    }
}