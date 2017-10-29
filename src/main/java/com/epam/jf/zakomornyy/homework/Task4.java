package com.epam.jf.zakomornyy.homework;

public class Task4 {

    /**
     * @param args анализируемые строки.
     */
    public static void main(String[] args) {
        if(args.length > 0) {
            int countOfDiffCharsInMinStr = Integer.MAX_VALUE;
            String strWithMinDiffCars = args[0];
            for (String str : args) {
                int currCount = countDiffChars(str);
                if (currCount < countOfDiffCharsInMinStr) {
                    strWithMinDiffCars = str;
                    countOfDiffCharsInMinStr = currCount;
                }
            }
            System.out.println(strWithMinDiffCars);
        }
    }

    public static int countDiffChars(String str) {
        int countOfDiffChars = 0;
        for(int i = 0; i < str.length(); i++){
            char currChar = str.charAt(i);
            countOfDiffChars++;
            for(int j = 0; j < i; j++){
                if(currChar == str.charAt(j)){
                    countOfDiffChars--;
                    break;
                }
            }
        }
        return countOfDiffChars;
    }
}

