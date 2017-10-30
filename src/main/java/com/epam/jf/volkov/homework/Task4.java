package com.epam.jf.common.homework;

/**
 * На вход программе подается несколько строк (через параметры командной строки args).
 * Каждая строка представляет собой одно слово, состоящие из символов английского алфавита.
 * Необходимо найти слово, в котором число различных символов минимально.
 *
 * Символы верхнего и нижнего регистра считать различными.
 * Если таких слов несколько, найти первое из них.
 *
 * В результате выполнения в выходной поток должно быть выведено слово, содержащее наименьшее число различных символов.
 * Наиболее эффективное с точки зрения скорости и потребляемой памяти решение - реализация с использованием битовых операций.
 * Желающие могут попробовать придумать, как их можно применить в этой задаче.
 */
public class Task4 {

    /**
     * @param args анализируемые строки.
     */
    public static void main(String[] args) {
        if (args.length>0) {
            int minimumSymbolsIndex = 0;
            for (int argIndex = 0; argIndex<args.length; argIndex++) {
                if (countSymbols(args[argIndex])<countSymbols(args[minimumSymbolsIndex])) minimumSymbolsIndex = argIndex;
            }

            System.out.println("\nWord with minumal count of unique symbols: \""+args[minimumSymbolsIndex]+"\"\n");

        } else System.out.println("\nNo args detected.\n");
    }

    private static int countSymbols(String str) {
        int uniqueChars = str.length();
        chariteration: for (int lastIndex = 0; lastIndex<str.length(); lastIndex++) {
            char lastChar = str.charAt(lastIndex);
            for (int anotherIndex = 0; anotherIndex<lastIndex; anotherIndex++) {
                char anotherChar = str.charAt(anotherIndex);
                if ((lastChar^anotherChar)==0) {
                    uniqueChars--;
                    continue chariteration;
                }
            }
        }
        return uniqueChars;
    }
}
