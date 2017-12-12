package com.epam.jf.yessenbayev.homework;

public class Task8 {
    /**
     *
     * @param args анализируемые строки
     */
    public static void main(String[] args) {
        if (args == null || args.length < 1) {
            System.out.println("Недостаточно аргументов");
            return;
        }

        int answer = -1;
        int count = 0;
        for (String word : args) {
            if (isDigit(word)) {
                if (isPalindrome(word)) {
                    answer = count;

                    if (count == 2) {
                        break;
                    }
                }
            }
            count++;
        }

        if (answer == 0) {
            System.out.println("Числовых палнидромов нет");
        } else {
            System.out.println(args[answer]);
        }
    }

    private static boolean isPalindrome(String word) {
        for (int i = 0; i < word.length() / 2 + 1; i++) {
            if (word.charAt(i) != word.charAt(word.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isDigit(String word) {
        return word.matches("[0-9]*");
    }
}
