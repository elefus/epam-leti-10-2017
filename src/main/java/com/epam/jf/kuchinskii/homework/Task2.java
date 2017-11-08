package com.epam.jf.kuchinskii.homework;

public class Task2 {
    /**
     * Необходимо найти и вывести на экран наибольшую и наименьшую по длине строки.
     * Если строк с одинаковой длиной несколько - вывести последнюю из них.
     * Длину строки можно получить вызвав {@link String#length()}.
     * @param args Анализируемые строки.
     */
    public static void main(String... args) {
        if (args.length > 0) {
            int minLenght = args[0].length();
            int maxLength = minLenght;
            String min = args[0];
            String max = min;

            for (String arg : args) {
                if (arg.length() <= minLenght) {
                    minLenght = arg.length();
                    min = arg;
                }
                if (arg.length() >= maxLength) {
                    maxLength = arg.length();
                    max = arg;
                }
            }
            System.out.println("Минимальная строка среди представленных: " + min);
            System.out.println("Максимальная строка среди представленных: " + max);
        } else {
            System.out.println("На входе нет аргументов");
        }
    }
}