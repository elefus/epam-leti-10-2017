package com.gubadev.task1p2;

public class CommandLineArgs {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Недостаточно аргументов для выполнения задания");
            return;
        }

        int minLength = Integer.MAX_VALUE;
        int maxLength = 0;
        int minPosition = 0;
        int maxPosition = 0;
        for(int i = 0; i < args.length; i++){
            if(args[i].length() <= minLength){
                minLength = args[i].length();
                minPosition = i;
            }
            if(args[i].length() >= maxLength){
                maxLength = args[i].length();
                maxPosition = i;
            }
        }

        if(minPosition == maxPosition) {
            System.out.println("Все строки одинаковой длины!!!");
        } else {
            System.out.println("Минимальная строка среди представленных: " + args[minPosition]);
            System.out.println("Максимальная строка среди представленных: " + args[maxPosition]);
        }

    }

}
