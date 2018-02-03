package com.epam.jf.plokhoi.homework;

public class Task2 {

    /**
     * Необходимо найти и вывести на экран наибольшую и наименьшую по длине строки.
     * Если строк с одинаковой длиной несколько - вывести последнюю из них.
     * Длину строки можно получить вызвав {@link String#length()}.
     * @param args Анализируемые строки.
     */
    public static void main(String...args) {
        String min = args[0];
        String max = min;

        for (int i = 1; i < args.length; ++i) {
            if (max.length() <= args[i].length()) {
                max = args[i];
            }
            if (min.length() >= args[i].length()) {
                min = args[i];
            }
        }

        System.out.println("Min string '" + min + "' with length " + min.length());
        System.out.println("Max string '" + max + "' with length " + max.length());
    }
}
