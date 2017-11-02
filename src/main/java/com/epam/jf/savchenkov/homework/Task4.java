package com.epam.jf.savchenkov.homework;


/**
 * На вход программе подается несколько строк (через параметры командной строки args).
 * Каждая строка представляет собой одно слово, состоящие из символов английского алфавита.
 * Необходимо найти слово, в котором число различных символов минимально.
 * <p>
 * Символы верхнего и нижнего регистра считать различными.
 * Если таких слов несколько, найти первое из них.
 * <p>
 * В результате выполнения в выходной поток должно быть выведено слово, содержащее наименьшее число различных символов.
 * Наиболее эффективное с точки зрения скорости и потребляемой памяти решение - реализация с использованием битовых операций.
 * Желающие могут попробовать придумать, как их можно применить в этой задаче.
 */
public class Task4 {

    /**
     * @param args анализируемые строки.
     */
    public static void main(String[] args) {
        String answer = args[0];
        for (String str: args) {
            if (uniqueLetters(str) < uniqueLetters(answer)) {
                answer = str;
            }
        }
        System.out.println(answer);
    }

    /**
     * @param str анализируемая строка
     * @return количестко  уникальный символов в строке
     */
    public static int uniqueLetters(String str) {
        StringBuilder buf = new StringBuilder();
        String ch;
        for (int i = 0; i < str.length(); i++) {
            ch = String.valueOf(str.charAt(i));
            if (buf.indexOf(ch) == -1) {
                buf.append(ch);
            }
        }
        return buf.length();
    }
}
