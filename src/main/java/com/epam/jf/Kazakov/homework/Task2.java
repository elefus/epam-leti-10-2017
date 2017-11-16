package main.java.com.epam.jf.Kazakov.homework;

public class Task2 {
    public static void main(String...args) {
        int maxStringLength = args[0].length();
        int indexMaxStringLength = 0;
        int minStringLength = args[0].length();
        int indexMinStringLength = 0;

        for (int i = 0; i < args.length; ++i) {
            if(args[i].length() <  minStringLength) {
                minStringLength = args[i].length();
                indexMinStringLength = i;
            }
            if(args[i].length() > maxStringLength) {
                maxStringLength = args[i].length();
                indexMaxStringLength = i;
            }
        }

        System.out.println("Минимальная строка среди представленных: " + args[indexMinStringLength]);
        System.out.println("Максимальная строка среди представленных: " + args[indexMaxStringLength]);
    }
}
