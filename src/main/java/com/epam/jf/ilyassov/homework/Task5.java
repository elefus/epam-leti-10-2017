package com.epam.jf.ilyassov.homework;

public class Task5 {

    public static void main(String[] args) {
        int number=0;
        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                if (method(args[i])) {
                    number++;
                }
            }
            System.out.println(number);
        }
    }

    static boolean method(String str) {
        int vowel = 0;
        int consonant = 0;
        str = str.toLowerCase();
        boolean check = false;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i'
                        || str.charAt(i) == 'o' || str.charAt(i) == 'u' || str.charAt(i) == 'y') {
                    vowel++;
                } else {
                    consonant++;
                }
            } else {
                return false;
            }
        }
        if (vowel == consonant)
            check = true;
        return check;
    }

}
