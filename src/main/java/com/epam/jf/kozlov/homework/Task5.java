package com.epam.jf.kozlov.homework;

/**
 * На вход программе подается несколько строк (через параметры командной строки args).
 * Каждая строка представляет собой одно слово.
 * В результате выполнения в выходной поток должно быть выведено количество слов,
 * состоящих только из символов латинского алфавита и содержащих равное количество гласных и согласных букв.
 * Количество различных вхождений одной буквы в слове учитывается.
 * Входные данные:
 * args = ["Язык", "программирования", "Java", "is", "widespread"]
 * Выходные данные:
 * 2
 */
public class Task5 {

    /**
     * @param args анализируемые строки.
     */
    public static void main(String[] args) {
        // TODO решение задачи
        if (args.length == 0) {
            System.out.println("Error: No arguments found");
            return;
        }
        int stringNum = 0;
        for (String arg : args) {
            if (vowelAndConsonantCount(arg)) {
                stringNum++;
            }
        }
        System.out.println("Number of strings: " + stringNum);
    }

    private static boolean vowelAndConsonantCount(String string) {
        int vowels = 0;
        int consonant = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) >= 'a' && string.charAt(i) <= 'z' || string.charAt(i) >= 'A' && string.charAt(i) <= 'Z') {
                switch (string.charAt(i)) {
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                    case 'y':
                    case 'A':
                    case 'E':
                    case 'I':
                    case 'O':
                    case 'U':
                    case 'Y':
                        vowels++;
                        break;
                    default:
                        consonant++;
                }
            } else {
                return false;
            }
        }
        return vowels == consonant;
    }
}