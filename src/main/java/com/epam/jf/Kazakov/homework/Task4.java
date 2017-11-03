package main.java.com.epam.jf.Kazakov.homework;

public class Task4 {
    private static int differentLettersCounter(String args) {
        boolean flag;
        int counter = 0;
        if(args.length() == 1) {
            return 0;
        }
        else {
            char[] stringToCharArray = args.toCharArray();
            for (int j = 1; j < stringToCharArray.length; j++) {
                flag = false;
                for (int k = 0; k < j; k++) {
                    if(stringToCharArray[k] == stringToCharArray[j]) {
                        flag = true;
                    }
                }
                if(!flag) {
                    ++counter;
                }
            }
        }
        return counter;
    }

    private static int leastNumber(int[] intArray) {
        int minTime = intArray[0];
        int indexMinTime = 0;
        for (int i = 0; i < intArray.length; ++i) {
            if (intArray[i] < minTime) {
                minTime = intArray[i];
                indexMinTime = i;
            }
        }
        return indexMinTime;
    }
    
    public static void main(String[] args) {
        int[] stringLength = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            stringLength[i] = differentLettersCounter(args[i]);
        }
        System.out.println("Слово с наименьшим числом различных символов: " + args[leastNumber(stringLength)]);
    }
}
