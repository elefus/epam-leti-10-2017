package com.epam.jf.kozlov.homework;

/**
 * На вход программе подается несколько строк (через параметры командной строки args).
 * Требуется упорядочить и вывести строки в порядке возрастания значений их длины.
 * В случае, если длины строк совпадают - упорядочить их в лексикографическом порядке.
 */
public class Task6 {

    /**
     * @param args анализируемые строки.
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Error: No arguments fount");
            return;
        }
        for (int i = 0; i < args.length ; i++) {
            for (int j = 0; j < args.length ; j++) {
                if(args[i].length() < args[j].length()) {
                    String tempString = args[i];
                    args[i] = args[j];
                    args[j] = tempString;
                } else if(args[i].length() == args[j].length()) {
                    if(args[i].compareTo(args[j]) < 0) {
                        String tempString = args[i];
                        args[i] = args[j];
                        args[j] = tempString;
                    }
                }
            }
        }
        for (String string:args) {
            System.out.println(string);
        }
    }
}
