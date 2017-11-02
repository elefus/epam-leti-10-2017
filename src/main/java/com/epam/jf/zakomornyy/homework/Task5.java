package com.epam.jf.zakomornyy.homework;

import java.util.LinkedList;

public class Task5 {

    /**
     * @param args анализируемые строки.
     */
    public static void main(String[] args) {
        LinkedList<String> onlyLatinLetters = getLatinStrings(args);
        System.out.println(numOfStrWithEqualNumOfVowAndConsLetters(onlyLatinLetters));
    }

    public static LinkedList<String> getLatinStrings(String[] args){
        LinkedList<String> onlyLatinStrings = new LinkedList<>();
        for (String str: args) {
            if(consistOnlyLatinLetters(str)) {
                onlyLatinStrings.add(str);
            }
        }
        return onlyLatinStrings;
    }

    public static boolean consistOnlyLatinLetters(String str) {
        for (char letter: str.toCharArray()) {
            if((letter < 'A' || letter > 'Z') && (letter < 'a' || letter > 'z')) {
                return false;
            }
        }
        return true;
    }

    public static int numOfStrWithEqualNumOfVowAndConsLetters(LinkedList<String> onlyLatinLetters) {
        char[] vowelLetters = {'a', 'e', 'i', 'o', 'u', 'y'};
        int count = 0;
        for (String str: onlyLatinLetters) {
            int charCounter = 0;
            String strInLowCase = str.toLowerCase();
            /* можно было не использовать метку, тогда пришлось бы в блоке if для проверки на гласную писать
             charCounter += 2; break; что снизило бы читаемость, стоило ли он того?
            */
            outer: for (char letter: strInLowCase.toCharArray()) {
                for (char vowelLetter : vowelLetters) {
                    if (vowelLetter == letter) {
                        charCounter++;
                        continue outer;
                    }
                }
                charCounter--;
            }
            if(charCounter == 0) {
                count++;
            }
        }
        return count;
    }
}
