package com.epam.jf.ilyassov.homework;

public class Task4 {

    public static void main(String[] args) {
        int arr[] = new int[args.length];

        for (int k = 0; k < args.length; k++) {
            String word = args[k];
            int counter = 0;
            outer:
            for (int i = 0; i < word.length(); ++i) {
                char letter = word.charAt(i);
                for (int j = 0; j < i; ++j) {
                    if ((letter ^ word.charAt(j)) == 0) {//операция xor
                        continue outer;
                    }
                }
                counter++;
            }
            arr[k] = counter;
            counter = 0;
        }

        for (int i = 0; i < args.length; i++) {
            for (int j = 0; j < args.length; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;

                    String str = args[i];
                    args[i] = args[j];
                    args[j] = str;

                }
            }
        }
        System.out.println(args[0]);


    }

}
