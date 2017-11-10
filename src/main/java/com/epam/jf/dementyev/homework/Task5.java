package com.epam.jf.dementyev.homework;

/**
 * На вход программе подается несколько строк (через параметры командной строки args).
 * Каждая строка представляет собой одно слово.
 * В результате выполнения в выходной поток должно быть выведено количество слов,
 * состоящих только из символов латинского алфавита и содержащих равное количество гласных и согласных букв.
 *
 * Количество различных вхождений одной буквы в слове учитывается.
 *
 * Входные данные:
 * args = ["Язык", "программирования", "Java", "is", "widespread"]
 *
 * Выходные данные:
 * 2
 */
public class Task5 {

    /**
     * @param args анализируемые строки.
     */
    public static void main(String[] args) {
        if (args.length > 0) {
            int count = 0;
            for (String word : args) {
                if (isCorrectWord(word)) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    private static boolean isCorrectWord(String word) {
        int len = word.length();
        NotLatin:
        if ((len & 1) == 0) {
            int diff = 0;
            for (int i = 0; i < len && Math.abs(diff) <= len - i; i++) {
                char c = word.charAt(i);
                if ("aeiouAEIOU".indexOf(c) != -1) {
                    diff++;
                } else if ("bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ".indexOf(c) != -1) {
                    diff--;
                } else {
                    break NotLatin;
                }
            }
            if (diff == 0) {
                return true;
            }
        }
        return false;
    }
}