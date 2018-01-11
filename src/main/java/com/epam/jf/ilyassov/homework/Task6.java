package com.epam.jf.ilyassov.homework;

public class Task6 {

    public static void main(String[] args) {
        if (args.length > 0)
            for (int i = 0; i < args.length; i++) {
                for (int j = 0; j < args.length; j++) {
                    if (args[i].length() < args[j].length()) {
                        String temp = args[i];
                        args[i] = args[j];
                        args[j] = temp;
                    } else if (args[i].length() == args[j].length()) {
                        if (LexicographicOrder(args[i], args[j])) {
                            String temp = args[i];
                            args[i] = args[j];
                            args[j] = temp;
                        }
                    }
                }
            }
        for (String s : args) {
            System.out.println(s);
        }
    }

    static boolean LexicographicOrder(String first, String second) {
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) < second.charAt(i)) {
                return true;
            } else if (first.charAt(i) > second.charAt(i))
                return false;
        }
        return true;
    }
}
