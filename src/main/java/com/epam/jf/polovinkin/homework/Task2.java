package com.epam.jf.polovinkin.homework;

public class Task2 {

    /**
     * Необходимо найти и вывести на экран наибольшую и наименьшую по длине строки.
     * Если строк с одинаковой длиной несколько - вывести последнюю из них.
     * Длину строки можно получить вызвав {@link String#length()}.
     * @param args Анализируемые строки.
     */
    public static void main(String...args) {
        String min = null;
        String max = null;
        for(String arg : args) {
            int length = arg.length();
            if (min == null || length <= min.length()) {
                min = arg;
            }
            if (max == null || length >= max.length()) {
                max = arg;
            }
        }
        System.out.println(min);
        System.out.println(max);
    }
}
