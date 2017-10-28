package com.epam.jf.volkov.homework;

public class StringLengthTask {
    public static void main (String...args) {
        if (args.length>0) {
            String max = args[0];
            String min = args[0];
            for (int i = 0; i<args.length; i++) {
                if (args[i].length()>=max.length()) max = args[i];
                if (args[i].length()<=min.length()) min = args[i];
            }
            System.out.println("\nString with a maximum length: "+max);
            System.out.println("String with a minimum length: "+min+"\n");
        }
    }
}