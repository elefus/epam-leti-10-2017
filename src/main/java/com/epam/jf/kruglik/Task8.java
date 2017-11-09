package com.epam.jf.kruglik.homework;

import java.util.Arrays;
import java.util.HashSet;

public class Task8 {
    public static HashSet<Character> numbers = null;

    static {
        numbers = new HashSet<Character>();
        numbers.addAll(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));
    }

    public static boolean getIsPoly(String str) {
        for (int i = 0; i < (str.length() / 2) + 1; ++i) {
            if (!numbers.contains(str.charAt(i)) || Character.compare(str.charAt(i), str.charAt(str.length() - i - 1)) != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int numbOfPoly = 0;
        String result = null;
        for (String i : args) {
            if (getIsPoly(i)){
                result = i;
                ++numbOfPoly;
            }
            if (numbOfPoly == 2) break;
        }
        System.out.println(result);
    }

}
