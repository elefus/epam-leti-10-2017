package com.epam.jf.zakomornyy.homework;

public class Task8 {

    /**
     * @param args анализируемые строки.
     */
    public static void main(String[] args) {
        String numPalindrom = findNumPalindrom(args);
        if(numPalindrom != null) {
            System.out.println(numPalindrom);
        } else {
            System.out.println("Number palindrom is not found");
        }
    }

    private static String findNumPalindrom(String[] args) {
        String numPalindrom = null;
        for (String str : args) {
            if(isNumPalindrom(str)) {
                if(numPalindrom == null) {
                    numPalindrom = str;
                } else {
                    numPalindrom = str;
                    break;
                }
            }
        }
        return numPalindrom;
    }

    public static boolean isNumPalindrom(String str) {
        char[] charArray = str.toCharArray();
        for(int i = 0; i < charArray.length/2; i++) {
            if(charArray[i] != charArray[charArray.length - i - 1]
                    || charArray[i] < '0' || charArray[i] > '9'
                    || charArray[charArray.length - i - 1] < '0' || charArray[charArray.length - i - 1] > '9') {
                return false;
            }
        }
        if(charArray.length % 2 == 1
                && (charArray[charArray.length/2] < '0'
                || charArray[charArray.length/2] > '9')) {
            return false;
        }
        return true;
    }
}

