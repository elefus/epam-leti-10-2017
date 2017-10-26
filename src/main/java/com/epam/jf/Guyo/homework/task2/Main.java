package com.company;

public class Main {

    public static void main(String[] args) {

        int minStringLength = args[0].length();
        int maxStringLength = args[0].length();
        int count1 = 0;
        int count2 = 0;

        for (int i = 1; i < args.length; i++) {
            if (args[i].length() <= minStringLength) {
                minStringLength = args[i].length();
                count1 = i;
            }
        }

        for (int j = 1; j < args.length; j++) {
            if (args[j].length() >= maxStringLength) {
                maxStringLength = args[j].length();
                count2 = j;
            }
        }

        System.out.println("Min string is " + args[count1]);
        System.out.println("Max string is " + args[count2]);
    }
}
