package com.epam.jf.Kuchinskii.homework;

public class Task2 {
    public static void main(String... args) {
        if (args.length > 0) {
            int minLenght = args[0].length();
            int maxLength = args[0].length();
            String min = args[0];
            String max = args[0];

            for (String arg : args) {
                if (arg.length() <= minLenght) {
                    minLenght = arg.length();
                    min = arg;
                } else if (arg.length() >= maxLength) {
                    maxLength = arg.length();
                    max = arg;
                }
            }
            System.out.println("Минимальная строка среди представленных: " + min);
            System.out.println("Максимальная строка среди представленных: " + max);
        } else System.out.println("На входе нет аргументов");
    }
}