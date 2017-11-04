package com.epam.jf.burachenko.homework;

/**
 * На вход программе подается несколько строк (через параметры командной строки args).
 * Требуется упорядочить и вывести строки в порядке возрастания значений их длины.
 * В случае, если длины строк совпадают - упорядочить их в лексикографическом порядке.
 */
public class Task6 {
    /**
     * Метод сравнивает одинаковые по длине строки по лексикографическому признаку
     * @param s1 первая сравниваемая строка
     * @param s2 вторая сравниваемая строка
     * @return true - s1 первее в лексикографическом порядке, чем s2
     *         false - s2 первее в лексикографическом порядке, чем s1, или s1 и s2 одинаковые строки
     */
    private static boolean isFirstInAlphabet(String s1, String s2) {
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                if(s1.charAt(i) < s2.charAt(i)) {
                    return true;
                }
                else {
                    return false;
                }
            }
        }
        return false;
    }

    /**
     * @param args анализируемые строки.
     */
    public static void main(String[] args) {
        // TODO решение задачи
        String temp;
        for(int i = 0; i < args.length-1; i++) {
            for(int j = i+1; j < args.length; j++) {
                if(args[j].length() < args[i].length() || args[j].length() == args[i].length() && isFirstInAlphabet(args[i], args[j])) {
                    temp = args[j];
                    args[j] = args[i];
                    args[i] = temp;
                }
            }
        }

        for(String word: args) {
            System.out.println(word);
        }
    }
}

